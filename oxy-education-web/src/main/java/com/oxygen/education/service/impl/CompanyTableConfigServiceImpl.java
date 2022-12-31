package com.oxygen.education.service.impl;

import com.oxygen.education.constant.SystemErrorCode;
import com.oxygen.education.exception.OxyException;
import com.oxygen.education.mapper.CompanyTableConfigMapper;
import com.oxygen.education.service.CompanyTableConfigService;
import com.oxygen.education.model.CompanyTableConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置逻辑类
 *
 * @author oxy
 */
@Service
public class CompanyTableConfigServiceImpl implements CompanyTableConfigService {
    @Autowired
    private CompanyTableConfigMapper companyTableConfigMapper;

    private Map<String,CompanyTableConfig> configMap = new HashMap<>();


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

    @Override
    public CompanyTableConfig cacheFind(Integer companyId, String type) {
        String key = companyId + "-" + type;
        if(configMap.containsKey(key)){
            return configMap.get(key);
        }
        CompanyTableConfig config = get(companyId, type);
        if(config == null){
            throw new OxyException(SystemErrorCode.SYSTEM_ERROR,"配置不存在");
        }
        configMap.put(key,config);
        return config;
    }
}
