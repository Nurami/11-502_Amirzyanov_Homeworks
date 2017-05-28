package ru.itis.converter;

import ru.itis.dto.ProducerDto;
import ru.itis.model.Good;
import ru.itis.model.Producer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurami on 01.05.2017.
 */
public class ProducerDtoConverter {
    public static ProducerDto convert(Producer producer){
        List<Good> goods = producer.getGoods();
        if (goods!=null) {
            for (int i = 0; i < goods.size(); i++) {
                goods.get(i).getProducer().setGoods(null);
            }
        }
        return new ProducerDto(producer.getId(), producer.getTitle(), producer.getAddress(), goods);
    }

    public static List<ProducerDto> convertList(List<Producer> producers){
        List<ProducerDto> producerDtos = new ArrayList<>();
        for (int i=0; i<producers.size(); i++){
            producerDtos.add(convert(producers.get(i)));
        }
        return producerDtos;
    }

    public static Producer convert(ProducerDto producerDto){
        Producer producer;
        if (producerDto.getId()!=0){
            producer = new Producer(producerDto.getId(), producerDto.getTitle(), producerDto.getAddress(), producerDto.getGoods());
        }
        else {
            producer = new Producer(producerDto.getTitle(), producerDto.getAddress(), producerDto.getGoods());
        }
        return producer;
    }
}
