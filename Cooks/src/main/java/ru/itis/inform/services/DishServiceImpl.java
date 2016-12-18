package ru.itis.inform.services;

import ru.itis.inform.factory.DaoFactory;
import ru.itis.inform.models.Dish;
import ru.itis.inform.models.Recipe;

import java.util.List;

/**
 * Created by Nurami on 13.12.2016.
 */
public class DishServiceImpl implements DishService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    Dish mainDish = null;

    public String saveDish(Dish dish) {
        String message = "Length of name must be in the range from 2 to 40";
        Dish d = daoFactory.getDishDao().getByName(dish.getName());
        if ((dish.getName().length()>=2)&&(dish.getName().length()<=40)) {
            if (d != null) {
                message = "Dish already exist";
            } else {
                daoFactory.getDishDao().save(dish);
                message = "Success";
            }
        }
        return message;
    }

    public String saveRecipe(String recipe) {
        String message = "Length of recipe must be more than 10";
        if (recipe.length()>=10){
            message = "Success";
            Recipe recipe1 = new Recipe(mainDish.getRecipeId(), recipe);
            daoFactory.getRecipeDao().save(recipe1);
        }
        return message;
    }

    public String deleteDish(String name) {
        String message = "Not found";
        Dish d = daoFactory.getDishDao().getByName(name);
        if (d!=null){
            daoFactory.getDishDao().delete(name);
            message = "Success";
        }
        return message;
    }

    public String changeDish(String oldName, String newName) {
        String message = "Length of name must be in the range from 2 to 40";
        Dish d = daoFactory.getDishDao().getByName(oldName);
        if ((newName.length()>=2)&&(newName.length()<=40)) {
            if (d!=null){
                daoFactory.getDishDao().change(oldName, newName);
                message = "Success";
            }
            else {
                message = "Not found";
            }
        }
        return message;
    }

    public String changeRecipe(String newRecipe) {
        String message = "Length of recipe must be longer than 10 symbols";
        if (newRecipe.length()>=10){
            daoFactory.getRecipeDao().change(mainDish.getRecipeId(), newRecipe);
            message = "Success";
        }
        return message;
    }

    public Dish getByName(String name) {
        mainDish = daoFactory.getDishDao().getByName(name);
        if (mainDish!=null){
            return mainDish;
        }
        else {
            return null;
        }

    }

    public String getRecipe() {
        String message = "Not found";
        Recipe recipe = daoFactory.getRecipeDao().getRecipeById(mainDish.getRecipeId());
        if (recipe!=null) {
            message = recipe.getRecipe();
        }
        return message;
    }

    public List getAll() {
        List<Dish> list = daoFactory.getDishDao().getAll();
        return list;
    }
}
