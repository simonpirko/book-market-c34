package by.bookmarket.entity.user;

public final class Admin extends User {

    public Admin() {
        super(1, "admin", "root", "Max", Role.ADMIN);
    }
}
