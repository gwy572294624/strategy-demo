package com.admin.service.impl;

import com.admin.entity.LoginDTO;
import com.admin.service.LoginStrategyService;

/**
 * @Author gyy
 * @Date 2021/5/16 上午11:06
 * @Version 1.0
 * @Remarks
 */
public class PhonenumberDefaultServiceImpl implements LoginStrategyService {


    @Override
    public String login(LoginDTO loginDTO) {
        System.out.println("通过手机号登录成功");
        return "通过手机号登录成功";
    }
}
