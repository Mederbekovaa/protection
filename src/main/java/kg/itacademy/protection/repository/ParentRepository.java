package kg.itacademy.protection.repository;

import kg.itacademy.protection.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<ParentEntity, Long> {
    ParentEntity getByName(String parentName);
}
