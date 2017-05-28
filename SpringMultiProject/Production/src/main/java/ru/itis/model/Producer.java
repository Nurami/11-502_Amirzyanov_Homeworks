package ru.itis.model;


import javax.persistence.*;
import java.util.List;

/**
 * Created by Nurami on 30.04.2017.
 */
@Entity
@Table(name = "producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "producer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
