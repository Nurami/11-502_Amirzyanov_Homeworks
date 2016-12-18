package ru.itis.inform.models;

/**
 * Created by Nurami on 12.12.2016.
 */
public class Dish {
    private int id;
    private  String name;
    private int ingredientId;
    private int recipeId;

    public Dish(int id, String name, int ingredientId, int recipeId) {
        this.id = id;
        this.name = name;
        this.ingredientId = ingredientId;
        this.recipeId = recipeId;
    }

    public Dish(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public int getRecipeId() {
        return recipeId;
    }
}
