package ru.itis.inform.services;

import ru.itis.inform.models.DishOfOrder;

import java.util.List;

/**
 * Created by Nurami on 14.12.2016.
 */
public interface DishOfOrderService {
    String save(DishOfOrder dishOfOrder);
    String delete(DishOfOrder dishOfOrderService);
    String changeAmount(int orderId, int dishId, int newAmount);
    DishOfOrder getByDishAndOrd(int orderId, int dishId);
    List<DishOfOrder> getAll(int orderId);

}
