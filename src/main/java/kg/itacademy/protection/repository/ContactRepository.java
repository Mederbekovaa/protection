package kg.itacademy.protection.repository;

import kg.itacademy.protection.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    ContactEntity getByName( String contactName);
}
