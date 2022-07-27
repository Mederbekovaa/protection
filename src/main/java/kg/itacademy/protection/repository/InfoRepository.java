package kg.itacademy.protection.repository;

import kg.itacademy.protection.entity.InfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfoRepository extends JpaRepository<InfoEntity, Long> {
    InfoEntity getByName( String infoName);
}
