package kg.itacademy.protection.repository;

import kg.itacademy.protection.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<RoleEntity,Long > {
    RoleEntity getByNameRole(String nameRole);
}
