package by.bookmarket.errors;

public class BookByNameDoesntExist extends RuntimeException {
    public BookByNameDoesntExist() {
        super();
    }

    public BookByNameDoesntExist(String message) {
        super(message);
    }

    public BookByNameDoesntExist(String message, Throwable cause) {
        super(message, cause);
    }

    public BookByNameDoesntExist(Throwable cause) {
        super(cause);
    }

    protected BookByNameDoesntExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
