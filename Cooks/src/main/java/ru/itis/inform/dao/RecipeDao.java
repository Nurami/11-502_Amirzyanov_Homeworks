package ru.itis.inform.dao;

import ru.itis.inform.models.Recipe;

/**
 * Created by Nurami on 12.12.2016.
 */
public interface RecipeDao {
    void save(Recipe recipe);
    void change(int id, String newRecipe);
    Recipe getRecipeById(int id);
}
