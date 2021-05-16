package com.admin.entity;

import com.admin.center.LoginStrategyContext;
import com.admin.service.LoginStrategyService;
import com.admin.service.impl.FingermarkLoginServiceImpl;
import com.admin.service.impl.PhonenumberServiceImpl;
import com.admin.service.impl.UserNameLoginServiceImpl;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author gyy
 * @Date 2021/4/29 下午5:25
 * @Version 1.0
 * @Remarks
 */
@Data
public class LoginDTO {

    private Integer loginType;

    private String username;

    private String password;

    //指纹信息串
    private String fingerMark;

    //手机号
    private String phoneNumber;

    //验证码
    private String vcode;

    public static Map<Integer,String> loginServiceBeanNameMaps = initLoginServiceBeanNameMaps();

    private static Map<Integer, String> initLoginServiceBeanNameMaps() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        LoginTypeEnum[] loginTypeEnums = LoginTypeEnum.values();
        for (LoginTypeEnum thisLoginType:loginTypeEnums){
            map.put(thisLoginType.getIndex(),thisLoginType.getValue());
        }
        return map;
    }



    /**
     * 登录类型
     */
    public enum LoginTypeEnum{
        //用户名密码登录
        USERNAME_LOGIN(1,"userNameLoginServiceImpl"),
        //指纹登录
        FINGERMARK_LOGIN(2,"fingermarkLoginServiceImpl"),
        //手机号验证码登录
        PHONENUMBER_LOGIN(3,"phonenumberServiceImpl"),
        ;
        private int index;
        private String value;
        LoginTypeEnum(int index, String value) {
            this.index = index;
            this.value = value;
        }
        public int getIndex() {
            return index;
        }
        public String getValue() {
            return value;
        }
    }

}
