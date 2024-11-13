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
@TableName(value = "users")
public class Users implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 通行证id
     */
    @TableField(value = "user_name")
    private String user_name;

    /**
     * 姓名
     */
    @TableField(value = "user_pwd")
    private String user_pwd;

    /**
     * 团队ID
     */
    @TableField(value = "team_id")
    private Integer team_id;

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