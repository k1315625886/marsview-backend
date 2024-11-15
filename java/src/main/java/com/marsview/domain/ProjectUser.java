package com.marsview.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户列表
 */
@Data
@TableName(value = "project_user")
public class ProjectUser implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 系统角色：1：管理员 2：普通用户
     */
    @TableField(value = "system_role")
    private Integer system_role;

    /**
     * 项目ID
     */
    @TableField(value = "project_id")
    private Long project_id;

    /**
     * 项目角色ID
     */
    @TableField(value = "role_id")
    private Integer role_id;

    /**
     * 通行证id
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 姓名
     */
    @TableField(value = "user_name")
    private String user_name;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at")
    private Date updated_at;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date created_at;

    private static final long serialVersionUID = 1L;
}