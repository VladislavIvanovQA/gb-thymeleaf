package ru.gb.gbthymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.gbthymeleaf.entity.Cart;
import ru.gb.gbthymeleaf.entity.Product;
import ru.gb.gbthymeleaf.service.CartService;
import ru.gb.gbthymeleaf.service.ProductService;

import java.util.Collections;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final ProductService productService;
    private Cart cart;

    @GetMapping
    public String showForm(Model model) {
        if (cart != null) {
            cartService.findById(cart.getId());
            model.addAttribute("products", cart.getProducts());
        } else {
            model.addAttribute("products", Collections.emptyList());
        }
        return "cart-product-list";
    }

    @GetMapping("/add")
    public String addProduct(@RequestParam(name = "id") Long id) {
        if (cart == null) {
            cart = new Cart();
        }
        cart.addProduct(productService.findById(id));
        cartService.save(cart);
        return "redirect:/product/all";
    }

    @GetMapping("/delete")
    public String deleteById(@RequestParam(name = "id") Long id) {
        Set<Product> actualProducts = cartService.findById(cart.getId()).getProducts();
        for (Product actualProduct : actualProducts) {
            if (actualProduct.getId().equals(id)) {
                actualProducts.remove(actualProduct);
                break;
            }
        }
        cart.setProducts(actualProducts);
        cartService.save(cart);
        return "redirect:/cart";
    }
}
