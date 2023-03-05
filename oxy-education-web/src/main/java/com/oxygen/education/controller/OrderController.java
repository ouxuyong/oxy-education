package com.oxygen.education.controller;

import com.oxygen.education.model.OrderModel;
import com.oxygen.education.response.OxyResponse;
import com.oxygen.education.service.OrderService;
import com.oxygen.education.param.OrderSaveParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author oxy
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 获取订单详情
     *
     * @param orderId
     * @return
     */
    @GetMapping("get")
    public OxyResponse<OrderModel> get(@RequestParam("order_id") Long orderId) {
        OrderModel orderModel = orderService.getById(orderId);
        return OxyResponse.success(orderModel);
    }

    /**
     * 制造错误查询
     *
     * @param orderId
     * @return
     */
    @GetMapping("errorGet")
    public OxyResponse<OrderModel> errorGet(@RequestParam Long orderId) {
        OrderModel orderModel = orderService.errorGet(orderId);
        return OxyResponse.success(orderModel);
    }

    /**
     * 保存订单数据
     *
     * @param param
     * @return
     */
    @PostMapping("save")
    public OxyResponse save(@Valid @RequestBody OrderSaveParam param) {
        Long orderId = orderService.save(param);
        return OxyResponse.success(orderId);
    }

    @GetMapping("getByNo")
    public OxyResponse<OrderModel> getByNo(@RequestParam("orderNo") String orderNo) {
        OrderModel orderModel = orderService.getByNo(orderNo);
        return OxyResponse.success(orderModel);
    }
}
