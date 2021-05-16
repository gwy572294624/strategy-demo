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
 * @Date 2021/4/29 下午5:54
 * @Version 1.0
 * @Remarks
 */
@Service
@LoginTypeHandler(LoginDTO.LoginTypeEnum.PHONENUMBER_LOGIN)
public class PhonenumberServiceImpl implements LoginStrategyService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String login(LoginDTO loginDTO) {
        Boolean bo = redisTemplate.opsForValue().setIfAbsent("phoneNumber_userId","用户信息",60, TimeUnit.SECONDS);
        System.out.println(bo);
        System.out.println("通过手机号登录成功");
        return "通过手机号登录成功";
    }
}
