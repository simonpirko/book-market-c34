package by.bookmarket.service;

import by.bookmarket.dao.user.InMemoryUserDao;
import by.bookmarket.dao.user.UserDaoDB;
import by.bookmarket.entity.user.User;
import by.bookmarket.errors.IdDoesntExist;
import by.bookmarket.errors.IsEmptyException;
import by.bookmarket.errors.UserByUsernameDoesntExist;
import by.bookmarket.errors.UsersByIdDoesntMatch;

import java.util.List;

public class UserService {
    private InMemoryUserDao iMUD = new InMemoryUserDao();
    private UserDaoDB uDDB = new UserDaoDB();

    public boolean synchronizedSave(User user) {
        if (iMUD.contains(user) && uDDB.contains(user)) {
            return false;
        } else {
            iMUD.save(user);
            uDDB.save(user);
        }
        return true;
    }

    public void synchronizedDelete(long id) {
        if (iMUD.contains(id) && uDDB.contains(id)) {
            if (iMUD.getById(id).equals(uDDB.getById(id))) {
                iMUD.delete(id);
                uDDB.delete(id);
                return;
            }
            throw new UsersByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdateName(String newName, long id) {
        if (iMUD.contains(id) && uDDB.contains(id)) {
            if (iMUD.getById(id).equals(uDDB.getById(id))) {
                iMUD.updateName(newName, id);
                uDDB.updateName(newName, id);
                return;
            }
            throw new UsersByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public void synchronizedUpdatePassword(String newPassword, long id) {
        if (iMUD.contains(id) && uDDB.contains(id)) {
            if (iMUD.getById(id).equals(uDDB.getById(id))) {
                iMUD.updatePassword(newPassword, id);
                uDDB.updatePassword(newPassword, id);
                return;
            }
            throw new UsersByIdDoesntMatch();
        }
        throw new IdDoesntExist();
    }

    public List<User> getAllFromInMemory(){
        if (iMUD.getAll().isEmpty()){
            throw new IsEmptyException();
        }
        return iMUD.getAll();
    }

    public List<User> getAllFromDB(){
        if (uDDB.getAll().isEmpty()){
            throw new IsEmptyException();
        }
        return uDDB.getAll();
    }

    public void synchronize(){
        iMUD.save(uDDB.getAll());
    }

    public User getByUsernameFromInMemory(String username){
        if (iMUD.getByUsername(username) == null){
            throw new UserByUsernameDoesntExist();
        }
        return iMUD.getByUsername(username);
    }
}
