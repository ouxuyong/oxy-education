package com.oxygen.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

/**
 * 订单状态枚举类
 *
 * @author oxy
 */

@Getter
public enum OrderStateType {

    /**
     * 已取消
     */
    CANCELED(1, "已取消"),
    /**
     * 下单成功
     */
    CREATED(2, "下单成功"),
    /**
     * 待发货
     */
    TO_DELIVER(3, "待发货"),
    /**
     * 已发货
     */
    DELIVERED(4, "已发货"),
    /**
     * 已收货
     */
    RECEIVED(5, "已收货");


    private Integer code;

    private String name;

    @JsonCreator
    public static OrderStateType getByState(String code) {
        for (OrderStateType e : OrderStateType.values()) {
            if (e.code.equals(Integer.valueOf(code))) {
                return e;
            }
        }
        return null;

    }


    OrderStateType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }


}








//    /**
//     * 超时未支付
//     */
//    PAY_EXPIRED(-2, "超时未支付"),
//    /**
//     * 失败（众筹/拼团失败）
//     */
//    FAILED(-1, "失败"),