package ru.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.converter.GoodDtoConverter;
import ru.itis.converter.ProducerDtoConverter;
import ru.itis.dto.GoodDto;
import ru.itis.dto.ProducerDto;
import ru.itis.model.Good;
import ru.itis.repository.GoodRepository;

import java.util.List;

/**
 * Created by Nurami on 30.04.2017.
 */
@Component
@Service
@Transactional
public class GoodServiceImpl implements GoodService {
    @Autowired
    GoodRepository goodRepository;

    @Override
    public GoodDto find(int id) {
        return GoodDtoConverter.convert(goodRepository.findOne(id));
    }

    @Override
    public GoodDto find(String title) {
        return GoodDtoConverter.convert(goodRepository.findByTitle(title));
    }

    @Override
    public List<GoodDto> findAll() {
        return GoodDtoConverter.convertList(goodRepository.findAll());
    }

    @Override
    public void delete(String title) {
        goodRepository.deleteByTitle(title);
    }

    @Override
    public void delete(int id){
        goodRepository.delete(id);
    }

    @Override
    public GoodDto update(GoodDto goodDto){
        Good good = goodRepository.findOne(goodDto.getId());
        good.setTitle(goodDto.getTitle());
        good.setProducer(ProducerDtoConverter.convert(goodDto.getProducerDto()));
        good.getProducer().setId(goodDto.getProducerDto().getId());
        return GoodDtoConverter.convert(good);
    }

    @Override
    public GoodDto save(GoodDto goodDto){
        Good good = GoodDtoConverter.convert(goodDto);
        good.getProducer().setId(goodDto.getProducerDto().getId());
        Good savedGood = goodRepository.saveAndFlush(good);
        return GoodDtoConverter.convert(savedGood);
    }
}
