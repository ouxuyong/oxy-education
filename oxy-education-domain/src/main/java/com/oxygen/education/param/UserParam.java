package com.oxygen.education.param;

import lombok.Data;

/**
 * 用户查询入参
 * @author oxy
 */
@Data
public class UserParam {
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
    private String realName;
    /**
     * 性别 0 为女 1为男
     */
    private Integer gender;
}
