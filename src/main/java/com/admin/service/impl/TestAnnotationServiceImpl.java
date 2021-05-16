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
 * @Date 2021/4/30 下午2:23
 * @Version 1.0
 * @Remarks
 */
@Service
@LoginTypeHandler(LoginDTO.LoginTypeEnum.USERNAME_LOGIN)
public class TestAnnotationServiceImpl implements LoginStrategyService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public String login(LoginDTO loginDTO) {
        System.out.println("TestAnnotationServiceImpl");
        Boolean bo = redisTemplate.opsForValue().setIfAbsent("testAnnotation_userId","用户信息",60, TimeUnit.SECONDS);
        System.out.println(bo);
        return "TestAnnotationServiceImpl";
    }
}
