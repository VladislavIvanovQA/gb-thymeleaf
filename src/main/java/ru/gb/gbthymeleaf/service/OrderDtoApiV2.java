package ru.gb.gbthymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Component
public class OrderDtoApiV2 {
    private static final String URL = "http://localhost:8465/order";
    private RestTemplate restTemplate;

    @Autowired
    public OrderDtoApiV2(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    public String addProduct(Long id) {
        restTemplate.getForObject(URL + "/add?id={id}", String.class, id);
        return "redirect:/product/all";
    }

    public String deleteById(Long id) {
        restTemplate.getForObject(URL + "/delete", String.class, Collections.singletonMap("id", id));
        return "redirect:/order";
    }
}
