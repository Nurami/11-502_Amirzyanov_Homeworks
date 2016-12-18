package ru.itis.inform.models;

/**
 * Created by Nurami on 12.12.2016.
 */
public class Order {
    private int id;
    private String name;
    private String date;

    public Order(int id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public Order(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
