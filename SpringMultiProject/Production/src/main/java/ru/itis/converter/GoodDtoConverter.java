package ru.itis.converter;

import ru.itis.dto.GoodDto;
import ru.itis.dto.ProducerDto;
import ru.itis.model.Good;
import ru.itis.model.Producer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurami on 01.05.2017.
 */
public class GoodDtoConverter {
    public static GoodDto convert(Good good){
        return new GoodDto(good.getId(), good.getTitle(), new ProducerDto(good.getProducer().getTitle(), good.getProducer().getAddress(), null));
    }

    public static List<GoodDto> convertList(List<Good> goods){
        List<GoodDto> goodList = new ArrayList<>();
        for (int i=0; i<goods.size(); i++){
            goodList.add(convert(goods.get(i)));
        }
        return goodList;
    }

    public static Good convert(GoodDto goodDto){
        Good good = new Good(goodDto.getTitle(), new Producer(goodDto.getId(), goodDto.getProducerDto().getTitle(), goodDto.getProducerDto().getAddress(), null));
        return good;
    }
}
