package ru.itis.inform.dao;

import ru.itis.inform.models.Ingredient;

import java.util.List;

/**
 * Created by Nurami on 12.12.2016.
 */
public interface IngredientDao {
    void save(Ingredient ingredient);
    void delete(int ingredientId, int productId);
    void changeAmount(int ingredientId, int productId, int newAmount);
    Ingredient getByIngAndPro(int ingredientId, int productId);
    List<Ingredient> getAll(int ingredientId);

}
