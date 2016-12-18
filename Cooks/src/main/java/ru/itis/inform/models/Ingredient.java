package ru.itis.inform.models;

/**
 * Created by Nurami on 12.12.2016.
 */
public class Ingredient {
    private int ingredientId;
    private int productId;
    private int amount;

    public Ingredient(int ingredientId, int productId, int amount) {
        this.ingredientId = ingredientId;
        this.productId = productId;
        this.amount = amount;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public int getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }
}
