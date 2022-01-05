package ru.gb.entityservice.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.entityservice.model.Buyer;

public interface BuyerDao extends JpaRepository<Buyer, Long> {

}
