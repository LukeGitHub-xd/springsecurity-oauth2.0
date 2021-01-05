package com.fxj.springsecurityoauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fxj.springsecurityoauth2.pojo.SysRole;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper extends BaseMapper<SysRole> {
}
