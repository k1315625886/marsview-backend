package com.marsview.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 菜单列表
 */
@Data
@TableName(value = "menu")
public class Menu implements Serializable {
    /**
     * 菜单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目ID
     */
    @TableField(value = "project_id")
    private Long project_id;

    /**
     * 菜单名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 父级菜单ID
     */
    @TableField(value = "parent_id")
    private Long parent_id;

    /**
     * 方法 1-菜单 2-按钮 3-页面
     */
    @TableField(value = "`type`")
    private Integer type;

    /**
     * 菜单图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 路径
     */
    @TableField(value = "`path`")
    private String path;

    /**
     * 页面ID
     */
    @TableField(value = "page_id")
    private Long page_id;

    /**
     * 排序
     */
    @TableField(value = "sort_num")
    private Integer sort_num;

    /**
     * 状态 1-启用 0-禁用
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 按钮标识
     */
    @TableField(value = "code")
    private String code;

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