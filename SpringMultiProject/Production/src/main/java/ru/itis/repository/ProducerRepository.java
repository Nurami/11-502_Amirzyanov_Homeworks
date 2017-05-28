package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Producer;

/**
 * Created by Nurami on 30.04.2017.
 */
public interface ProducerRepository extends JpaRepository<Producer, Integer> {
    Producer findByTitle(String title);
    void deleteByTitle(String title);

}
