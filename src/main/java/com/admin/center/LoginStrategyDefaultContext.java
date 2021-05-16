package com.admin.center;

import com.admin.entity.LoginDTO;
import com.admin.service.LoginStrategyService;

/**
 * @Author gyy
 * @Date 2021/5/16 上午11:08
 * @Version 1.0
 * @Remarks
 */
public class LoginStrategyDefaultContext {

    private LoginStrategyService loginStrategyService;

    public LoginStrategyDefaultContext(LoginStrategyService loginStrategyService){
        this.loginStrategyService = loginStrategyService;
    }

    public String login(LoginDTO loginDTO){
        return loginStrategyService.login(loginDTO);
    }
}
