package com.admin.center;

import com.admin.entity.LoginDTO;
import com.admin.service.LoginStrategyService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author gyy
 * @Date 2021/4/30 上午11:05
 * @Version 1.0
 * @Remarks  策略类核心配置
 */
@Component
public class LoginStrategyContext {

    public Map<Integer,LoginStrategyService> handleLoginServiceMap = new HashMap<>();

    public LoginStrategyService getLoginStrategyService(Integer loginType){
       return handleLoginServiceMap.get(loginType);
    }

    public void putLoginStrategyService(Integer loginType,LoginStrategyService loginStrategyService){
         handleLoginServiceMap.put(loginType,loginStrategyService);
    }
}
