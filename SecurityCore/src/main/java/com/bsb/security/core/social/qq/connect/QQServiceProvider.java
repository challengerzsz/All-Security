package com.bsb.security.core.social.qq.connect;

import com.bsb.security.core.social.qq.api.QQ;
import com.bsb.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @Author: zeng
 * @Date: 2018/7/27 14:36
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    /**
     * 获取授权码的url
     */
    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

    /**
     * 获取accessToken的url
     */
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    public QQServiceProvider(String appId, String appSecret) {
        super(new OAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
    }


    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }
}
