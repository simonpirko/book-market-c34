package by.bookmarket.errors;

public class UserByUsernameDoesntExist extends RuntimeException {
    public UserByUsernameDoesntExist() {
        super();
    }

    public UserByUsernameDoesntExist(String message) {
        super(message);
    }

    public UserByUsernameDoesntExist(String message, Throwable cause) {
        super(message, cause);
    }

    public UserByUsernameDoesntExist(Throwable cause) {
        super(cause);
    }

    protected UserByUsernameDoesntExist(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
