package com.fxj.springsecurityoauth2.controller;

import com.fxj.springsecurityoauth2.pojo.SysUser;
import com.fxj.springsecurityoauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.soap.Addressing;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private TokenEndpoint tokenEndpoint;

    @GetMapping("/")
    public String a(){
        return "aa";
    }

//    @GetMapping("login")
//    public OAuth2AccessToken login(Principal principal,String username, String password) throws HttpRequestMethodNotSupportedException {
//        SysUser sysUser =  userService.Login(principal,username,password);
//        UserDetails userDetails = userService.loadUserByUsername(sysUser.getUsername());
//        Map<String,String> map = new HashMap<>();
//        map.put("grant_type","password");
//        map.put("client_id","admin-app");
//        map.put("client_secret","123456");
////        map.put("refresh_token","");
//        map.put("username",userDetails.getUsername());
//        map.put("password",userDetails.getPassword());
//        if (sysUser != null) {
//            OAuth2AccessToken oAuth2AccessToken = tokenEndpoint.postAccessToken(principal,map).getBody();
//            return oAuth2AccessToken;
//        }
//        return null;
//    }

    @GetMapping("allow")
    public String allowAll(){
        return "无需验证即可访问";
    }
}
