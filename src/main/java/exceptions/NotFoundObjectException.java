package exceptions;

public class NotFoundObjectException extends RuntimeException {

    public NotFoundObjectException(String message) {
        super(message);
    }
}
