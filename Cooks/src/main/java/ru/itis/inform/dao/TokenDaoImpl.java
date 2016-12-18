package ru.itis.inform.dao;

import ru.itis.inform.dao.JDBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Nurami on 14.11.2016.
 */
public class TokenDaoImpl implements TokenDao {
    Connection connection = JDBConnection.getInstance().getConnection();

    public void delete(String token){
        PreparedStatement ps = null;
        try{
            ps = this.connection.prepareStatement("DELETE FROM tokens WHERE token = ? ");
            ps.setString(1, token);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add(int id, String token) {
        PreparedStatement ps = null;
        try{
            ps = this.connection.prepareStatement("INSERT INTO tokens (id, token) VALUES (?, ?)");
            ps.setInt(1, id);
            ps.setString(2, token);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int getIdByToken(String token) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int k = 0;
        try {
            ps = this.connection.prepareStatement("SELECT * FROM tokens WHERE token = ?");
            ps.setString(1, token);
            rs = ps.executeQuery();
            while(rs.next()){
                k = rs.getInt("id");
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return k;
    }
}
