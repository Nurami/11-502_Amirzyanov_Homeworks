package ru.itis.inform.services;

import ru.itis.inform.models.Product;

import java.util.List;

/**
 * Created by Nurami on 13.12.2016.
 */
public interface ProductService {
    String save(Product product);
    String delete(String name);
    String changeName(String name, String newName);
    String changePrice(String name, int price);
    String changeAmount(String name, int amount);
    Product getByName(String name);
    Product getById(int id);
    List<Product> getAll();
}
