package com.oxygen.education.service.impl;

import com.oxygen.education.annotation.Encryption;
import com.oxygen.education.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 测试逻辑类
 * @author oxy
 */
@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Override
    @Encryption("password")
    public String testSave(String phone,  String password) {
        log.info("testSave phone={} password={}",phone,password);
        //todo 密码入库
        return password;
    }
}
