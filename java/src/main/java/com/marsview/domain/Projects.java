package com.marsview.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 项目列表
 */
@Data
@TableName(value = "projects")
public class Projects implements Serializable {
    /**
     * 项目ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 项目名称
     */
    @TableField(value = "`name`")
    private String name;

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
     * 项目描述
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * appid
     */
    @TableField(value = "appid")
    private String appid;

    /**
     * logo 地址
     */
    @TableField(value = "logo")
    private String logo;

    /**
     * 方法 1-办公网 2-英特网
     */
    @TableField(value = "visit_type")
    private Integer visit_type;

    /**
     * 姓名
     */
    @TableField(value = "user_name")
    private String user_name;

    /**
     * 通行证id
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 是否开放 1-公开 2-私有
     */
    @TableField(value = "is_public")
    private Integer is_public;

    /**
     * 面包屑 1-有 0 无
     */
    @TableField(value = "breadcrumb")
    private Integer breadcrumb;

    /**
     * 布局 1-上下 2-左右 3-上中下
     */
    @TableField(value = "layout")
    private Integer layout;

    /**
     * 菜单模式：inline-内嵌 vertical-垂直  horizontal-水平
     */
    @TableField(value = "menu_mode")
    private String menu_mode;

    /**
     * 菜单主题色：dark 深色 light-浅色 支持16进制
     */
    @TableField(value = "menu_theme_color")
    private String menu_theme_color;

    /**
     * 多页签 1-显示 0-不显示
     */
    @TableField(value = "tag")
    private Integer tag;

    /**
     * 页脚 1-显示 0-不显示
     */
    @TableField(value = "footer")
    private Integer footer;

    /**
     * 系统主题色
     */
    @TableField(value = "system_theme_color")
    private String system_theme_color;

    private static final long serialVersionUID = 1L;
}