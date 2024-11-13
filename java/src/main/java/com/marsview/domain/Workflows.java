package com.marsview.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 工作流模板配置
 */
@Data
@TableName(value = "workflows")
public class Workflows implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 表单名称
     */
    @TableField(value = "form_name")
    private String form_name;

    /**
     * 表单描述
     */
    @TableField(value = "form_desc")
    private String form_desc;

    /**
     * 配置页面ID
     */
    @TableField(value = "page_id")
    private Integer page_id;

    /**
     * 工作流配置数据
     */
    @TableField(value = "template_data")
    private String template_data;

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