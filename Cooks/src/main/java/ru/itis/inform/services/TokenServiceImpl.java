package ru.itis.inform.services;


import ru.itis.inform.factory.DaoFactory;

import ru.itis.inform.utils.TokenGenerator;

/**
 * Created by Nurami on 15.11.2016.
 */
public class TokenServiceImpl implements TokenService {
    private DaoFactory daoFactory = DaoFactory.getInstance();

    public int getIdOfToken(String token) {
        int id = daoFactory.getTokenDao().getIdByToken(token);

        return id;
    }

    public void saveToken(int id, String token) {
        daoFactory.getTokenDao().add(id, token);
    }

    public String generateToken() {
        TokenGenerator tokenGenerator = new TokenGenerator();
        String token = tokenGenerator.nextSessionId();
        return token;
    }

    public void deleteToken(String token){
        daoFactory.getTokenDao().delete(token);
    }
}
