package kg.itacademy.protection.boot;

import kg.itacademy.protection.entity.RoleEntity;
import kg.itacademy.protection.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class ApplicationStartRunner implements CommandLineRunner {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        RoleEntity roleUser = new RoleEntity();
        roleUser.setNameRole("ROLE_USER");

        RoleEntity roleAdmin = new RoleEntity();
        roleAdmin.setNameRole("ROLE_ADMIN");


        roleRepository.save(roleUser);
        roleRepository.save(roleAdmin);
    }
}
