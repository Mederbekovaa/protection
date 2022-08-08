package kg.itacademy.protection.exception.child;

public class ChildNotFoundException extends RuntimeException{
    public ChildNotFoundException() {
    }

    public ChildNotFoundException(String message) {
        super(message);
    }
}
