package kg.itacademy.protection.service;

import kg.itacademy.protection.model.ContactModel;

import java.util.List;

public interface ContactService {

    ContactModel add(ContactModel contactModel);

    boolean update(ContactModel contactModel);

    boolean delete(ContactModel contactModel);

    List<ContactModel> getAll();
}
