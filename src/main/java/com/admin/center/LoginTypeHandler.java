package com.admin.center;

import com.admin.entity.LoginDTO;

import java.lang.annotation.*;

/**
 * @Author gyy
 * @Date 2021/4/30 上午11:53
 * @Version 1.0
 * @Remarks
 */
@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginTypeHandler {

    LoginDTO.LoginTypeEnum value();
}
