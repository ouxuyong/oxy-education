package com.oxygen.education.mapper;

import com.oxygen.education.model.CompanyTableConfig;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 企业数据表配置 Mapper 接口
 * </p>
 *
 * @author oxy
 * @since 2022-12-07
 */
@Mapper
public interface CompanyTableConfigMapper{
    /**
     * 获取配置
     * @param companyId
     * @param type
     * @return
     */
    CompanyTableConfig get(Integer companyId, String type);

}
