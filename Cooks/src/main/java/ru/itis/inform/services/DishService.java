package ru.itis.inform.services;

import ru.itis.inform.models.Dish;
import ru.itis.inform.models.Recipe;

import java.util.List;

/**
 * Created by Nurami on 13.12.2016.
 */
public interface DishService {
    String saveDish(Dish dish);
    String saveRecipe (String recipe);
    String deleteDish(String name);
    String changeDish(String oldName, String newName);
    String changeRecipe(String newRecipe);
    Dish getByName(String name);
    String getRecipe();
    List<Dish> getAll();
}
