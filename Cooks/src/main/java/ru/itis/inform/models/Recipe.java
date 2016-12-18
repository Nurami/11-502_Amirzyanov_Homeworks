package ru.itis.inform.models;

/**
 * Created by Nurami on 12.12.2016.
 */
public class Recipe {
    private int id;
    private String recipe;

    public Recipe(int id, String recipe) {
        this.id = id;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }

    public String getRecipe() {
        return recipe;
    }
}
