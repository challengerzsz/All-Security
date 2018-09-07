package com.bsb.security.core.social.qq.connect;

import com.bsb.security.core.social.qq.api.QQ;
import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Template;

/**
 * @Author: zeng
 * @Date: 2018/7/27 14:36
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

    private String appId;

    public QQServiceProvider(OAuth2Operations oauth2Operations) {
        super(oauth2Operations);
    }

//    public QQServiceProvider(String appId, String appSecret) {
//        super(new OAuth2Template(appId, appSecret, authorizeUrl, accessTokenUrl));
//    }

    @Override
    public QQ getApi(String s) {
        return null;
    }
}
