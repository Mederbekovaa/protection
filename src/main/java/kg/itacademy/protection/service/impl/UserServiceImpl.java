package kg.itacademy.protection.service.impl;

import kg.itacademy.protection.entity.UserEntity;
import kg.itacademy.protection.entity.UserRoleEntity;
import kg.itacademy.protection.exception.user.UserNameNotFoundException;
import kg.itacademy.protection.exception.user.UserSignInException;
import kg.itacademy.protection.mapper.UserMapper;
import kg.itacademy.protection.model.TokenModel;
import kg.itacademy.protection.model.UserAuthModel;
import kg.itacademy.protection.model.UserModel;
import kg.itacademy.protection.repository.RoleRepository;
import kg.itacademy.protection.repository.UserRepository;
import kg.itacademy.protection.repository.UserRoleRepository;
import kg.itacademy.protection.service.UserService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserServiceImpl implements UserService {
    final UserRepository userRepository;

    final RoleRepository roleRepository;

    final UserRoleRepository userRoleRepository;


    final PasswordEncoder passwordEncoder;

    @Override
    public TokenModel getAuthToken(UserAuthModel userAuthDto) {
        UserEntity userEntity = userRepository
                .getByLogin(userAuthDto.getLogin());
         if (userEntity == null) {
            throw new UserNameNotFoundException("Username not found");
        }
        boolean isMatches = passwordEncoder.matches(userAuthDto.getPassword(), userEntity.getPassword());
        if (isMatches) {
            return TokenModel.builder()
                    .token("Basic " + new String(Base64.getEncoder().encode((userEntity.getLogin() + ":" + userAuthDto.getPassword()).getBytes())))
                    .userId(userEntity.getId())
                    .login(userEntity.getLogin())
                    .build();
        } else {
            throw new UserSignInException("Неправильный логин или пароль!", HttpStatus.UNAUTHORIZED);
        }
    }

    @Override
    public TokenModel register(UserModel userModel) {
        UserEntity userEntity = UserMapper.INSTANCE.toEntity(userModel);

        UserRoleEntity userRoleEntity = new UserRoleEntity();
        if (userModel.getRole().contains("ROLE_PARENT")) {
            userRoleEntity.setRole(roleRepository.getByNameRole("ROLE_PARENT"));
        } else {
            userRoleEntity.setRole(roleRepository.getByNameRole("ROLE_CHILD"));
        }
        userEntity.setToken(
                "Basic " + new String(Base64.getEncoder()
                        .encode((userEntity.getLogin() + ":" + userModel.getPassword()).getBytes()))
        );
        userRoleEntity.setUser(userRepository.save(userEntity));
        userRoleRepository.save(userRoleEntity);

        return TokenModel.builder()
                .token(userEntity.getToken())
                .login(userEntity.getLogin())
                .userId(userEntity.getId()).build();
    }
}
