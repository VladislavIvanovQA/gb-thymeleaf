package ru.gb.gbthymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.gb.gbthymeleaf.entity.Order;
import ru.gb.gbthymeleaf.entity.Product;
import ru.gb.gbthymeleaf.service.BuyerService;
import ru.gb.gbthymeleaf.service.OrderService;
import ru.gb.gbthymeleaf.service.ProductService;

import java.util.Collections;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final ProductService productService;
    private final OrderService orderService;
//    private final BuyerService buyerService;
    private Order order;

    @GetMapping
    public String showForm(Model model) {
        if (order != null) {
            orderService.findById(order.getId());
            model.addAttribute("products", order.getProducts());
        } else {
            model.addAttribute("products", Collections.emptyList());
        }
        return "order-product-list";
    }

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
