package com.oxygen.service.impl;

import com.oxygen.annotation.LogAspect;
import com.oxygen.constant.SystemErrorCode;
import com.oxygen.exception.OxyException;
import com.oxygen.mapper.UserMapper;
import com.oxygen.model.UserModel;
import com.oxygen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author oxy
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    @LogAspect(name = "用户查询")
    public UserModel getById(Long userId) {
        UserModel userModel = userMapper.getById(userId);
        if(userModel == null){
            throw new OxyException(SystemErrorCode.REQUEST_PARAM_ERROR,SystemErrorCode.DATA_NULL_ERROR_MSG);
        }
        return userModel;
    }



}
