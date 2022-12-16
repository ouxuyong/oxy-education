package com.oxygen.education.enums;

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
    public static OrderStateType getByState(Integer code) {
        for (OrderStateType e : OrderStateType.values()) {
            if (e.code.equals(code)) {
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