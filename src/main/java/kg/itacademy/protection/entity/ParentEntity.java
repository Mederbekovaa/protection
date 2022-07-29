package kg.itacademy.protection.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "parents")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParentEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "number", nullable = false)
    String number;

}
