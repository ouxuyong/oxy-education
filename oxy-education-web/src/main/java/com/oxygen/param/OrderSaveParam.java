package com.oxygen.param;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author oxy
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class OrderSaveParam {
    /**
     * 订单编码
     */
    @NotEmpty(message = "订单编号不能为空")
    private String orderNo;

    @NotNull(message = "企业主键不能为空")
    private Long companyId;
    /**
     * 订单状态
     */
    @NotNull(message = "订单状态不能为空")
    @Max(message = "超出了订单状态范围",value = 6)
    @Min(message = "超出了订单状态范围",value = 0)
    private Integer orderState;
    /**
     * 备注
     */
    private String remark;
    /**
     * 订单详情
     */
    @Valid
    @NotEmpty(message = "订单详情不能为空")
    private List<OrderItemParam> orderItemList;
}
