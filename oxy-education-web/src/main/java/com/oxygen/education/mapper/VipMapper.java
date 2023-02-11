package com.oxygen.education.mapper;

import com.oxygen.education.model.VipModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author oxy
 */
@Mapper
public interface VipMapper {
    /**
     * 根据主键查询会员信息
     *
     * @param vipId
     * @return
     */
    VipModel getById(@Param("vipId") Long vipId);

}
