package com.oxygen.education.model;

import com.oxygen.education.enums.GenderEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 会员
 *
 * @author oxy
 */
@Data
public class VipModel {
    /**
     * 会员主键
     */
    private Long vipId;
    /**
     * 企业主键
     */
    private Long companyId;
    /**
     * 会员号码
     */
    private String mobilePhone;
    /**
     * 会员名称
     */
    private String name;
    /**
     * 性别
     */
    private GenderEnum gender;
    /**
     * 删除时间戳
     */
    private Long deleteAt;
    /**
     * 创建时间
     */
    private LocalDateTime createdAt;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    public Long getVipId() {
        return vipId;
    }

}
