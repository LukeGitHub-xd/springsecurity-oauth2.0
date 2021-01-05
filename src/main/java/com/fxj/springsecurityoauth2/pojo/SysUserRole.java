package com.fxj.springsecurityoauth2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class SysUserRole {

    @TableId(type = IdType.AUTO)
    private int id;

    @TableField("u_id")
    private int uId;

    @TableField("r_id")
    private int rId;
}
