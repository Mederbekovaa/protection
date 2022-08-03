package kg.itacademy.protection.configuration;


import kg.itacademy.protection.exception.user.UserSignUpException;
import kg.itacademy.protection.model.ErrorModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { UserSignUpException.class })
    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setMsg(ex.getMessage());
        return handleExceptionInternal(ex, errorModel,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
