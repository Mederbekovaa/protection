package kg.itacademy.protection.controller;


import kg.itacademy.protection.model.TokenModel;
import kg.itacademy.protection.model.UserAuthModel;
import kg.itacademy.protection.model.UserModel;
import kg.itacademy.protection.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserController {

    final UserService userService;

    @PostMapping(path = "/sign-in")
    public TokenModel getAuthToken(@RequestBody UserAuthModel userAuthDto) {
        return userService.getToken(userAuthDto);
    }

    @PostMapping(path = "/sign-up")
    public TokenModel register(@RequestBody UserModel userModel) {
        return userService.createUser(userModel);
    }
}
