package kg.itacademy.protection.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
//@Builder
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity extends BaseEntity {
    @Column(name = "login", unique = true)
    String login;

    @Column(name = "email", nullable = false, unique = true)
    String email;

    @Column(name = "password", nullable = false, unique = true)
    String password;

    @Column(name = "token", nullable = false)
    String token;

}
