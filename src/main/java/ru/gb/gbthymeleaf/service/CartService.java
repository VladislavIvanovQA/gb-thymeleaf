package ru.gb.gbthymeleaf.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.gbthymeleaf.dao.CartDao;
import ru.gb.gbthymeleaf.entity.Cart;


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
