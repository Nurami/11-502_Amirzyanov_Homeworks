package ru.itis.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.model.Good;
import ru.itis.model.Producer;
import ru.itis.repository.ProducerRepository;
import ru.itis.service.ProducerService;
import ru.itis.service.ProducerServiceImpl;

import javax.sql.DataSource;
import java.util.ArrayList;

/**
 * 25.01.17
 * Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("ru.itis.config")
public class Application  {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        /*ProducerService producerService = new ProducerServiceImpl();
        System.out.print(producerService.findAll());*/
        int k;
    }

}
