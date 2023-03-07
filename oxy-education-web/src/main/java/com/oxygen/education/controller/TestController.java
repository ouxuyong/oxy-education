package com.oxygen.education.controller;

import com.oxygen.education.context.OxyContext;
import com.oxygen.education.response.OxyResponse;
import com.oxygen.education.service.TestService;
import com.oxygen.education.context.OxygenContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 测试控制器
 *
 * @author oxy
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;

    @Autowired
    private HttpServletRequest request;

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

    @GetMapping("testMethod")
    public OxyResponse testMethod(@RequestParam Long companyId, @RequestParam Long userId
            , @RequestParam String phone) {

        testService.execute(companyId, userId, phone);

        return OxyResponse.success();
    }


    @GetMapping("testMethodV2")
    public OxyResponse testMethodV2(@RequestParam Long companyId, @RequestParam Long userId
            , @RequestParam String phone) {
        //填充上下文
        try {
            OxyContext oxyContext = OxygenContextHolder.getContext();
            oxyContext.setCompanyId(companyId);
            oxyContext.setUserId(userId);

            testService.executeV2(phone);

            return OxyResponse.success();
        } finally {
            OxygenContextHolder.clearOxyContext();
        }
    }


    @GetMapping("testMethodV3")
    public OxyResponse testMethodV3(@RequestParam String phone) {
        testService.executeV2(phone);
        return OxyResponse.success();
    }

    /**
     * 异步测试方法 填充上下文
     * @param phone
     * @return
     * @throws InterruptedException
     */
    @GetMapping("asyncTest")
    public OxyResponse asyncTest(@RequestParam String phone) throws InterruptedException {
        log.info("主线程 {} 调用异步方法前 asyncTest companyId ={} userId ={}"
                ,Thread.currentThread().getName(),OxygenContextHolder.getCompanyId(),OxygenContextHolder.getUserId());

        testService.asyncExecute(phone);
        return OxyResponse.success();
    }

    /**
     * 异步方法不填充上下文
     * @param phone
     * @return
     * @throws InterruptedException
     */
    @GetMapping("asyncTestAdverse")
    public OxyResponse asyncTestAdverse(@RequestParam String phone) throws InterruptedException {
        log.info("主线程 {} 调用异步方法前 asyncTest companyId ={} userId ={}"
                ,Thread.currentThread().getName(),OxygenContextHolder.getCompanyId(),OxygenContextHolder.getUserId());

        testService.asyncExecute(phone);
        return OxyResponse.success();
    }



}
