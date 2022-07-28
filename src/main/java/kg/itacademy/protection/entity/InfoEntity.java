package kg.itacademy.protection.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@Table(name = "info")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InfoEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    String name;

    @Column(name = "age", nullable = false)
    String age;

    @Column(name = "number", nullable = false)
    String number;

    @Column(name = "address", nullable = false)
    String address;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    UserEntity userId;
}
