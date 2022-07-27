package kg.itacademy.protection.service;

import kg.itacademy.protection.model.UserAuthModel;
import kg.itacademy.protection.model.UserModel;

public interface UserService {
    String getToken(UserAuthModel userAuthDto);
    String createUser(UserModel userAuthDto);
}
