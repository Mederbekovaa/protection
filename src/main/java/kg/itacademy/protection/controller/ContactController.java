package kg.itacademy.protection.controller;

import kg.itacademy.protection.model.ContactModel;
import kg.itacademy.protection.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/contact")
@Slf4j
@CrossOrigin(maxAge = 3600, origins = "*")
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping(path = "/add")
    public ResponseEntity<ContactModel> addNewContact(@RequestBody ContactModel contactModel) {
        ContactModel result = contactService.add(contactModel);

        if (result.getId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
    @PutMapping(path = "/update")
    public ResponseEntity<Boolean> updateContact( @Valid @RequestBody ContactModel contactModel) {
        try {
            return ResponseEntity.ok(contactService.update(contactModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Boolean> deleteContact(@Valid @RequestBody ContactModel contactModel) {
        try {
            return ResponseEntity.ok(contactService.delete(contactModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<ContactModel>> getAll() {
        try {
            return ResponseEntity.ok(contactService.getAll());
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
