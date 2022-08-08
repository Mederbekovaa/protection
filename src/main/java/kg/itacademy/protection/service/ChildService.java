package kg.itacademy.protection.service;


import kg.itacademy.protection.model.ChildModel;

public interface ChildService {
    ChildModel getByEmail(String email);
}
