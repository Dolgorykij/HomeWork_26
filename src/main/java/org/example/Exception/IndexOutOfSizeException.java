package org.example.Exception;

public class IndexOutOfSizeException extends RuntimeException {
    public IndexOutOfSizeException() {
    }

    public IndexOutOfSizeException(String message) {
        super(message);
    }

    public IndexOutOfSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexOutOfSizeException(Throwable cause) {
        super(cause);
    }
}
