package by.bookmarket.dao;

import by.bookmarket.entity.user.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserStorageDB implements InMemoryUserStorage {
    private static List<User> users = new ArrayList<>();

    @Override
    public boolean save(User user) {
        return users.add(user);
    }

    @Override
    public User remove(long id) {
        return null;
    }

    @Override
    public User remove(String login) {
        return null;
    }

    @Override
    public String updatePassword(String password, long id) {
        return null;
    }

    @Override
    public String updateName(String name, long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getAllByName(String name) {
        return null;
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean contains(User user) {
        return false;
    }

    @Override
    public boolean contains(long id) {
        return false;
    }

    @Override
    public boolean contains(String login) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getLogin().equals(login)){
                return true;
            }
        }
        return false;
    }
}
