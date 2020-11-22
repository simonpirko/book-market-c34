package by.bookmarket.errors;

public class UsersByIdDoesntMatch extends RuntimeException {
    public UsersByIdDoesntMatch() {
        super();
    }

    public UsersByIdDoesntMatch(String message) {
        super(message);
    }

    public UsersByIdDoesntMatch(String message, Throwable cause) {
        super(message, cause);
    }

    public UsersByIdDoesntMatch(Throwable cause) {
        super(cause);
    }

    protected UsersByIdDoesntMatch(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
