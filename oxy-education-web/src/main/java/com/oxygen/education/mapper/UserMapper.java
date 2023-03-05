package com.oxygen.education.mapper;

import com.oxygen.education.model.UserModel;
import com.oxygen.education.param.UserParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author oxy
 */
@Mapper
public interface UserMapper {
    /**
     * 根据主键查询用户信息
     *
     * @param userId
     * @return
     */
    UserModel getById(@Param("userId") Long userId);

    /**
     * 根据昵称查询用户信息
     *
     * @param phone
     * @return UserModel
     */
    UserModel getByPhone(@Param("phone") String phone ,@Param("companyId")Long companyId);

    /**
     * 根据条件查询用户列表信息
     *
     * @param param
     * @return
     */
    List<UserModel> list(UserParam param);

    /**
     * 插入数据
     *
     * @param userModel
     * @return
     */
    long insert(UserModel userModel);

    /**
     * 删除
     *
     * @param userId
     * @return
     */
    int delete(@Param("userId") Long userId);

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */
    UserModel getByLogIn(@Param("phone") String phone, @Param("password") String password);

    /**
     * PASS查询
     *
     * @param realTable
     * @param phone
     * @return
     */
    UserModel paasGet(@Param("realTable") String realTable, @Param("phone") String phone);
}
