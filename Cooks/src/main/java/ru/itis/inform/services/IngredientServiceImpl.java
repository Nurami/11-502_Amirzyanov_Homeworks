package ru.itis.inform.services;

import ru.itis.inform.factory.DaoFactory;
import ru.itis.inform.models.Ingredient;

import java.util.List;

/**
 * Created by Nurami on 14.12.2016.
 */
public class IngredientServiceImpl implements IngredientService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public String save(Ingredient ingredient) {
        String message = "Amount musstn't be not negative";
        if (ingredient.getAmount()>=0){
            message = "Success";
            daoFactory.getIngredientDao().save(ingredient);
        }
        return message;
    }

    public String delete(int ingredientId, int productId) {
        String message = "Not found";
        Ingredient ingredient = daoFactory.getIngredientDao().getByIngAndPro(ingredientId, productId);
        if (ingredient!=null){
            message = "Success";
            daoFactory.getIngredientDao().delete(ingredientId, productId);
        }
        return message;
    }

    public String changeAmount(int ingredientId, int productId, int newAmount) {
        String message = "Amount musstn't be not negative";
        if (newAmount>=0){
            message = "Success";
            daoFactory.getIngredientDao().changeAmount(ingredientId, productId, newAmount);
        }
        return message;
    }

    public Ingredient getByIngAndPro(int ingredientId, int productId) {
        Ingredient ingredient = daoFactory.getIngredientDao().getByIngAndPro(ingredientId, productId);
        if (ingredient!=null){
            return ingredient;
        }
        else {
            return null;
        }
    }

    public List getAll(int ingredientId) {
        List list = daoFactory.getIngredientDao().getAll(ingredientId);
        return list;
    }
}
