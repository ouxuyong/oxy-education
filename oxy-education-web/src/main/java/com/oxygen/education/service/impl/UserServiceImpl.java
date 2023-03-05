package com.oxygen.education.service.impl;

import com.oxygen.education.annotation.LogAspect;
import com.oxygen.education.constant.SystemErrorCode;
import com.oxygen.education.context.OxygenContextHolder;
import com.oxygen.education.convert.UserConvert;
import com.oxygen.education.dto.UserDto;
import com.oxygen.education.exception.OxyException;
import com.oxygen.education.model.CompanyTableConfig;
import com.oxygen.education.model.UserModel;
import com.oxygen.education.param.UserParam;
import com.oxygen.education.service.CompanyTableConfigService;
import com.oxygen.education.mapper.UserMapper;
import com.oxygen.education.param.UserSaveParam;
import com.oxygen.education.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author oxy
 */
@Service
public class UserServiceImpl implements UserService {
    private final static String USER_TYPE = "user";

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CompanyTableConfigService companyTableConfigService;
    @Resource
    private UserConvert userConvert;

    @Override
    @LogAspect(name = "用户查询")
    public UserDto getById(Long userId) {
        UserModel userModel = userMapper.getById(userId);
        if(userModel == null){
            throw new OxyException(SystemErrorCode.REQUEST_PARAM_ERROR,SystemErrorCode.DATA_NULL_ERROR_MSG);
        }

        return userConvert.toDto(userModel);
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

        UserModel user = userConvert.toModel(userSaveParam);
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

    @Override
    public String logIn(String phone, String password) {
        UserModel user = userMapper.getByLogIn(phone,password);
        if(user == null){
            throw new OxyException(SystemErrorCode.SYSTEM_ERROR,"用户名或密码不正确");
        }
        return UUID.randomUUID().toString().replaceAll("_","");
    }

    @Override
    public UserModel paasGet(Integer companyId, String phone) {
        CompanyTableConfig config = companyTableConfigService.cacheFind(companyId, USER_TYPE);
        if(config == null){
            throw new OxyException(SystemErrorCode.SYSTEM_ERROR,"PASS用户配置表不存在");
        }

        return userMapper.paasGet(config.getRealTable(),phone);
    }

    @Override
    public UserModel getByPhone(String phone) {
        UserModel model = userMapper.getByPhone(phone, OxygenContextHolder.getCompanyId());
        return model;
    }


}
