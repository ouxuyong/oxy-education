package com.oxygen.education.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 订单
 *
 * @author oxy
 */
@Data
public class OrderModel {
    /**
     * 主键
     */
    private Long orderId;
    /**
     * 订单编码
     */
    private String orderNo;

    private Long companyId;
    /**
     * 订单状态
     */
    private String orderState;
    /**
     * 备注
     */
    private String remark;
    /**
     * 删除时间戳
     */
    private Long deleteAt;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

}
