package com.bsb.security.core.social.qq.connect;

import com.bsb.security.core.social.qq.api.QQ;
import com.bsb.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import java.io.IOException;

/**
 * @Author: zeng
 * @Date: 2018/9/19 22:09
 */
public class QQAdapter implements ApiAdapter<QQ> {

    /**
     * 测试之前与认证服务器的请求是否是成功的
     * @param api
     * @return
     */
    @Override
    public boolean test(QQ api) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQUserInfo userInfo = api.getUserInfo();
        values.setDisplayName(userInfo.getNickname());
        values.setImageUrl(userInfo.getFigureurl_qq_1());
        values.setProfileUrl(null);
        values.setProviderUserId(null);
    }

    @Override
    public UserProfile fetchUserProfile(QQ api) {
        return null;
    }

    @Override
    public void updateStatus(QQ api, String message) {

    }
}
