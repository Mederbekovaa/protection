package kg.itacademy.protection.repository;

import kg.itacademy.protection.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<UserEntity, Long> {
    UserEntity getByLogin(String login);
    UserEntity getByEmail(String email);
}
