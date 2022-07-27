package kg.itacademy.protection.controller;

import kg.itacademy.protection.model.InfoModel;
import kg.itacademy.protection.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/info")
@Slf4j
@CrossOrigin(maxAge = 3600, origins = "*")
public class InfoController {

    @Autowired
    InfoService infoService;

    @PostMapping(path = "/create")
    public ResponseEntity<InfoModel> createNewInfo(@RequestBody InfoModel infoModel) {
        InfoModel result = infoService.create(infoModel);

        if (result.getId() != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Boolean> updateInfo(@Valid @RequestBody InfoModel infoModel) {
        try {
            return ResponseEntity.ok(infoService.update(infoModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Boolean> deleteInfo(@Valid @RequestBody InfoModel infoModel) {
        try {
            return ResponseEntity.ok(infoService.delete(infoModel));
        } catch (RuntimeException ex) {
            log.error(ex.getMessage(), ex);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
