package com.oxygen.service;

import com.oxygen.model.OrderModel;

/**
 * @author oxy
 */
public interface OrderService {

    OrderModel getById(Long orderId);

    Long save(Object param);

    OrderModel errorGet(Long orderId);
}
