package com.oxygen.education.service.impl;

import com.oxygen.education.mapper.VipMapper;
import com.oxygen.education.model.VipModel;
import com.oxygen.education.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author oxy
 */
@Service
public class VipServiceImpl implements VipService {
    @Autowired
    private VipMapper vipMapper;
    @Override
    public VipModel getById(Long vipId) {

        return vipMapper.getById(vipId);
    }
}
