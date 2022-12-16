package com.oxygen.education.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 订单详情
 *
 * @author oxy
 */
@Data
public class OrderItemModel {
    private Long orderItemId;
    /**
     * 企业之间
     */
    private Long companyId;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 商品id
     */
    private Long goodsId;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 金额
     */
    private Long price;
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
