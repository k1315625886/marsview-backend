package com.marsview.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 页面权限列表
 */
@Data
@TableName(value = "roles")
public class Roles implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目ID
     */
    @TableField(value = "project_id")
    private Long project_id;

    /**
     * 角色名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 全选的菜单ID
     */
    @TableField(value = "half_checked")
    private String half_checked;

    /**
     * 半全选的菜单ID
     */
    @TableField(value = "`checked`")
    private String checked;

    /**
     * 角色备注
     */
    @TableField(value = "remark")
    private String remark;

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

    private static final long serialVersionUID = 1L;
}