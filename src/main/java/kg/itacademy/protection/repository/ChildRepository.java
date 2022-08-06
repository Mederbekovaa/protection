package kg.itacademy.protection.repository;

import kg.itacademy.protection.entity.ChildEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChildRepository extends JpaRepository<ChildEntity, Long> {
//    ChildEntity getByEmail();
}
