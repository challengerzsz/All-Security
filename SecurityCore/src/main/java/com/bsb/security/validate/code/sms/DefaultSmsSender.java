package com.bsb.security.validate.code.sms;

public class DefaultSmsSender implements SmsCodeSender {

    @Override
    public void send(String mobile, String code) {
        System.out.println("向手机发送短信验证码 " + mobile + "code :" + code);
    }
}
