package kg.itacademy.protection.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@Table(name = "children_parents")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParentEntity extends BaseEntity {
//    @Column(name = "name", nullable = false)
//    String name;
//
//    @Column(name = "number", nullable = false)
//    String number;

    @OneToOne
    @JoinColumn(name = "parent_id", nullable = false)
    UserEntity parentId;

    @OneToOne
    @JoinColumn(name = "child_id", nullable = false)
    UserEntity childId;
}
