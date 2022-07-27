package kg.itacademy.protection.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserModel {
    private String email;
    private String login;
    private String password;
    private boolean isActive;
}
