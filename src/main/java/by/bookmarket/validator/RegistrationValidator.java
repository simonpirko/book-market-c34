package by.bookmarket.validator;

public class RegistrationValidator {
    public boolean validLogin(String login) {
        return login.length() >= 3;
    }

    public boolean validPassword(String password) {
        return password.length() >= 5;
    }

    public boolean validName(String name) {
        return name.length() >= 2;
    }
}
