package com.marsview.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 自定义组件库表，用来满足自定义业务
 */
@Data
@TableName(value = "lib")
public class Lib implements Serializable {
    /**
     * 组件ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 组件标识
     */
    @TableField(value = "tag")
    private String tag;

    /**
     * 组件中文名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 组件描述
     */
    @TableField(value = "description")
    private String description;

    /**
     * 组件源码
     */
    @TableField(value = "react_code")
    private String react_code;

    /**
     * 组件样式
     */
    @TableField(value = "less_code")
    private String less_code;

    /**
     * 组件配置
     */
    @TableField(value = "config_code")
    private String config_code;

    /**
     * markdown内容
     */
    @TableField(value = "md_code")
    private String md_code;

    /**
     * 组件hash
     */
    @TableField(value = "hash")
    private String hash;

    /**
     * 通行证ID
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 通行证名称
     */
    @TableField(value = "user_name")
    private String user_name;

    /**
     * 创建时间
     */
    @TableField(value = "updated_at")
    private Date updated_at;

    /**
     * 更新时间
     */
    @TableField(value = "created_at")
    private Date created_at;

    private static final long serialVersionUID = 1L;
}