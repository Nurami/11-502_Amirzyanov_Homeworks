package ru.itis.inform.dao;

import ru.itis.inform.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurami on 12.12.2016.
 */
public class ProductDaoImpl implements ProductDao {
    Connection connection = JDBConnection.getInstance().getConnection();
    PreparedStatement ps = null;
    public void save(Product product) {
        try {
            this.ps = this.connection.prepareStatement("INSERT INTO products(id_p, name_p, price, amount_p) VALUES(?,?,?,?)");
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setInt(3, product.getPrice());
            ps.setInt(4, product.getAmount());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Product getById(int id){
        Product product = null;
        try {
            this.ps = this.connection.prepareStatement("SELECT * FROM products WHERE id_p=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product(rs.getInt("id_p"), rs.getString("name_p"), rs.getInt("price"), rs.getInt("amount_p"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    public void delete(String name) {
        try {
            this.ps = this.connection.prepareStatement("DELETE FROM products WHERE name_p=?");
            ps.setString(1, name);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }

    public void changeName(String oldName, String newName) {
        try{
            this.ps = this.connection.prepareStatement("UPDATE products SET name_p=? WHERE name_p=?");
            ps.setString(1, newName);
            ps.setString(2, oldName);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void changeAmount(String name, int newAmount) {
        try{
            this.ps = this.connection.prepareStatement("UPDATE products SET amount_p=? WHERE name_p=?");
            ps.setInt(1, newAmount);
            ps.setString(2, name);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void changePrice(String name, int price) {
        try{
            this.ps = this.connection.prepareStatement("UPDATE products SET price=? WHERE name_p=?");
            ps.setInt(1, price);
            ps.setString(2, name);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Product getByName(String name) {
        Product product = null;
        try {
            this.ps = this.connection.prepareStatement("SELECT * FROM products WHERE name_p=?");
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                product = new Product(rs.getInt("id_p"), rs.getString("name_p"), rs.getInt("price"), rs.getInt("amount_p"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return product;
    }

    public List<Product> getAll() {
        List<Product> list = new ArrayList<Product>();
        try{
            this.ps = this.connection.prepareStatement("SELECT * FROM products");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product product = new Product(rs.getInt("id_p"), rs.getString("name_p"), rs.getInt("price"), rs.getInt("amount_p"));
                list.add(product);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
