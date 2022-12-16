package com.oxygen.education.param;

import com.oxygen.education.enums.GenderEnum;
import lombok.Data;

/**
 * 用户保存入参
 * @author oxy
 */
@Data
public class UserSaveParam {
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
    private String name;
    /**
     * 性别 0 为女 1为男
     */
    private GenderEnum gender;
}
