package by.bookmarket.errors;

public class BookByIdDoesntMatch extends RuntimeException {
    public BookByIdDoesntMatch() {
        super();
    }

    public BookByIdDoesntMatch(String message) {
        super(message);
    }

    public BookByIdDoesntMatch(String message, Throwable cause) {
        super(message, cause);
    }

    public BookByIdDoesntMatch(Throwable cause) {
        super(cause);
    }

    protected BookByIdDoesntMatch(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
