package kg.itacademy.protection.mapper;

import kg.itacademy.protection.entity.UserEntity;
import kg.itacademy.protection.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserEntity toEntity(UserModel userModel);

    UserModel toModel(UserEntity userEntity);

    List<UserModel> toUserModels(List<UserEntity> userEntityList);
}
