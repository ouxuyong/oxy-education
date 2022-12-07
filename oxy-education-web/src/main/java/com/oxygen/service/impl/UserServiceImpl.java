package com.oxygen.service.impl;

import com.oxygen.annotation.LogAspect;
import com.oxygen.constant.SystemErrorCode;
import com.oxygen.exception.OxyException;
import com.oxygen.mapper.UserMapper;
import com.oxygen.model.UserModel;
import com.oxygen.param.UserParam;
import com.oxygen.param.UserSaveParam;
import com.oxygen.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

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

    @Override
    public UserModel getByPhone(String phone) {
        return userMapper.getByPhone(phone);
    }

    @Override
    public List<UserModel> list(UserParam param) {
        List<UserModel> list = userMapper.list(param);
        if(CollectionUtils.isEmpty(list)){
            return Collections.emptyList();
        }
        return list;
    }

    @Override
    public int delete(Long userId) {
        int delete = userMapper.delete(userId);
        if(delete == 0){
            throw new OxyException(SystemErrorCode.SYSTEM_ERROR,"删除失败");
        }
        return delete;
    }

    @Override
    public Long insert(UserSaveParam userSaveParam) {
        UserModel user = new UserModel();
        BeanUtils.copyProperties(userSaveParam,user);
        Long num = userMapper.insert(user);
        if(num == 0){
            throw new OxyException(SystemErrorCode.REQUEST_PARAM_ERROR,"插入数据失败");
        }
        return user.getUserId();
    }

    @Override
    public Long save(UserSaveParam userSaveParam) {

        //根据手机号码查询用户信息是否存在
        UserModel model = getByPhone(userSaveParam.getPhone());
        //用户信息存在则报错
        if(model != null){
            throw new OxyException(SystemErrorCode.SYSTEM_ERROR,"该手机号码已注册用户信息，不能重复注册");
        }
        //插入数据
        return insert(userSaveParam);
    }


}
