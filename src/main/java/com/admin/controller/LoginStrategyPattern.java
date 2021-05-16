package com.admin.controller;

import com.admin.center.LoginStrategyDefaultContext;
import com.admin.entity.LoginDTO;
import com.admin.service.LoginStrategyService;
import com.admin.service.impl.UserNameLoginDefaultServiceImpl;

/**
 * @Author gyy
 * @Date 2021/5/16 上午11:12
 * @Version 1.0
 * @Remarks
 */
public class LoginStrategyPattern {

    public static void main(String[] args) {
        LoginStrategyService loginStrategyService = new UserNameLoginDefaultServiceImpl();
        LoginStrategyDefaultContext loginStrategyDefaultContext = new LoginStrategyDefaultContext(loginStrategyService);
        loginStrategyDefaultContext.login(new LoginDTO());
    }
}
