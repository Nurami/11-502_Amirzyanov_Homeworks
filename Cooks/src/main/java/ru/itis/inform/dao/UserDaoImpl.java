package ru.itis.inform.dao;

import ru.itis.inform.models.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nurami on 03.11.2016.
 */
public class UserDaoImpl implements UserDao {
    private Connection connection = JDBConnection.getInstance().getConnection();

    public void add(User user) {
        PreparedStatement ps = null;
        try{
            ps = this.connection.prepareStatement("INSERT INTO users (login, password) VALUES (?, ?)");
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getByLogin(String login) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            ps = this.connection.prepareStatement("SELECT * FROM users WHERE login = ?");
            ps.setString(1, login);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("role"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }

    public User getById(int id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            ps = this.connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                u = new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("role"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }

    public List<User> getAll() {
        Statement statement = null;
        ResultSet rs = null;
        List<User> list = new LinkedList<User>();
        try {
            statement = this.connection.createStatement();
            rs = statement.executeQuery("SELECT * FROM users");
            while(rs.next()) {
                User u = new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"), rs.getString("role"));
                list.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
