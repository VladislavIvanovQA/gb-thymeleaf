package ru.gb.entityservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entityservice.dao.BuyerDao;
import ru.gb.entityservice.model.Buyer;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BuyerService {
    private final BuyerDao buyerDao;

    public long count(){
        return buyerDao.count();
    }

    public Buyer save(Buyer buyer) {
        return buyerDao.save(buyer);
    }

    @Transactional(readOnly = true)
    public Buyer findById (Long id){
        return buyerDao.findById(id).get();
    }

    public List<Buyer> findAll (){
        return buyerDao.findAll();
    }

}