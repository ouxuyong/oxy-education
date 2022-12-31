package com.oxygen.education.service;

import com.oxygen.education.dto.UserDto;
import com.oxygen.education.model.UserModel;
import com.oxygen.education.param.UserParam;
import com.oxygen.education.param.UserSaveParam;

import java.util.List;

/**
 * @author oxy
 */
public interface UserService {
    /**
     * 根据用户主键获取数据
     * @param userId
     * @return
     */
    UserDto getById(Long userId);

    /**
     * 根据手机号码查询
     * @param phone
     * @return
     */
    UserModel getByPhone(String phone);

    /**
     * 查询列表
     * @param param
     * @return
     */
    List<UserModel> list(UserParam param);

    /**
     * 删除
     * @param userId
     * @return
     */
    int delete(Long userId);

    /**
     * 新增数据
     * @param userSaveParam
     * @return
     */
    Long insert(UserSaveParam userSaveParam);

    /**
     * 保存
     * @param userSaveParam
     * @return
     */
    Long save(UserSaveParam userSaveParam);

    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    String logIn(String phone, String password);

    /**
     * PASS 获取数据
     * @param companyId
     * @param phone
     * @return
     */
    UserModel paasGet(Integer companyId, String phone);
}
