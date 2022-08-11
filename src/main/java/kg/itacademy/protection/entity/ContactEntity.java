package kg.itacademy.protection.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "contacts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactEntity extends BaseEntity {
    @Column(name = "name", nullable = false , unique = true)
    String name;

    @Column(name = "contact" , nullable = false)
    String contact;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;
}
