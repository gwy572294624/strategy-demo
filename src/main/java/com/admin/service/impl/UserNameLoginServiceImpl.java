package com.admin.service.impl;

import com.admin.center.LoginTypeHandler;
import com.admin.entity.LoginDTO;
import com.admin.service.LoginStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author gyy
 * @Date 2021/4/29 下午5:24
 * @Version 1.0
 * @Remarks
 */
@Service
@LoginTypeHandler(LoginDTO.LoginTypeEnum.USERNAME_LOGIN)
public class UserNameLoginServiceImpl implements LoginStrategyService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String login(LoginDTO loginDTO) {
        System.out.println("UserNameLoginServiceImpl");
        Boolean bo = redisTemplate.opsForValue().setIfAbsent("userName_userId","用户信息",60, TimeUnit.SECONDS);
        System.out.println(bo);
        System.out.println("通过账号密码登录成功");
        return "通过账号密码登录成功";
    }
}
