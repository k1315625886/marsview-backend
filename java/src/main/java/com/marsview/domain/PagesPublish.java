package com.marsview.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 页面发布列表
 */
@Data
@TableName(value = "pages_publish")
public class PagesPublish implements Serializable {
    /**
     * 页面发布ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 页面ID
     */
    @TableField(value = "page_id")
    private Long page_id;

    /**
     * 页面名称
     */
    @TableField(value = "page_name")
    private String page_name;

    /**
     * 页面数据
     */
    @TableField(value = "page_data")
    private String page_data;

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
     * 版本号
     */
    @TableField(value = "version")
    private String version;

    /**
     * 状态：stg、pre、 prd
     */
    @TableField(value = "env")
    private String env;

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