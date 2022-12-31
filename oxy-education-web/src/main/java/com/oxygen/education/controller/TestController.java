package com.oxygen.education.controller;

import com.oxygen.education.annotation.Encryption;
import com.oxygen.education.model.UserModel;
import com.oxygen.education.response.OxyResponse;
import com.oxygen.education.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制器
 * @author oxy
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    /**
     * 根据手机号码获取详情
     *
     * @return
     */
    @GetMapping("testSave")
    public OxyResponse testSave(@RequestParam String phone, @RequestParam String password) {
        String cipher = testService.testSave(phone, password);
        return OxyResponse.success(cipher);
    }
}
