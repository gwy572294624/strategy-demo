package com.admin.center;

import com.admin.service.LoginStrategyService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author gyy
 * @Date 2021/4/30 上午11:51
 * @Version 1.0
 * @Remarks
 */
@Component
public class LoginStratrgyServiceListener implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Map<String, Object> beans = event.getApplicationContext().getBeansWithAnnotation(LoginTypeHandler.class);
        LoginStrategyContext loginStrategyContext = event.getApplicationContext().getBean(LoginStrategyContext.class);
        beans.forEach((name,bean)->{
            LoginTypeHandler loginTypeHandler = bean.getClass().getAnnotation(LoginTypeHandler.class);
            loginStrategyContext.putLoginStrategyService(loginTypeHandler.value().getIndex(),(LoginStrategyService) bean);
        });
    }
}
