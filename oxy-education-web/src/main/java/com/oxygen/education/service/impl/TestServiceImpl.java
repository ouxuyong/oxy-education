package com.oxygen.education.service.impl;

import com.oxygen.education.annotation.Encryption;
import com.oxygen.education.service.TestService;
import com.oxygen.education.context.OxygenContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

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

    @Async
    @Override
    public void printHeader() {
//        String local = OxygenContextHolder.getThreadLocal();
////        String header = request.getHeader("x-user-id");
//        log.info("线程 {} threadLocal={}" ,Thread.currentThread().getName(),local);
    }

    @Override
    public void execute(Long companyId, Long userId, String phone) {
        //todo 执行业务A
        businessA(companyId,userId);

        //todo 执行业务B
        businessB(companyId,userId);
    }

    /**
     * 业务A
     * @param companyId
     * @param userId
     */
    private void businessA(Long companyId, Long userId) {
        //todo 执行业务
        log.info("businessA companyId={} userId={}",companyId,userId);

        // todo 执行业务代码 businessService(companyId,userId)
    }

    private void businessB(Long companyId, Long userId) {
        //todo 执行业务
        log.info("businessB companyId={} userId={}",companyId,userId);

        // todo 执行业务代码 businessService(companyId,userId)
    }




    @Override
    public void executeV2(String phone) {
        log.info("executeV2 companyId={} userId={}", OxygenContextHolder.getCompanyId(), OxygenContextHolder.getUserId());
        //todo 执行业务A2
        businessA2();

        //todo 执行业务B2
        businessB2();
    }

    @Async
    @Override
    public void asyncExecute(String phone) {
        Long companyId = OxygenContextHolder.getCompanyId();
        Long userId = OxygenContextHolder.getUserId();
        log.info("businessA2 companyId={} userId={}", companyId,userId);
    }


    /**
     *
     * 业务A V2 使用ThreadLocal
     */
    private void businessA2() {
        //todo 执行业务
        log.info("businessA2 companyId={} userId={}", OxygenContextHolder.getCompanyId(), OxygenContextHolder.getUserId());

        // todo 执行业务代码 businessService()
    }

    private void businessB2() {
        //todo 执行业务
        log.info("businessB2 companyId={} userId={}", OxygenContextHolder.getCompanyId(), OxygenContextHolder.getUserId());

        // todo 执行业务代码 businessService()
    }


}
