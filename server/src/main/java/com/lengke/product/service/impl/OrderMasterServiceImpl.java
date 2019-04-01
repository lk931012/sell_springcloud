package com.lengke.product.service.impl;

import com.lengke.common.enums.OrderPaymentStatusEnum;
import com.lengke.common.enums.OrderStatusEnum;
import com.lengke.entity.OrderMaster;
import com.lengke.repostory.OrderMasterRepostory;
import com.lengke.product.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Auther : 冷科
 * @Date : 2019/3/10 15:28
 */
@Service
public class OrderMasterServiceImpl implements OrderMasterService {

    @Autowired
    private OrderMasterRepostory orderMasterRepostory;

    @Override
    public void save(OrderMaster orderMaster) {
        orderMasterRepostory.save(orderMaster);
    }

    @Override
    public void delete(String id) {
        orderMasterRepostory.deleteById(id);
    }

    @Override
    public Page<OrderMaster> findAll(Pageable pageable, String buyerOpenid) {
        return orderMasterRepostory.findAllByBuyerOpenid(pageable, buyerOpenid);
    }

    @Override
    public OrderMaster findById(String id) {
        return orderMasterRepostory.findById(id).get();
    }

    @Override
    public void orderPay(String orderId) {
        OrderMaster orderMaster = findById(orderId);
        orderMaster.setOrderStatus(OrderStatusEnum.FINISH.getCode());
        orderMaster.setPaymentStatus(OrderPaymentStatusEnum.PAID.getCode());
        save(orderMaster);
    }
}
