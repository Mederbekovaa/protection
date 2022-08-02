package kg.itacademy.protection.boot;

import kg.itacademy.protection.entity.RoleEntity;
import kg.itacademy.protection.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartRunner implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        if (roleRepository.getByNameRole("ROLE_PARENT") != null) {
            return;
        }

        RoleEntity parent = new RoleEntity();
        parent.setNameRole("ROLE_PARENT");

        RoleEntity child = new RoleEntity();
        child.setNameRole("ROLE_CHILD");


        roleRepository.save(parent);
        roleRepository.save(child);
    }
}

