package exception;

public class SortingServiceException extends Exception {

    public SortingServiceException(String message) {
        super(message);
    }

    public SortingServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
