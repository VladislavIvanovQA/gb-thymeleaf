package ru.gb.orderservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.entityservice.model.Order;
import ru.gb.entityservice.model.Product;
import ru.gb.entityservice.service.OrderService;
import ru.gb.entityservice.service.ProductService;

import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final ProductService productService;
    private final OrderService orderService;
    private Order order;

    @GetMapping("/add")
    public String addProduct(@RequestParam(name = "id") Long id) {
        if (order == null) {
            order = new Order();
        }
        order.addProduct(productService.findById(id));
        orderService.save(order);
        return "redirect:/product/all";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        Set<Product> actualProducts = orderService.findById(order.getId()).getProducts();
        for (Product actualProduct : actualProducts) {
            if (actualProduct.getId().equals(id)) {
                actualProducts.remove(actualProduct);
                break;
            }
        }
        order.setProducts(actualProducts);
        orderService.save(order);
        return "redirect:/order";
    }
}
