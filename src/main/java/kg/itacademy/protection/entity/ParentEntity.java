package kg.itacademy.protection.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

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

}
