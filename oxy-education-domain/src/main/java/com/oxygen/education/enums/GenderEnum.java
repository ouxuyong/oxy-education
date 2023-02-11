package com.oxygen.education.enums;

import lombok.Getter;

/**
 * 性别枚举
 * @author oxy
 */
@Getter
public enum GenderEnum implements BaseEnum<Integer>{
    /**
     * 女
     */
    WOMAN(0, "女"),
    /**
     * 男
     */
    MAX(1, "男");

    private Integer code;

    private String name;

    GenderEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
    public static GenderEnum getByGender(Integer code) {
        for (GenderEnum e : GenderEnum.values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Integer getDictKey() {
        return code;
    }
}
