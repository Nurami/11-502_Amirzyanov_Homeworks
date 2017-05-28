package ru.itis.dto;

import ru.itis.model.Good;

import java.util.List;

/**
 * Created by Nurami on 30.04.2017.
 */
public class ProducerDto {
    private int id;
    private String title;
    private String address;
    private List<Good> goods;

    public ProducerDto(int id, String title, String address, List<Good> goods) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.goods = goods;
    }

    public ProducerDto(String title, String address, List<Good> goods) {
        this.title = title;
        this.address = address;
        this.goods = goods;
    }

    public ProducerDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }
}
