package ru.itis.inform.dao;

import ru.itis.inform.models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurami on 12.12.2016.
 */
public class OrderDaoImpl implements OrderDao {
    Connection connection = JDBConnection.getInstance().getConnection();
    PreparedStatement ps = null;

    public void save(Order order) {
        try {
            this.ps = this.connection.prepareStatement("INSERT INTO orders(name_o, date_order) VALUES(?,?)");
            ps.setString(1, order.getName());
            ps.setString(2, order.getDate());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(String name) {
        try {
            this.ps = this.connection.prepareStatement("DELETE FROM orders WHERE name_o=?");
            ps.setString(1, name);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Order getByName(String name) {
        Order order = null;
        try {
            this.ps = this.connection.prepareStatement("SELECT * FROM orders WHERE name_d=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                order = new Order(rs.getInt("id_o"), rs.getString("name_o"), rs.getString("date_order"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return order;
    }

    public List<Order> getAll() {
        List<Order> list = new ArrayList<Order>();
        try{
            this.ps = this.connection.prepareStatement("SELECT * FROM orders");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Order order = new Order(rs.getInt("id_o"), rs.getString("name_o"), rs.getString("date_order"));
                list.add(order);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
