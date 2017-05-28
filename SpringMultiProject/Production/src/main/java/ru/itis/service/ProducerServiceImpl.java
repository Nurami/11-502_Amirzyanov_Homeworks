package ru.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.converter.ProducerDtoConverter;
import ru.itis.dto.ProducerDto;
import ru.itis.model.Producer;
import ru.itis.repository.GoodRepository;
import ru.itis.repository.ProducerRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nurami on 30.04.2017.
 */
@Service
@Transactional
@Component
public class ProducerServiceImpl implements ProducerService {
    @Autowired
    ProducerRepository producerRepository;

    @Override
    public ProducerDto find(int id) {
        return ProducerDtoConverter.convert(producerRepository.findOne(id));
    }

    @Override
    public ProducerDto find(String title) {
        return ProducerDtoConverter.convert(producerRepository.findByTitle(title));
    }

    @Override
    public ProducerDto save(ProducerDto producerDto) {
        Producer producer = ProducerDtoConverter.convert(producerDto);
        Producer savedProducer = producerRepository.saveAndFlush(producer);
        return ProducerDtoConverter.convert(savedProducer);
    }

    @Override
    public void delete(int id){
        producerRepository.delete(id);
    }

    @Override
    public ProducerDto update(ProducerDto producerDto){
        Producer producer = producerRepository.findOne(producerDto.getId());
        producer.setTitle(producerDto.getTitle());
        producer.setAddress(producerDto.getAddress());
        producer.setGoods(ProducerDtoConverter.convert(producerDto).getGoods());
        return ProducerDtoConverter.convert(producer);
    }

    @Override
    public List<ProducerDto> findAll() {
        return ProducerDtoConverter.convertList(producerRepository.findAll());
    }

    @Override
    public void delete(String title) {
        producerRepository.deleteByTitle(title);
    }
}
