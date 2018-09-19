package com.bsb.security;

import com.bsb.security.browser.mapper.IUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserMapper userMapper;


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登录用户名");
        return buildUser(username);
    }

    /**
     * 根据SpringSocial登录之后查找出的与本应用相关联的userId进行登录校验
     * @param userId
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {

        logger.info("与第三方账号关联的userId");
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String userId) {

//        根据用户名查找并封装用户信息UserDetails实例
        String password  = userMapper.getLoginPassword(userId);

//        这里应该只是给出数据库中的密码，应在注册时和修改密码时进行加密
        return new SocialUser(userId, passwordEncoder.encode(password), true, true,
                true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
