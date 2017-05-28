package ru.itis.model;


import java.util.List;

/**
 * Created by Nurami on 30.04.2017.
 */

public class Producer {

    private int id;


    private String title;


    private String address;


    private List<Good> goods;

    public Producer(int id, String title, String address, List<Good> goods) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.goods = goods;
    }

    public Producer(int id){
        this.id = id;
    }

    public Producer(String title, String address) {
        this.title = title;
        this.address = address;
    }

    public Producer(String title, String address, List<Good> goods) {
        this.title = title;
        this.address = address;
        this.goods = goods;
    }

    public Producer() {
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }
}
