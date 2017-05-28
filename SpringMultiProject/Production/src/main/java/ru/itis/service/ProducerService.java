package ru.itis.service;

import ru.itis.dto.ProducerDto;
import ru.itis.model.Producer;

import java.util.List;

/**
 * Created by Nurami on 30.04.2017.
 */
public interface ProducerService {
    ProducerDto find(int id);
    ProducerDto find(String title);
    void delete(int id);
    ProducerDto update(ProducerDto producerDto);
    ProducerDto save(ProducerDto producerDto);
    List<ProducerDto> findAll();
    void delete(String title);
}
