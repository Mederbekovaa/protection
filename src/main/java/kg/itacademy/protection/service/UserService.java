package kg.itacademy.protection.service;

import kg.itacademy.protection.model.TokenModel;
import kg.itacademy.protection.model.UserAuthModel;
import kg.itacademy.protection.model.UserModel;

public interface UserService {
    TokenModel getAuthToken(UserAuthModel userAuthDto);

    TokenModel register(UserModel userModel);
}
