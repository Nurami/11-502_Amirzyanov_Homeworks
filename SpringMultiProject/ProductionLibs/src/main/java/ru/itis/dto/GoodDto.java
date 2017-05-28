package ru.itis.dto;

/**
 * Created by Nurami on 30.04.2017.
 */
public class GoodDto {
    private int id;
    private String title;
    private ProducerDto producerDto;

    public GoodDto(int id, String title, ProducerDto producerDto) {
        this.id = id;
        this.title = title;
        this.producerDto = producerDto;
    }

    public GoodDto(String title, ProducerDto producerDto) {
        this.title = title;
        this.producerDto = producerDto;
    }


    public GoodDto() {
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

    public ProducerDto getProducerDto() {
        return producerDto;
    }

    public void setProducerDto(ProducerDto producer) {
        this.producerDto = producer;
    }
}