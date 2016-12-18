package ru.itis.inform.dao;

/**
 * Created by Nurami on 14.11.2016.
 */
public interface TokenDao {
    void add(int id, String token);
    int getIdByToken(String token);
    void delete(String token);
}
