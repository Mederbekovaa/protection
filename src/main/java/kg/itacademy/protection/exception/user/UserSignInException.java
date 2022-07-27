package kg.itacademy.protection.exception.user;

import org.springframework.http.HttpStatus;

public class UserSignInException extends RuntimeException {
    public UserSignInException(String s, HttpStatus notFound) {
    }
}

