package com.marsview.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 组件库发布表
 */
@Data
@TableName(value = "lib_publish")
public class LibPublish implements Serializable {
    /**
     * 索引
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 发布ID
     */
    @TableField(value = "release_id")
    private String release_id;

    /**
     * 组件库关联ID
     */
    @TableField(value = "lib_id")
    private String lib_id;

    /**
     * React远程地址
     */
    @TableField(value = "react_url")
    private String react_url;

    /**
     * css远程地址
     */
    @TableField(value = "css_url")
    private String css_url;

    /**
     * config远程地址
     */
    @TableField(value = "config_url")
    private String config_url;

    /**
     * 版本hash
     */
    @TableField(value = "release_hash")
    private String release_hash;

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
     * 记录更新次数
     */
    @TableField(value = "`count`")
    private Integer count;

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