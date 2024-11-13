package com.marsview.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目列表
 */
@Data
@TableName(value = "pages")
public class Pages implements Serializable {
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
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long user_id;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String user_name;

    /**
     * 页面数据
     */
    @TableField(value = "page_data")
    private String page_data;

    /**
     * 页面描述
     */
    @TableField(value = "remark")
    private String remark;

    /**
     * 是否开放 1-公开 2-私有
     */
    @TableField(value = "is_public")
    private Integer is_public;

    /**
     * 是否可编辑 1-编辑 2-只读
     */
    @TableField(value = "is_edit")
    private Integer is_edit;

    /**
     * 页面预览图
     */
    @TableField(value = "preview_img")
    private String preview_img;

    /**
     * stg 页面发布ID
     */
    @TableField(value = "stg_publish_id")
    private Long stg_publish_id;

    /**
     * pre 页面发布ID
     */
    @TableField(value = "pre_publish_id")
    private Long pre_publish_id;

    /**
     * prd 页面发布ID
     */
    @TableField(value = "prd_publish_id")
    private Long prd_publish_id;

    /**
     * 发布状态：1未保存 2已保存 3已发布
     */
    @TableField(value = "stg_state")
    private Integer stg_state;

    /**
     * 发布状态：1未保存 2已保存 3已发布
     */
    @TableField(value = "pre_state")
    private Integer pre_state;

    /**
     * 发布状态：1未保存 2已保存 3已发布
     */
    @TableField(value = "prd_state")
    private Integer prd_state;

    /**
     * 所属项目ID
     */
    @TableField(value = "project_id")
    private Long project_id;

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