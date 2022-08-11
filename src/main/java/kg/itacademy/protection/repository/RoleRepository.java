package kg.itacademy.protection.repository;

import kg.itacademy.protection.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity getByNameRole(String nameRole);

    @Query(nativeQuery = true, value =
            "\tr.name_role\n" +
                    "from\n" +
                    "\tusers_role ur\n" +
                    "inner join users u \n" +
                    "                                   on\n" +
                    "\tur.user_id = u.id\n" +
                    "inner join roles r\n" +
                    "                                   on\n" +
                    "\tur.role_id = r.id\n" +
                    "where\n" +
                    "\tu.login = :login")
    String findRoleByLogin(@Param("login") String login);
}
