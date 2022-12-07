package com.oxygen.service;

import com.oxygen.model.OrderModel;

/**
 * @author oxy
 */
public interface OrderService {
    /**
     * 查询订单数据
     *
     * @param orderId 订单id
     * @return OrderModel
     */
    OrderModel getById(Long orderId);

    Long save(Object param);

    OrderModel errorGet(Long orderId);
}
