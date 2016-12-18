package ru.itis.inform.utils;

/**
 * Created by Nurami on 18.12.2016.
 */
public class Number {
    public static boolean check(String str) {
        if (str.matches("[0-9]+") && (!str.equals("0"))) {
            return true;
        } else return false;
    }
}
