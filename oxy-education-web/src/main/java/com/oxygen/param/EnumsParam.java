package com.oxygen.param;

import com.oxygen.enums.OrderStateType;
import lombok.Data;

/**
 * @author oxy
 */
@Data
public class EnumsParam {
    /**
     * 名称
     */
    private String name;
    /**
     * 订单类型
     */
    private OrderStateType orderStateType;
    /**
     * 输出返回测试
     */
    private Long orderId;
}
