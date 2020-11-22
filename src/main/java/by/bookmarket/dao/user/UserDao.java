package by.bookmarket.dao.user;

import by.bookmarket.entity.user.User;

import java.util.List;

public interface UserDao {
    boolean save(User user);

    List<User> getAll();

    User getById(long id);

    User getByUsername(String username);

    boolean contains(long id);

    boolean contains(User user);

    boolean delete(long id);

    String updateName(String newName, long id);

    String updatePassword(String password, long id);
}
