package ru.itis.inform.dao;

import ru.itis.inform.models.Ingredient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurami on 12.12.2016.
 */
public class IngredientDaoImpl implements IngredientDao {
    Connection connection = JDBConnection.getInstance().getConnection();
    PreparedStatement ps = null;

    public void save(Ingredient ingredient) {
        try {
            this.ps = this.connection.prepareStatement("INSERT INTO ingredients(id_i, product_id, amount_i) VALUES(?,?,?)");
            ps.setInt(1, ingredient.getIngredientId());
            ps.setInt(2, ingredient.getProductId());
            ps.setInt(3, ingredient.getAmount());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int ingredientId, int productId) {
        try {
            this.ps = this.connection.prepareStatement("DELETE FROM ingredients WHERE ((id_i=?) AND (product_id=?)) ");
            ps.setInt(1, ingredientId);
            ps.setInt(2, productId);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void changeAmount(int ingredientId, int productId, int newAmount) {
        try{
            ps = connection.prepareStatement("UPDATE ingredients SET amount_i = ? WHERE ((id_i=?) AND (product_id=?))");
            ps.setInt(1, newAmount);
            ps.setInt(2, ingredientId);
            ps.setInt(3, productId);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Ingredient getByIngAndPro(int ingredientId, int productId) {
        Ingredient ingredient = null;
        try {
            ps = connection.prepareStatement("SELECT  * FROM ingredients WHERE ((id_i=?) AND (product_id=?))");
            ps.setInt(1, ingredientId);
            ps.setInt(2, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ingredient = new Ingredient(rs.getInt("id_i"), rs.getInt("product_id"), rs.getInt("amount_i"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return ingredient;
    }

    public List<Ingredient> getAll(int ingredientId) {
        List<Ingredient> list = new ArrayList<Ingredient>();
        try {
            ps = connection.prepareStatement("SELECT * FROM ingredients WHERE id_i=?");
            ps.setInt(1, ingredientId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ingredient ingredient = new Ingredient(rs.getInt("id_i"), rs.getInt("product_id"), rs.getInt("amount_i"));
                list.add(ingredient);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
