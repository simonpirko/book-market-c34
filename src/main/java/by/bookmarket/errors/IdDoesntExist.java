package by.bookmarket.errors;

public class IdDoesntExist extends RuntimeException {
    public IdDoesntExist() {
        super();
    }

    public IdDoesntExist(String message) {
        super(message);
    }

    public IdDoesntExist(String message, Throwable cause) {
        super(message, cause);
    }

    public IdDoesntExist(Throwable cause) {
        super(cause);
    }

    protected IdDoesntExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
