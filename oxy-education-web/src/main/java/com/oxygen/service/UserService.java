package com.oxygen.service;

import com.oxygen.model.UserModel;
import com.oxygen.param.UserParam;
import com.oxygen.param.UserSaveParam;

import java.util.List;

/**
 * @author oxy
 */
public interface UserService {

    UserModel getById(Long userId);

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

    Long save(UserSaveParam userSaveParam);
}
