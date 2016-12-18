package ru.itis.inform.dao;

import ru.itis.inform.models.User;

import java.util.List;

/**
 * Created by Nurami on 30.10.2016.
 */
public interface UserDao {
    void add(User user);
    User getByLogin(String login);
    List<User> getAll();
    User getById(int id);

}
