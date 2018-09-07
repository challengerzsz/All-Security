package com.bsb.security.browser;

import com.bsb.security.browser.mapper.IUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IUserMapper userMapper;


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        根据用户名查找并封装用户信息UserDetails实例
        String password  = userMapper.getLoginPassword(username);

//        这里应该只是给出数据库中的密码，应在注册时和修改密码时进行加密
        return new User(username, passwordEncoder.encode(password), true, true,
                true, true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
