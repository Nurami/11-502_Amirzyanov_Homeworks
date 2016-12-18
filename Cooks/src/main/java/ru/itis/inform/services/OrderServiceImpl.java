package ru.itis.inform.services;

import ru.itis.inform.factory.DaoFactory;
import ru.itis.inform.models.Order;

import java.util.List;

/**
 * Created by Nurami on 13.12.2016.
 */
public class OrderServiceImpl implements OrderService {
    DaoFactory daoFactory = DaoFactory.getInstance();
    public String save(Order order) {
        String message = "Length of name mustn't be longer than 30 symbols";
        if ((order!=null)&&(order.getName().length()<=30)&&(order.getName().length()>=0)){
            message = "Success";
            daoFactory.getOrderDao().save(order);
        }
        return message;
    }

    public String delete(String name) {
        String message = "Not found";
        Order order = daoFactory.getOrderDao().getByName(name);
        if (order!=null){
            message = "Success";
            daoFactory.getOrderDao().delete(name);
        }
        return message;
    }

    public Order getByName(String name) {
        Order order = daoFactory.getOrderDao().getByName(name);
        if (order!=null) {
            return order;
        }
        else {
            return null;
        }
    }

    public List getAll() {
        List list = daoFactory.getOrderDao().getAll();
        return list;
    }
}
