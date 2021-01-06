package com.fxj.springsecurityoauth2.service;

import com.fxj.springsecurityoauth2.pojo.SysUser;
import com.fxj.springsecurityoauth2.service.impl.UserDetailServiceImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import java.security.Principal;

public interface UserService extends UserDetailsService {
//    SysUser Login(Principal principal,String userName, String Password) throws HttpRequestMethodNotSupportedException;
}
