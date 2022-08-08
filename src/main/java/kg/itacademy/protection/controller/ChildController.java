package kg.itacademy.protection.controller;


import kg.itacademy.protection.model.ChildModel;
import kg.itacademy.protection.service.ChildService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/child")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 3600, origins = "*")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class ChildController {

    @Autowired
    private ChildService childService;
    @GetMapping(path = "/get/{email}")
    public ResponseEntity<ChildModel> searchAndSendCodeToChild(@PathVariable("email") String email){
        try {
            return ResponseEntity.ok(childService.searchAndSendCodeToChild());
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
