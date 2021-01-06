package com.fxj.springsecurityoauth2.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fxj.springsecurityoauth2.mapper.RoleMapper;
import com.fxj.springsecurityoauth2.mapper.UserMapper;
import com.fxj.springsecurityoauth2.mapper.UserRoleMapper;
import com.fxj.springsecurityoauth2.pojo.SysRole;
import com.fxj.springsecurityoauth2.pojo.SysUser;
import com.fxj.springsecurityoauth2.pojo.SysUserRole;
import com.fxj.springsecurityoauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

//@Service("myService")
@Service
public class UserDetailServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private UserRoleMapper userRoleMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUser user = new SysUser();
        List<SysUserRole> userRoles = new ArrayList<>();
        List<SysRole> roles = new ArrayList<>();
        List<Integer> rIds = new ArrayList<>();
        user = userMapper.selectOne(new QueryWrapper<SysUser>().lambda().eq(SysUser::getUsername,s));
        userRoles = userRoleMapper.selectList(new QueryWrapper<SysUserRole>().lambda().eq(SysUserRole::getUId,user.getId()));
        userRoles.forEach(a->{
            rIds.add(a.getRId());
        });
        roles = roleMapper.selectList(new QueryWrapper<SysRole>().lambda().in(SysRole::getId,rIds));
        user.setRoleList(roles);
        return user;
    }

//    @Override
//    public SysUser Login(Principal principal,String userName, String password) throws HttpRequestMethodNotSupportedException {
//        SysUser sysUser = new SysUser();
//        sysUser = userMapper.selectOne(new QueryWrapper<SysUser>().lambda()
//                .eq(SysUser::getUsername,userName).eq(SysUser::getPassword,password));
//        return sysUser;
//    }
}
