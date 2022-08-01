package kg.itacademy.protection.exception;

import org.springframework.http.HttpStatus;

public class UnknowException extends RuntimeException  {
    private HttpStatus httpStatus ;


    public UnknowException(String s) {
        super(s);
    }
    public HttpStatus getStatus(){
        return HttpStatus.I_AM_A_TEAPOT;
    }
}
