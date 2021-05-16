package com.admin.controller;

import com.admin.center.LoginStrategyContext;
import com.admin.entity.LoginDTO;
import com.admin.service.LoginStrategyService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author gyy
 * @Date 2021/4/29 下午5:22
 * @Version 1.0
 * @Remarks
 */
@RestController
@RequestMapping("/strategy/demo")
public class LoginController {

    @Autowired
    @Qualifier("userNameLoginServiceImpl")
    private LoginStrategyService userNameLoginService;

    @Autowired
    @Qualifier("fingermarkLoginServiceImpl")
    private LoginStrategyService fingermarkLoginService;

    @Autowired
    @Qualifier("phonenumberServiceImpl")
    private LoginStrategyService phonenumberService;

    @Autowired
    private LoginStrategyContext loginStrategyContext;


    @RequestMapping("/login")
    public String loginActionMain(LoginDTO loginDTO){
        if (ObjectUtils.isEmpty(loginDTO.getLoginType())){
            return JSON.toJSONString("loginType - Null");
        }
        String result="";
        switch (loginDTO.getLoginType()){
            case 1:result = userNameLoginService.login(loginDTO);break;
            case 2:result = fingermarkLoginService.login(loginDTO);break;
            case 3:result = phonenumberService.login(loginDTO);break;
            default:result = "无效的登录类型";
        }
        return result;
    }


    @RequestMapping("/login/strategy")
    public String loginActionStrategy(LoginDTO loginDTO){
        if (ObjectUtils.isEmpty(loginDTO.getLoginType())){
            return JSON.toJSONString("loginType - Null");
        }
        String result="";
        LoginStrategyService loginStrategyService = loginStrategyContext.getLoginStrategyService(loginDTO.getLoginType());
        if (ObjectUtils.isEmpty(loginStrategyService)){
            result = "无效的登录方式";
        }else{
            result = loginStrategyService.login(loginDTO);
        }
        return result;
    }

}
