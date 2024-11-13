package com.marsview.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 数据测试表
 */
@Data
@TableName(value = "firefly")
public class Firefly implements Serializable {
    /**
     * 增长ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 种类
     */
    @TableField(value = "`type`")
    private String type;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 繁殖周期
     */
    @TableField(value = "`time`")
    private Short time;

    /**
     * 技能
     */
    @TableField(value = "skill")
    private String skill;

    /**
     * 售价
     */
    @TableField(value = "sales")
    private Double sales;

    /**
     * 分布区域
     */
    @TableField(value = "area")
    private String area;

    /**
     * 状态：1 在售 2 停售 3 下架
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 更新时间戳
     */
    @TableField(value = "updated_at")
    private Date updated_at;

    /**
     * 时间戳
     */
    @TableField(value = "created_at")
    private Date created_at;

    private static final long serialVersionUID = 1L;
}