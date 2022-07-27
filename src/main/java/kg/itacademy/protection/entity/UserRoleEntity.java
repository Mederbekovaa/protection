package kg.itacademy.protection.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users_role")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRoleEntity extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "user_id", nullable  = false)
    UserEntity user;

    @OneToOne
    @JoinColumn(name = "role_id", nullable = false)
    RoleEntity role;
}
