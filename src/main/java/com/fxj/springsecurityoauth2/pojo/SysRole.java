package com.fxj.springsecurityoauth2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@TableName("sys_role")
@Data
public class SysRole implements GrantedAuthority {

    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField("role_name")
    private String roleName;

    @TableField("role_dec")
    private String roleDec;

    @Override
    public String getAuthority() {
        return roleName;
    }
}
