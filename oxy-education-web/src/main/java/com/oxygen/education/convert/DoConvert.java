package com.oxygen.education.convert;

import java.util.List;

/**
 * 通用转换类，仅支持字段完全一致的类
 * @author oxy
 * @param <T> DO
 * @param <U> Model
 */
public interface DoConvert<T, U> {

    T toModel(U u);

    List<T> toModel(List<U> u);

    U toDto(T t);

    List<U> toDto(List<T> t);

}
