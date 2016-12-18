package ru.itis.inform.dao;

import ru.itis.inform.models.DishOfOrder;

import java.util.List;

/**
 * Created by Nurami on 12.12.2016.
 */
public interface DishOfOrderDao {
    void save(DishOfOrder dishOfOrder);
    void delete(int orderId, int dishId);
    void changeAmount(int orderId, int dishId, int newAmount);
    DishOfOrder getByDishAndOrd(int orderId, int dishId);
    List<DishOfOrder> getAll(int orderId);
}
