package kg.itacademy.protection.model;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChildModel {
    @NotBlank
    private String code;
    private boolean isConfirmed;
}
