package ru.itis.client.config;

/**
 * Created by Nurami on 07.05.2017.
 */
public class ActiveToken {
     private static String token;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        ActiveToken.token = token;
    }

}
