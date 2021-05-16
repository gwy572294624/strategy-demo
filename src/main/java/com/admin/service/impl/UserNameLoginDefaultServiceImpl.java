package com.admin.service.impl;

import com.admin.entity.LoginDTO;
import com.admin.service.LoginStrategyService;

/**
 * @Author gyy
 * @Date 2021/5/16 上午11:05
 * @Version 1.0
 * @Remarks
 */
public class UserNameLoginDefaultServiceImpl implements LoginStrategyService {


    @Override
    public String login(LoginDTO loginDTO) {
        System.out.println("UserNameLoginServiceImpl");
        System.out.println("通过账号密码登录成功");
        return "通过账号密码登录成功";
    }
}
