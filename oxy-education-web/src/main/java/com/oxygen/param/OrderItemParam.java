package com.oxygen.param;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * @author oxy
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderItemParam {
    /**
     * 企业之间
     */
    @NotNull(message = "订单详情企业主键不能为空")
    private Long companyId;
    /**
     * 商品id
     */
    @NotNull(message = "订单详情商品主键不能为空")
    private Long goodsId;
    /**
     * 用户主键
     */
    @NotNull(message = "订单详情用户主键不能为空")
    private Long userId;
    /**
     * 金额
     */
    @NotNull(message = "订单详情金额不能为空")
    private Long price;
}
