package ru.itis.service;


import ru.itis.dto.GoodDto;

import java.util.List;

/**
 * Created by Nurami on 30.04.2017.
 */
public interface GoodService {
    GoodDto find(int id);
    GoodDto find(String title);
    List<GoodDto> findAll();
    void delete(String title);
    void delete(int id);
    GoodDto update(GoodDto goodDto);
    GoodDto save(GoodDto goodDto);
}
