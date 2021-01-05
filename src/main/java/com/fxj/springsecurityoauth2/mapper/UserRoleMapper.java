package com.fxj.springsecurityoauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fxj.springsecurityoauth2.pojo.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRoleMapper extends BaseMapper<SysUserRole> {
}
