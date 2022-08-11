package kg.itacademy.protection.service;

import kg.itacademy.protection.model.ChildModel;

public interface ChildService {
    ChildModel searchAndSendCodeToChild(String emailChild, Long parentId);
}
