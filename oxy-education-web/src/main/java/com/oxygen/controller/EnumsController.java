package com.oxygen.controller;

import com.oxygen.model.OrderModel;
import com.oxygen.model.UserModel;
import com.oxygen.param.EnumsParam;
import com.oxygen.response.OxyResponse;
import com.oxygen.service.OrderService;
import com.oxygen.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 枚举测试控制器
 * @author oxy
 */
@Slf4j
@RestController
@RequestMapping("/enums")
public class EnumsController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    /**
     * 打印耗时统计
     * @return
     */
    @GetMapping("statistics")
    public OxyResponse statistics(@RequestParam Long orderId , @RequestParam Long userId){

        //查询订单信息
        OrderModel orderModel = orderService.getById(orderId);
        //查询用户
        UserModel userModel = userService.getById(userId);

        Map<String,Object> map = new HashMap<>(2);
        map.put("orderModel",orderModel);
        map.put("userModel",userModel);
        return OxyResponse.success(map);
    }

    /**
     * 不需要打印日志耗时统计
     * @param enumsParam
     * @return
     */
    @PostMapping("unbiasedStatistics")
    public OxyResponse unbiasedStatistics( @RequestBody EnumsParam enumsParam){
        log.info("枚举测试参数 {}",enumsParam);
        OrderModel orderModel = orderService.getById(enumsParam.getOrderId());
        return OxyResponse.success(orderModel);
    }

}
