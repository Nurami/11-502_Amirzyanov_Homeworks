package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.dto.GoodDto;
import ru.itis.service.GoodService;

import java.util.List;

/**
 * Created by Nurami on 01.05.2017.
 */
@RestController
public class GoodController {

    @Autowired
    GoodService goodService;

    @GetMapping("/goods")
    public ResponseEntity<List<GoodDto>> getGoods(){
        return new ResponseEntity<>(goodService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/goods")
    public ResponseEntity<GoodDto> save(@RequestBody GoodDto goodDto){
        return new ResponseEntity<GoodDto>(goodService.save(goodDto), HttpStatus.CREATED);
    }

    @GetMapping("/goods/{id}")
    public ResponseEntity<GoodDto> getGood(@PathVariable("id") int id){
        return new ResponseEntity<GoodDto>(goodService.find(id), HttpStatus.OK);
    }

    @PutMapping("/goods/{id}")
    public ResponseEntity<GoodDto> updateGood(@RequestBody GoodDto goodDto){
        return new ResponseEntity<GoodDto>(goodService.update(goodDto), HttpStatus.OK);
    }

    @DeleteMapping("/goods/{id}")
    public ResponseEntity<Object> deleteGood(@PathVariable("id") int id){
        goodService.delete(id);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }


}
