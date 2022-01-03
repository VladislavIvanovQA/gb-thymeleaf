package ru.gb.gbthymeleaf.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.gbthymeleaf.dao.OrderDao;
import ru.gb.gbthymeleaf.entity.Order;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderDao orderDao;

    public long count(){
        return orderDao.count();
    }

    public Order save(Order order) {
        return orderDao.save(order);
    }

    @Transactional(readOnly = true)
    public Order findById (Long id){
        return orderDao.findById(id).get();
    }

}
