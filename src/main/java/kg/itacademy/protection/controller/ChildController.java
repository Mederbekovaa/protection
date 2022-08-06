package kg.itacademy.protection.controller;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/child")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChildController {
    public ResponseEntity<?> searchAndSendCodeToChild(String email){

    }
}
