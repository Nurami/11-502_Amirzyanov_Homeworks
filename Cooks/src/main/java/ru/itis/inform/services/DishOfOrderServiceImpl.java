package ru.itis.inform.services;

import ru.itis.inform.factory.DaoFactory;
import ru.itis.inform.models.DishOfOrder;
import sun.plugin2.message.Message;

import java.util.List;

/**
 * Created by Nurami on 14.12.2016.
 */
public class DishOfOrderServiceImpl implements DishOfOrderService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public String save(DishOfOrder dishOfOrder) {
        String message = "Amount mustn't be negative";
        if (dishOfOrder.getAmount()>=0){
            message = "Success";
            daoFactory.getDishOfOrderDao().save(dishOfOrder);
        }
        return message;
    }

    public String delete(DishOfOrder dishOfOrder) {
        String message = "Not found";
        if (dishOfOrder!=null){
            message = "Success";
            daoFactory.getDishOfOrderDao().delete(dishOfOrder.getOrderId(), dishOfOrder.getDishId());
        }
        return message;
    }

    public String changeAmount(int orderId, int dishId, int newAmount) {
        String message = "Amount mustn't be negative";
        if (newAmount>=0){
            message = "Success";
            daoFactory.getDishOfOrderDao().changeAmount(orderId, dishId, newAmount);
        }
        return message;
    }

    public DishOfOrder getByDishAndOrd(int orderId, int dishId) {
        DishOfOrder dishOfOrder = daoFactory.getDishOfOrderDao().getByDishAndOrd(orderId, dishId);
        if (dishOfOrder!=null) {
            return dishOfOrder;
        }
        else {
            return null;
        }
    }

    public List getAll(int orderId) {
        List list = daoFactory.getDishOfOrderDao().getAll(orderId);
        return list;
    }
}
