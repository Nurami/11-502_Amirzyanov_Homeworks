package client.config;


import java.io.*;
import java.util.Properties;

/**
 * Created by Nurami on 07.05.2017.
 */
public class ActiveToken {
    private static String token ="-1";

    public static String getToken() {
        getTokenFromProperties();
        return token;
    }

    public static void setToken(String token) {
        setTokenToProperdies(token);
    }

    private static void getTokenFromProperties() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("data.properties");
            prop.load(input);
            token = prop.getProperty("token");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setTokenToProperdies(String token) {
        Properties prop = new Properties();
        OutputStream output = null;
        try {
            output = new FileOutputStream("data.properties");
            prop.setProperty("token", token);
            prop.store(output, null);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
