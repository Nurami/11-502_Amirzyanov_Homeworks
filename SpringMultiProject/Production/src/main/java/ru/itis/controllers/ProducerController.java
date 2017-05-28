package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.ProducerDto;
import ru.itis.model.Producer;
import ru.itis.service.ProducerService;

import java.util.List;

/**
 * Created by Nurami on 30.04.2017.
 */
@RestController
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @GetMapping("/producers")
    public ResponseEntity<List<ProducerDto>> getProducers(){
        return new ResponseEntity<List<ProducerDto>>(producerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/producers")
    public ResponseEntity<ProducerDto> save(@RequestBody ProducerDto producerDto){
        producerService.save(producerDto);
        return new ResponseEntity<ProducerDto>(producerDto, HttpStatus.OK);
    }

    @GetMapping("/producers/{id}")
    public ResponseEntity<ProducerDto> getProducer(@PathVariable("id") int id){
        return new ResponseEntity<ProducerDto>(producerService.find(id), HttpStatus.OK);
    }

    @PutMapping("/producers/{id}")
    public ResponseEntity<ProducerDto> updateProducer(@RequestBody ProducerDto producerDto){
        return new ResponseEntity<ProducerDto>(producerService.update(producerDto), HttpStatus.OK);
    }

    @DeleteMapping("/producers/{id}")
    public ResponseEntity<Object> deleteProducer(@PathVariable("id") int id){
        producerService.delete(id);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }




}
