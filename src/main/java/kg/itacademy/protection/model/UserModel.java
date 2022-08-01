package kg.itacademy.protection.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserModel {
    @NotBlank
    private String login;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String token;

    @NotBlank
    private String role;

}
