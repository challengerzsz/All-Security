package com.bsb.security.core.social.qq.connect;

import com.bsb.security.core.social.qq.api.QQ;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @Author: zeng
 * @Date: 2018/9/19 22:15
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {


    public QQConnectionFactory(String providerId, String appId, String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }
}
