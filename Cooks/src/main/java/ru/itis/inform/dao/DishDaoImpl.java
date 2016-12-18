package ru.itis.inform.dao;

import ru.itis.inform.models.Dish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurami on 12.12.2016.
 */
public class DishDaoImpl implements DishDao {
    Connection connection = JDBConnection.getInstance().getConnection();
    PreparedStatement ps = null;

    public void save(Dish dish) {
        try {
            this.ps = this.connection.prepareStatement("INSERT INTO dishes(name_d) VALUES(?)");
            ps.setString(1, dish.getName());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(String name) {
        try {
            this.ps = this.connection.prepareStatement("DELETE FROM dishes WHERE name_d=?");
            ps.setString(1, name);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }

    public void change(String oldName, String newName) {
        try{
            this.ps = this.connection.prepareStatement("UPDATE dishes SET name_d=? WHERE name_d=?");
            ps.setString(1, newName);
            ps.setString(2, oldName);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Dish getByName(String name) {
        Dish dish = null;
        try {
            this.ps = this.connection.prepareStatement("SELECT * FROM dishes WHERE name_d=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dish = new Dish(rs.getInt("id_d"), rs.getString("name_d"), rs.getInt("ingredient_id"), rs.getInt("recipe_id"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return dish;
    }

    public List<Dish> getAll() {
        List<Dish> list = new ArrayList<Dish>();
        try{
            this.ps = this.connection.prepareStatement("SELECT * FROM dishes");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Dish dish = new Dish(rs.getInt("id_d"), rs.getString("name_d"), rs.getInt("ingredient_id"), rs.getInt("recipe_id"));
                list.add(dish);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
