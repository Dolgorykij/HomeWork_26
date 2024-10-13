package org.example.Exception;

public class ItemIsNullException extends RuntimeException {
    public ItemIsNullException() {
    }

    public ItemIsNullException(String message) {
        super(message);
    }

    public ItemIsNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemIsNullException(Throwable cause) {
        super(cause);
    }
}
