package kg.itacademy.protection.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "children")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChildEntity extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    UserEntity child;

    @Column(name = "code")
    String code;

    @Column(name = "is_confirmed")
    Boolean isConfirmed = false;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    UserEntity parent;
}
