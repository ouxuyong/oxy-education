package com.oxygen.mapper;

import com.oxygen.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author oxy
 */
@Mapper
public interface UserMapper {
    /**
     *
     * @param userId
     * @return
     */
    UserModel getById(@Param("userId") Long userId);

}
