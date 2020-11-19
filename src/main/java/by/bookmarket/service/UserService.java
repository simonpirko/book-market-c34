package by.bookmarket.service;

import by.bookmarket.dao.InMemoryUserStorageDB;
import by.bookmarket.entity.user.User;

public class UserService {
    private InMemoryUserStorageDB inMemoryUserStorageDB = new InMemoryUserStorageDB();

    public boolean save (User user) {
        return inMemoryUserStorageDB.save(user);
    }

    public User getUserByLogin (String login){
        if (inMemoryUserStorageDB.contains(login)) {
            return inMemoryUserStorageDB.getUserByLogin(login);
        }
        return null;
    }
}
