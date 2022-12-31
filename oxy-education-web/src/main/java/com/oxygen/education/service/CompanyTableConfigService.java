package com.oxygen.education.service;

import com.oxygen.education.model.CompanyTableConfig;

/**
 * 配置逻辑类
 *
 * @author oxy
 */
public interface CompanyTableConfigService {
    /**
     * 查询配置详情
     *
     * @param companyId 企业主键
     * @param type      表类型
     * @return
     */
    CompanyTableConfig get(Integer companyId, String type);

    /**
     * 查询缓存配置
     * @param companyId
     * @param type
     * @return
     */
    CompanyTableConfig cacheFind(Integer companyId, String type);
}