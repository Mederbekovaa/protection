package kg.itacademy.protection.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactModel {

    @NotNull
    private Long id;
    private String name;
    private String contact;
    private Long userId;
}
