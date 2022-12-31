package com.oxygen.education.controller;

import com.oxygen.education.dto.UserDto;
import com.oxygen.education.model.UserModel;
import com.oxygen.education.param.UserParam;
import com.oxygen.education.param.UserSaveParam;
import com.oxygen.education.response.OxyResponse;
import com.oxygen.education.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户控制器
 *
 * @author oxy
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据手机号码获取详情
     *
     * @return
     */
    @GetMapping("get")
    public OxyResponse get(@RequestParam String phone) {
        UserModel user = userService.getByPhone(phone);
        return OxyResponse.success(user);
    }

    /**
     * 获取列表
     */
    @PostMapping("list")
    public OxyResponse list(@RequestBody UserParam param) {

        List<UserModel> list = userService.list(param);

        return OxyResponse.success(list);
    }

    /**
     * 删除用户数据
     * @param userId
     * @return
     */
    @PostMapping("delete")
    public OxyResponse list(@RequestParam Long userId) {

        userService.delete(userId);

        return OxyResponse.success();
    }

    /**
     * 新增数据
     * @param userSaveParam
     * @return
     */
    @PostMapping("insert")
    public OxyResponse insert(@RequestBody UserSaveParam userSaveParam) {

        Long id = userService.save(userSaveParam);
        return OxyResponse.success(id);
    }

    /**
     * 登录
     *
     * @return
     */
    @PostMapping("logIn")
    public OxyResponse logIn(@RequestParam String phone, @RequestParam String password) {
        String token = userService.logIn(phone, password);
        return OxyResponse.success(token);
    }

    /**
     * PAAS 获取详情
     *
     * @return
     */
    @GetMapping("paasGet")
    public OxyResponse paasGet(@RequestParam Integer companyId ,@RequestParam String phone) {
        UserModel user = userService.paasGet(companyId,phone);
        return OxyResponse.success(user);
    }

}
