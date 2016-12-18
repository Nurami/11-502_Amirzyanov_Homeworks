package ru.itis.inform.dao;

import ru.itis.inform.models.Order;

import java.util.List;

/**
 * Created by Nurami on 12.12.2016.
 */
public interface OrderDao {
    void save(Order order);
    void delete(String name);
    Order getByName(String name);
    List<Order> getAll();
}

