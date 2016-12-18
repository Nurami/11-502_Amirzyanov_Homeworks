package ru.itis.inform.utils;

/**
 * Created by Nurami on 18.12.2016.
 */
public class Mass {
    public static boolean check(String mas[], String prod, int k){
        for (int i=0; i<mas.length; i++){
            if (i!=k) {
                if (prod.equals(mas[i])) {
                    return false;
                }
            }
        }return true;
    }
}
