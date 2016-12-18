package ru.itis.inform;


import ru.itis.inform.factory.ServiceFactory;
import ru.itis.inform.models.Dish;
import ru.itis.inform.utils.Hash;


/**
 * Created by Nurami on 06.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        for (int i = 0;i<3;  i++){
            Dish dish = new Dish("asdasd");
            System.out.println(ServiceFactory.getInstance().getDishService().saveDish(dish));
        }
    }
}
