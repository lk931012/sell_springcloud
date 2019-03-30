package com.lengke.product.repostory;

import com.lengke.product.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther : 冷科
 * @Date : 2019/3/9 23:05
 */
@Repository
public interface OrderDetailRepostory extends JpaRepository<OrderDetail, String> {


    /**
     * 通过订单id 查询订单下的所有详情   分页
     *
     * @param pageable
     * @param orderId
     * @return
     */
    Page<OrderDetail> findAllByOrderId(Pageable pageable, String orderId);

    /**
     * 通过订单id 查询订单下的所有详情   不分页
     *
     * @param orderId
     * @return
     */
    List<OrderDetail> findAllByOrderId(String orderId);
}
