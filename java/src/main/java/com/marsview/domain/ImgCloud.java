package com.marsview.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 图片云服务
 */
@Data
@TableName(value = "img_cloud")
public class ImgCloud implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
     * 文件原名称
     */
    @TableField(value = "origin_name")
    private String origin_name;

    /**
     * 文件hash名称
     */
    @TableField(value = "file_name")
    private String file_name;

    /**
     * 文件类型
     */
    @TableField(value = "`type`")
    private String type;

    /**
     * 文件大小，单位byte
     */
    @TableField(value = "`size`")
    private Integer size;

    /**
     * 图片cdn地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date created_at;

    private static final long serialVersionUID = 1L;
}