package com.oxygen.education.service.impl;

import com.oxygen.education.mapper.CompanyTableConfigMapper;
import com.oxygen.education.service.CompanyTableConfigService;
import com.oxygen.education.model.CompanyTableConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 配置逻辑类
 *
 * @author oxy
 */
@Service
public class CompanyTableConfigServiceImpl implements CompanyTableConfigService {
    @Autowired
    private CompanyTableConfigMapper companyTableConfigMapper;

    /**
     * 查询配置详情
     * @param companyId 企业主键
     * @param type      表类型
     * @return
     */
    @Override
    public CompanyTableConfig get(Integer companyId, String type) {

        return companyTableConfigMapper.get(companyId, type);
    }
}
