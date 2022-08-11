package kg.itacademy.protection.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRoleModel {
    Long userId;
    Long roleId;
}
