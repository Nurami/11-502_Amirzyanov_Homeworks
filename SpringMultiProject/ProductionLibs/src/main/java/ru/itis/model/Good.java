package ru.itis.model;


/**
 * Created by Nurami on 30.04.2017.
 */

public class Good {

    private int id;


    private String title;


    private Producer producer;

    public Good() {
    }

    public Good(String title, Producer producer) {
        this.title = title;
        this.producer = producer;
    }

    public Good(int id, String title, Producer producer) {
        this.id = id;
        this.title = title;
        this.producer = producer;
    }

    public Good(String title) {
        this.title = title;
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

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
