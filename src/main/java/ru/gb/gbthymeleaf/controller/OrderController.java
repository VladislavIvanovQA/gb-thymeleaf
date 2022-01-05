package ru.gb.gbthymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.gbthymeleaf.service.OrderDtoApiV2;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderDtoApiV2 orderDtoApi;

    @GetMapping(value = "/add")
    public String addProduct(@RequestParam(name = "id") Long id) {
        return orderDtoApi.addProduct(id);
    }

    @GetMapping(value = "/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        return orderDtoApi.deleteById(id);
    }
}