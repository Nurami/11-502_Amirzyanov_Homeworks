package ru.itis.inform.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Nurami on 12.12.2016.
 */
public class JDBConnection {
    private static JDBConnection instance = new JDBConnection();
    private Connection connection = null;


    private JDBConnection() {
        String url = "jdbc:postgresql://127.0.0.1:5432/cooks";
        String name = "postgres";
        String password = "qwertyp";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.connection = DriverManager.getConnection(url, name, password);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static JDBConnection getInstance(){
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }
}
