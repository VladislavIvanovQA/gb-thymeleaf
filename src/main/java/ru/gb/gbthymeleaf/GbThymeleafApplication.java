package ru.gb.gbthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"ru.gb"})
@SpringBootApplication
public class GbThymeleafApplication {

    public static void main(String[] args) {
        SpringApplication.run(GbThymeleafApplication.class, args);
    }

}
