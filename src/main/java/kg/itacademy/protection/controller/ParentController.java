package kg.itacademy.protection.controller;

import kg.itacademy.protection.model.ParentModel;
import kg.itacademy.protection.service.ParentService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Slf4j
@CrossOrigin(maxAge = 3600, origins = "*")
@RequestMapping("/api/parent/")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParentController {
    @Autowired
    ParentService parentService;

    @PostMapping(path = "/create")
    public ResponseEntity<ParentModel> createNewParent(@RequestBody ParentModel parentModel) {
        ParentModel result = parentService.create(parentModel);

        if (result.getId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Boolean> updateParent(@Valid @RequestBody ParentModel parentModel) {
        try {
            return ResponseEntity.ok(parentService.update(parentModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Boolean> deleteParent(@Valid @RequestBody ParentModel parentModel) {
        try {
            return ResponseEntity.ok(parentService.delete(parentModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
