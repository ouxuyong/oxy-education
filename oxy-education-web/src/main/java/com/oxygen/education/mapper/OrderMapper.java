package com.oxygen.education.mapper;

import com.oxygen.education.model.OrderModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author oxy
 */
@Mapper
public interface OrderMapper {
    /**
     * 根据订单主键查询
     * @param orderId 主键
     * @return
     */
    OrderModel getById(@Param("orderId") Long orderId);

    /**
     * 制造错误
     * @param orderId 主键
     * @return
     */
    OrderModel errorGet(Long orderId);

    /**
     * 根据订单号获取订单信息
     * @param companyId 企业主键
     * @param orderNo 订单号
     * @return
     */
    OrderModel getByNo(@Param("companyId")Long companyId,@Param("orderNo") String orderNo);
}
