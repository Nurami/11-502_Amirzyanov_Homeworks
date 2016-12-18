package ru.itis.inform.services;


import ru.itis.inform.factory.DaoFactory;
import ru.itis.inform.models.User;
import ru.itis.inform.utils.Hash;

/**
 * Created by Nurami on 15.11.2016.
 */
public class UserServiceImpl implements UserService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public void saveUser(String login, String password) {
        if (checkLogin(login)) {
            String pass = Hash.md5Apache(password);
            User user1 = new User(login, pass);
            daoFactory.getUserDao().add(user1);
        }
    }

    public User getUser(String login) {
        User user  = daoFactory.getUserDao().getByLogin(login);
        if (user != null) {
            return user;
        }
        else {
            return null;
        }
    }

    public User getUser(int id) {
        User user  = daoFactory.getUserDao().getById(id);
        if (user != null) {
            return user;
        }
        else {
            return null;
        }
    }

    public boolean checkLogin(String login) {
        User user = daoFactory.getUserDao().getByLogin(login);
        if (user!=null){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean checkPassword(String login, String password) {
        User user = daoFactory.getUserDao().getByLogin(login);
        String pass = Hash.md5Apache(password);
        if (user.getPassword().equals(pass)) {
            return true;
        }
        else {
            return false;
        }
    }
}
