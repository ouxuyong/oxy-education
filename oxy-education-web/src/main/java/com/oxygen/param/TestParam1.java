package com.oxygen.param;


import lombok.Data;

/**
 * @author oxy
 */
@Data
public class TestParam1 {
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 备注
     */
    private String remake;
}
