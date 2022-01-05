package ru.gb.entityservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.entityservice.dao.CartDao;
import ru.gb.entityservice.model.Cart;


@Service
@RequiredArgsConstructor
public class CartService {
    private final CartDao cartDao;

    public long count(){
        return cartDao.count();
    }

    @Transactional
    public Cart save(Cart cart) {
        return cartDao.save(cart);
    }

    @Transactional(readOnly = true)
    public Cart findById (Long id){
        return cartDao.findById(id).get();
    }
}
