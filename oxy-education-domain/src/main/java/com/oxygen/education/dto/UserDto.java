package com.oxygen.education.dto;

import com.oxygen.education.enums.GenderEnum;
import lombok.Data;

/**
 * @author oxy
 */
@Data
public class UserDto {
    private String companyId;
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
    private String name;
    /**
     * 性别 0 为女 1为男
     */
    private GenderEnum gender;
    /**
     * 创建时间
     */
    private String createdAt;
    /**
     * 更新时间
     */
    private String updatedAt;
}
