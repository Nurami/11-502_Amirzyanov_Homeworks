package ru.itis.inform.dao;

import ru.itis.inform.models.Dish;

import java.util.List;

/**
 * Created by Nurami on 12.12.2016.
 */
public interface DishDao {
    void save(Dish dish);
    void delete(String name);
    void change(String oldName, String newName);
    Dish getByName(String name);
    List<Dish> getAll();
}
