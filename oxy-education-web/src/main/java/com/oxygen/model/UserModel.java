package com.oxygen.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 用户
 *
 * @author oxy
 */
@Data
public class UserModel {
    /**
     * 用户主键
     */
    private Long userId;
    /**
     * 企业主键
     */
    private Long companyId;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户真实姓名
     */
    private String realName;
    /**
     * 性别 0 为女 1为男
     */
    private Integer gender;
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

}
