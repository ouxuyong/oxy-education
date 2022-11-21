package com.oxygen.service.impl;

import com.oxygen.annotation.LogAspect;
import com.oxygen.constant.SystemErrorCode;
import com.oxygen.exception.OxyException;
import com.oxygen.mapper.OrderMapper;
import com.oxygen.model.OrderModel;
import com.oxygen.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author oxy
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @LogAspect(name = "订单查询")
    public OrderModel getById(Long orderId) {
        OrderModel orderModel = orderMapper.getById(orderId);
        if(orderModel == null){
            throw new OxyException(SystemErrorCode.REQUEST_PARAM_ERROR,SystemErrorCode.DATA_NULL_ERROR_MSG);
        }
        return orderModel;
    }

    @Override
    public Long save(Object param) {
        //todo 暂未实现
        return 0L;
    }

    /**
     * 报错查询，用于教学
     * @param orderId
     * @return
     */
    @Override
    public OrderModel errorGet(Long orderId) {
        return orderMapper.errorGet(orderId);
    }


}
