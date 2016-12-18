package ru.itis.inform.models;

/**
 * Created by Nurami on 12.12.2016.
 */
public class DishOfOrder {
    private int orderId;
    private int dishId;
    private int amount;

    public DishOfOrder(int orderId, int dishId, int amount) {
        this.orderId = orderId;
        this.dishId = dishId;
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getDishId() {
        return dishId;
    }

    public int getAmount() {
        return amount;
    }
}
