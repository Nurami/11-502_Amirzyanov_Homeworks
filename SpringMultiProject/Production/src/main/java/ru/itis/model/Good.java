package ru.itis.model;

import javax.persistence.*;

/**
 * Created by Nurami on 30.04.2017.
 */
@Entity
@Table(name = "good")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", unique = true, nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "producer_id", nullable = false)
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
