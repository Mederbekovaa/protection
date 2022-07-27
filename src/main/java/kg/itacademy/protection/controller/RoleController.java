package kg.itacademy.protection.controller;

import kg.itacademy.protection.entity.RoleEntity;
import kg.itacademy.protection.model.RoleModel;
import kg.itacademy.protection.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/role")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleController {

    final RoleRepository roleRepository;

    @PostMapping("/create")
    public String createRole(@RequestBody RoleModel roleModel) {
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setNameRole(roleModel.getName());
        return roleRepository.save(roleEntity).getNameRole();
    }
}
