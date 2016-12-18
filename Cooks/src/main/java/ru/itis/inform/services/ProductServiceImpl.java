package ru.itis.inform.services;

import ru.itis.inform.factory.DaoFactory;
import ru.itis.inform.models.Product;

import java.util.List;

/**
 * Created by Nurami on 13.12.2016.
 */
public class ProductServiceImpl implements ProductService {
    DaoFactory daoFactory = DaoFactory.getInstance();


    public String save(Product product) {
        String message = "Length of name mustn't be longer than 30 symbols";
        Product product1 = daoFactory.getProductDao().getByName(product.getName());
        if (product1!=null){
            message = "Product already exist";
        }
        else if((product.getName().length()<=30)&&(product.getName().length()>0)&&(product.getAmount()>=0)&&(product.getPrice()>0)){
            message = "Success";
            daoFactory.getProductDao().save(product);
        }
        return message;
    }

    public String delete(String name) {
        String message = "Not found";
        if (daoFactory.getProductDao().getByName(name)!=null) {
            message = "Success";
            daoFactory.getProductDao().delete(name);
        }
        return message;
    }

    public String changeName(String name, String newName) {
        String message = "Length of name mustn't be longer than 30 symbols";
        Product product = daoFactory.getProductDao().getByName(name);
        if (product!= null) {
            message = "Success";
            daoFactory.getProductDao().changeName(name, newName);
        }
        return message;
    }

    public String changePrice(String name, int price) {
        String message = "Price must be positive";
        Product product = daoFactory.getProductDao().getByName(name);
        if (product!= null) {
            message = "Success";
            daoFactory.getProductDao().changePrice(name, price);
        }
        return message;

    }

    public String changeAmount(String name, int amount) {
        String message = "Price mustn't be negative";
        Product product = daoFactory.getProductDao().getByName(name);
        if (product!= null) {
            message = "Success";
            daoFactory.getProductDao().changeAmount(name, amount);
        }
        return message;
    }

    public Product getByName(String name) {
        Product product = daoFactory.getProductDao().getByName(name);
        if (product!=null){
            return product;
        }
        else {
            return null;
        }
    }
    public Product getById(int id) {
        Product product = daoFactory.getProductDao().getById(id);
        if (product!=null){
            return product;
        }
        else {
            return null;
        }
    }

    public List getAll() {
        List list = daoFactory.getProductDao().getAll();
        return list;
    }

}
