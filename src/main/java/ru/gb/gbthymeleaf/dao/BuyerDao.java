package ru.gb.gbthymeleaf.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.gbthymeleaf.entity.Buyer;

public interface BuyerDao extends JpaRepository<Buyer, Long> {

}
