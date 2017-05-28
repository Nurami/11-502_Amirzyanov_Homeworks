package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Good;

/**
 * Created by Nurami on 30.04.2017.
 */
public interface GoodRepository extends JpaRepository<Good, Integer> {
    Good findByTitle(String title);
    void deleteByTitle(String title);

}
