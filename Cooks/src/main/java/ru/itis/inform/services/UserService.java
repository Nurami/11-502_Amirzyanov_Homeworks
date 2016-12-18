package ru.itis.inform.services;

import ru.itis.inform.models.User;

/**
 * Created by Nurami on 15.11.2016.
 */
public interface UserService {
    void saveUser(String user, String password);
    User getUser(String name);
    User getUser(int id);
    boolean checkLogin(String login);
    boolean checkPassword(String login, String password);
}
