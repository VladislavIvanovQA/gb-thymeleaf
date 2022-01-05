package ru.gb.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.entityservice.model.Order;
import ru.gb.entityservice.model.Product;
import ru.gb.entityservice.service.OrderService;
import ru.gb.entityservice.service.ProductService;

import java.util.Set;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {
    private final ProductService productService;
    private final OrderService orderService;
    private Order order;

    @GetMapping(value = "/add")
    public void addProduct(@RequestParam(name = "id") Long id) {
        if (order == null) {
            order = new Order();
        }
        order.addProduct(productService.findById(id));
        order.setSum(order.getOrderCost());
        orderService.save(order);
    }

    @GetMapping(value = "/delete")
    public void deleteById(@RequestParam(name = "id") Long id) {
        Set<Product> actualProducts = orderService.findById(order.getId()).getProducts();
        for (Product actualProduct : actualProducts) {
            if (actualProduct.getId().equals(id)) {
                actualProducts.remove(actualProduct);
                break;
            }
        }
        order.setProducts(actualProducts);
        orderService.save(order);
    }
}
