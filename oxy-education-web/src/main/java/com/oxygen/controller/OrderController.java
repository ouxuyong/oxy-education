package com.oxygen.controller;

import com.oxygen.model.OrderModel;
import com.oxygen.param.OrderSaveParam;
import com.oxygen.response.OxyResponse;
import com.oxygen.service.OrderService;
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

    @GetMapping("get")
    public OxyResponse<OrderModel> get(@RequestParam("order_id") Long orderId)  {
        OrderModel orderModel = orderService.getById(orderId);
        return OxyResponse.success(orderModel);
    }

    @GetMapping("errorGet")
    public OxyResponse<OrderModel> errorGet(@RequestParam Long orderId)  {
        OrderModel orderModel = orderService.errorGet(orderId);
        return OxyResponse.success(orderModel);
    }

    @PostMapping("save")
    public OxyResponse save(@Valid @RequestBody OrderSaveParam param)  {
        Long orderId = orderService.save(param);


        return OxyResponse.success(orderId);
    }
}
