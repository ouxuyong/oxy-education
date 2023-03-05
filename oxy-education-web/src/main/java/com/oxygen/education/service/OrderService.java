package com.oxygen.education.service;

import com.oxygen.education.model.OrderModel;

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

    /**
     * 保存订单数据
     * @param param
     * @return
     */
    Long save(Object param);

    /**
     * 错误查询
     * @param orderId
     * @return
     */
    OrderModel errorGet(Long orderId);

    OrderModel getByNo(String orderNo);
}
