package com.oxygen.education.service;

import com.oxygen.education.model.VipModel;

/**
 * @author oxy
 */
public interface VipService {
    /**
     * 根据会员主键获取数据
     * @param vipId
     * @return
     */
    VipModel getById(Long vipId);
}
