package com.oxygen.controller;

import com.oxygen.model.UserModel;
import com.oxygen.param.UserParam;
import com.oxygen.param.UserSaveParam;
import com.oxygen.response.OxyResponse;
import com.oxygen.service.UserService;
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
     * 打印耗时统计
     *
     * @return
     */
    @GetMapping("get")
    public OxyResponse get(@RequestParam String phone) {
        UserModel user = userService.getByPhone(phone);
        return OxyResponse.success(user);
    }

    /**
     * 模拟保存
     */
    @PostMapping("list")
    public OxyResponse list(@RequestBody UserParam param) {

        List<UserModel> list = userService.list(param);

        return OxyResponse.success(list);
    }

    @PostMapping("delete")
    public OxyResponse list(@RequestParam Long userId) {

         int i= userService.delete(userId);

        return OxyResponse.success();
    }

    @PostMapping("insert")
    public OxyResponse insert(@RequestBody UserSaveParam userSaveParam) {

        Long id = userService.save(userSaveParam);
        return OxyResponse.success(id);
    }


}
