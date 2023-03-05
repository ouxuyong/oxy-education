package com.oxygen.education.service.impl;

import com.oxygen.education.annotation.LogAspect;
import com.oxygen.education.constant.SystemErrorCode;
import com.oxygen.education.context.OxygenContextHolder;
import com.oxygen.education.exception.OxyException;
import com.oxygen.education.mapper.OrderMapper;
import com.oxygen.education.model.OrderModel;
import com.oxygen.education.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 * @author oxy
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private HttpServletRequest request;
    private static final String OXY_COMPANY_ID = "oxy-company-id";

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

    @Override
    public OrderModel getByNo(String orderNo) {

        Long companyId = OxygenContextHolder.getCompanyId();
        return orderMapper.getByNo(companyId,orderNo);
    }


}
