package com.oxygen.mapper;

import com.oxygen.model.OrderModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author oxy
 */
@Mapper
public interface OrderMapper {
    /**
     *
     * @param orderId
     * @return
     */
    OrderModel getById(@Param("orderId") Long orderId);

    OrderModel errorGet(Long orderId);
}
