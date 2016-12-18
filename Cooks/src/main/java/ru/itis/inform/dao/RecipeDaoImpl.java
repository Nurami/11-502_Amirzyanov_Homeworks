package ru.itis.inform.dao;

import ru.itis.inform.models.Recipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Nurami on 12.12.2016.
 */
public class RecipeDaoImpl implements RecipeDao {
    Connection connection = JDBConnection.getInstance().getConnection();
    PreparedStatement ps = null;

    public void save(Recipe recipe) {
        try {
            this.ps = this.connection.prepareStatement("INSERT INTO recipes(id_r, recipe) VALUES(?,?)");
            ps.setInt(1, recipe.getId());
            ps.setString(2, recipe.getRecipe());
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void change(int id, String newRecipe) {
        try{
            this.ps = this.connection.prepareStatement("UPDATE recipes SET recipe=? WHERE id_r=?");
            ps.setString(1, newRecipe );
            ps.setInt(2, id);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Recipe getRecipeById(int id) {
        Recipe recipe = null;
        try {
            this.ps = this.connection.prepareStatement("SELECT * FROM recipes WHERE id_r=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                recipe = new Recipe(rs.getInt("id_r"), rs.getString("recipe"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return recipe;
    }
}
