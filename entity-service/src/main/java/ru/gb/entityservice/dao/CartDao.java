package ru.gb.entityservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entityservice.model.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {
}
