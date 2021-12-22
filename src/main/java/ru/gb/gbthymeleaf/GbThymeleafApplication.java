package ru.gb.gbthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.gb.gbthymeleaf.entity.Product;
import ru.gb.gbthymeleaf.entity.enums.Status;
import ru.gb.gbthymeleaf.service.ProductService;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class GbThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(GbThymeleafApplication.class, args);
    }

}
