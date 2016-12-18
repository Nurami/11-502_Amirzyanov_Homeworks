package ru.itis.inform.services;

/**
 * Created by Nurami on 14.11.2016.
 */
public interface TokenService {
    int getIdOfToken(String token);
    void saveToken(int id, String token);
    String generateToken();
    void deleteToken(String token);
    }
