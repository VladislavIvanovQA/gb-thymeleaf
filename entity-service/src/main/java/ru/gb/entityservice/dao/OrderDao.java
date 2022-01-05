package ru.gb.entityservice.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entityservice.model.Order;


public interface OrderDao extends JpaRepository<Order,Long> {

}