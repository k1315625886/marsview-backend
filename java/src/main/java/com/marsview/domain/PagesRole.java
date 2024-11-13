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
@TableName(value = "pages_role")
public class PagesRole implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 页面ID
     */
    @TableField(value = "page_id")
    private Long page_id;

    /**
     * 角色权限 1-developer 2-visitor
     */
    @TableField(value = "`role`")
    private Long role;

    /**
     * 项目类型 1-项目 2-页面
     */
    @TableField(value = "`type`")
    private Integer type;

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