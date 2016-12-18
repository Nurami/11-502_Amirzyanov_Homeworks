package ru.itis.inform.dao;

import ru.itis.inform.models.DishOfOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurami on 12.12.2016.
 */
public class DishOfOrderDaoImpl implements DishOfOrderDao {
    Connection connection = JDBConnection.getInstance().getConnection();
    PreparedStatement ps = null;

    public void save(DishOfOrder dishOfOrder) {
        try {
            this.ps = this.connection.prepareStatement("INSERT INTO dishes_of_order(order_id, dish_id, amount_d) VALUES(?,?,?)");
            ps.setInt(1, dishOfOrder.getOrderId());
            ps.setInt(2, dishOfOrder.getDishId());
            ps.setInt(3, dishOfOrder.getAmount());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int orderId, int dishId) {
        try {
            this.ps = this.connection.prepareStatement("DELETE FROM dishes_of_order WHERE ((order_id=?) AND (dish_id=?)) ");
            ps.setInt(1, orderId);
            ps.setInt(2, dishId);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void changeAmount(int orderId, int dishId, int newAmount) {
        try{
            ps = connection.prepareStatement("UPDATE dishes_of_order SET amount_d = ? WHERE ((order_id=?) AND (dish_id=?))");
            ps.setInt(1, newAmount);
            ps.setInt(2, orderId);
            ps.setInt(3, dishId);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public DishOfOrder getByDishAndOrd(int orderId, int dishId) {
        DishOfOrder dishOfOrder = null;
        try {
            ps = connection.prepareStatement("SELECT  * FROM dishes_of_order WHERE ((order_id=?) AND (dish_id=?))");
            ps.setInt(1, orderId);
            ps.setInt(2, dishId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                dishOfOrder = new DishOfOrder(rs.getInt("order_id"), rs.getInt("dish_id"), rs.getInt("amount_d"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return dishOfOrder;

    }

    public List<DishOfOrder> getAll(int orderId) {
        List<DishOfOrder> list = new ArrayList<DishOfOrder>();
        try {
            ps = connection.prepareStatement("SELECT * FROM dishes_of_order WHERE order_id=?");
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DishOfOrder dishOfOrder = new DishOfOrder(rs.getInt("order_id"), rs.getInt("dish_id"), rs.getInt("amount_d"));
                list.add(dishOfOrder);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
