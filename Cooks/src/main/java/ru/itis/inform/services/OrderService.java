package ru.itis.inform.services;

import ru.itis.inform.models.Order;

import java.util.List;

/**
 * Created by Nurami on 13.12.2016.
 */
public interface OrderService {
    String save(Order order);
    String delete(String name);
    Order getByName(String name);
    List<Order> getAll();
}
