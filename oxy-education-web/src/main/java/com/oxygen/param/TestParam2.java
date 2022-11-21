package com.oxygen.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author oxy
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestParam2 {
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
