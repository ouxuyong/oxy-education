package com.oxygen.education.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA. User: lai cl Date: 2019/11/4 Description:
 */
public interface BaseEnum<T> {
    T getDictKey();

    default T getValue() {
        return this.getDictKey();
    }

    @JsonCreator
    static <T> BaseEnum valueOfEnum(Class<BaseEnum> enumClass, T value) {
        if (value == null) {
            return null;
        }
        BaseEnum optional1 = getBaseEnum((Class<BaseEnum>) enumClass, value);
        if (optional1 != null){
            return optional1;
        }
        throw new RuntimeException("未找到：" + value + "对应的" + enumClass.getName());
    }

    /**
     *  获取枚举
     * @param enumClass
     * @param value
     * @param <T>
     * @return
     */
    static <T> BaseEnum getBaseEnum(Class<BaseEnum> enumClass, T value) {
        BaseEnum[] enums = enumClass.getEnumConstants();
        Optional<BaseEnum> optional =
                Arrays.asList(enums).stream().filter(baseEnum -> baseEnum.getDictKey().equals(value)).findAny();
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @JsonCreator
    static <T> BaseEnum valueOf(Class<BaseEnum> enumClass, T value) {
        if (value == null) {
            return null;
        }
        BaseEnum optional = getBaseEnum(enumClass, value);
        if (optional != null){
            return optional;
        }
        return null;
    }

    static <T extends Enum<T> & BaseEnum> T convert(Class<T> enumType, Object value) {
        if (enumType == null || value == null) {
            return null;
        }

        T[] enumConstants = enumType.getEnumConstants();
        for (T enumConstant : enumConstants) {
            Object enumValue = enumConstant.getValue();
            if (Objects.equals(enumValue, value) || Objects.equals(enumValue.toString(), value.toString())) {
                return enumConstant;
            }
        }

        return null;
    }
}
