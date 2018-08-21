package com.blog.servicehi.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Auther: yule
 * @Date: 2018/8/17 0017 16:40
 * @Description:
 */
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.info("用户名:{}", userName);

        // TODO 根据用户名，查找到对应的密码，与权限

        String password = passwordEncoder.encode("123456");

        log.info("密码:{}", password);

        // 封装用户信息，并返回。参数分别是：用户名，密码，用户权限
        User user = new User(userName, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

        return user;
    }
}
