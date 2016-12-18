package ru.itis.inform.dao;

import ru.itis.inform.models.Product;

import java.util.List;

/**
 * Created by Nurami on 12.12.2016.
 */
public interface ProductDao {
    void save(Product product);
    void delete(String name);
    void changeName(String oldName, String newName);
    void changeAmount(String name, int newAmount);
    void changePrice(String name, int price);
    Product getByName(String name);
    Product getById(int id);
    List<Product> getAll();

}
