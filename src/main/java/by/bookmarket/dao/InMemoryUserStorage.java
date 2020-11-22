package by.bookmarket.dao;

import by.bookmarket.entity.user.User;

import java.util.List;

public interface InMemoryUserStorage {

    boolean save(User user);

    User remove(long id);

    User remove(String login);

    String updatePassword(String password, long id);

    String updateName(String name, long id);

    List<User> getAll();

    List<User> getAllByName(String name);

    User getUserById(long id);

    User getUserByLogin(String login);

    boolean contains(User user);

    boolean contains(long id);

    boolean contains(String login);
}
