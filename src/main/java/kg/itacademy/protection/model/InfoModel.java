package kg.itacademy.protection.model;

import kg.itacademy.protection.entity.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InfoModel {
    @NotNull
    private Long id;
    private String name;
    private String age;
    private String number;
    private String address;
    UserEntity userId;
}
