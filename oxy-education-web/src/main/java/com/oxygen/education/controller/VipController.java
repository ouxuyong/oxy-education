package com.oxygen.education.controller;

import com.oxygen.education.model.VipModel;
import com.oxygen.education.response.OxyResponse;
import com.oxygen.education.service.VipService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器
 *
 * @author oxy
 */
@Slf4j
@RestController
@RequestMapping("/vip")
public class VipController {

    @Autowired
    private VipService vipService;

    /**
     * 根据会员主键获取详情
     *
     * @return
     */
    @GetMapping("get")
    public OxyResponse get(@RequestParam Long vipId) {
        VipModel vip = vipService.getById(vipId);
        return OxyResponse.success(vip);
    }

}
