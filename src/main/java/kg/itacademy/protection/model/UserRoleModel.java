package kg.itacademy.protection.model;

import kg.itacademy.protection.entity.RoleEntity;
import kg.itacademy.protection.entity.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRoleModel {
    UserEntity user;
    RoleEntity role;
}
