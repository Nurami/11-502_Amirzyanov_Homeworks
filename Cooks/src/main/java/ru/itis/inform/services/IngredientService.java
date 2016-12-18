package ru.itis.inform.services;

import ru.itis.inform.models.Ingredient;

import java.util.List;

/**
 * Created by Nurami on 14.12.2016.
 */
public interface IngredientService {
    String save(Ingredient ingredient);
    String delete(int ingredientId, int productId);
    String changeAmount(int ingredientId, int productId, int newAmount);
    Ingredient getByIngAndPro(int ingredientId, int productId);
    List<Ingredient> getAll(int ingredientId);
}
