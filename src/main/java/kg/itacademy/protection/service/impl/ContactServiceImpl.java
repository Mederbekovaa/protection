package kg.itacademy.protection.service.impl;

import kg.itacademy.protection.entity.ContactEntity;
import kg.itacademy.protection.entity.UserEntity;
import kg.itacademy.protection.exception.user.UserNameNotFoundException;
import kg.itacademy.protection.mapper.ContactMapper;
import kg.itacademy.protection.model.ContactModel;
import kg.itacademy.protection.repository.ContactRepository;
import kg.itacademy.protection.repository.UserRepository;
import kg.itacademy.protection.service.ContactService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactServiceImpl implements ContactService {

    final ContactRepository contactRepository;
    final UserRepository userRepository;

    @Override
    public ContactModel add(ContactModel contactModel) {

        UserEntity user = userRepository.findById(contactModel.getUserId()).orElseThrow (() -> new UserNameNotFoundException("Такого пользователя нет"));
       ContactEntity contactEntity = ContactEntity.builder()
               .contact(contactModel.getContact())
               .name(contactModel.getName())
               .user(user)
               .build();
       contactRepository.save(contactEntity);
        return ContactModel.builder()
                .contact(contactModel.getContact())
                .name(contactModel.getName())
                .userId(contactEntity.getUser().getId())
                .id(contactModel.getId()).build();
    }
    @Override
    public boolean update(ContactModel contactModel) {
        ContactEntity contactEntity = contactRepository.getByName(contactModel.getName());
        UserEntity userEntity = userRepository.getById(contactModel.getUserId());
        contactEntity.setContact(contactModel.getContact());
        contactEntity.setName(contactModel.getContact());
        contactEntity.setUser(userEntity);
        contactRepository.save(contactEntity);
        return contactRepository.save(contactEntity).getId() != null;
    }

    @Override
    public boolean delete(ContactModel contactModel) {
        try {
            contactRepository.delete(contactRepository.getByName(contactModel.getName()));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<ContactModel> getAll() {
        List<ContactEntity> contactEntityList = contactRepository.findAll();
        List<ContactModel> contactModelList = new ArrayList<>();
        return  contactModelList;
    }
}
