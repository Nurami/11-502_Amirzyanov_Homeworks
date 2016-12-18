package ru.itis.inform.utils;

import ru.itis.inform.factory.ServiceFactory;
import ru.itis.inform.models.Product;

/**
 * Created by Nurami on 18.12.2016.
 */
public class CheckStorage {
    static ServiceFactory serviceFactory = ServiceFactory.getInstance();
    public static String[] check(String[] product, int[] amount){
        String[] result = new String[product.length];
        for (int i=0; i<product.length; i++){
            Product product1 = serviceFactory.getProductService().getByName(product[i]);
            if (product1.getAmount()-amount[i]>=0) {
                result[i]= product1.getName()+" - sufficiently";
            }
            else {
                result[i]= product1.getName() +" - not sufficiently " + Integer.toString(amount[i]-product1.getAmount())+ " pieces";
            }
        }
        return result;
    }
}
