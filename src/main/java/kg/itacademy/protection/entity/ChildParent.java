package kg.itacademy.protection.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Builder
@Table(name = "children_parents")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChildParent extends BaseEntity  {
    @OneToOne
    @JoinColumn(name = "parent_id", nullable = false)
    UserEntity parentId;

    @OneToOne
    @JoinColumn(name = "child_id", nullable = false)
    UserEntity childId;
}
