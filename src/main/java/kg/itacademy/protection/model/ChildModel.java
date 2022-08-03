package kg.itacademy.protection.model;

import kg.itacademy.protection.entity.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChildModel {
    @NotBlank
    UserEntity child;

    private String code;

    private boolean isConfirmed;

    UserEntity parent;
}
