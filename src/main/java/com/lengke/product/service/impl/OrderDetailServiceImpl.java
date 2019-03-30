package com.lengke.product.service.impl;


import com.lengke.product.entity.OrderDetail;
import com.lengke.product.repostory.OrderDetailRepostory;
import com.lengke.product.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 20:23
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepostory orderDetailRepostory;


    @Override
    public OrderDetail findById(String id) {
        return orderDetailRepostory.findById(id).get();
    }

    @Override
    public Page<OrderDetail> findAllByOrderId(Pageable pageable, String orderId) {
        PageRequest pageRequest = PageRequest.of(0, 5);
        return orderDetailRepostory.findAllByOrderId(pageRequest, orderId);
    }

    @Override
    public void save(OrderDetail orderDetail) {
        orderDetailRepostory.save(orderDetail);
    }

    @Override
    public void delete(String id) {
        orderDetailRepostory.deleteById(id);
    }
}
