package com.smart.mp.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 累积代码  ---> 结合业务
 * 地区码表
 */
@Data
@TableName(value = "t_area")
public class Area {
    /**
     * 地区Id
     */
    @TableId(value = "area_id", type = IdType.INPUT)
    private Integer areaId;

    /**
     * 地区编码
     */
    @TableField(value = "area_code")
    private String areaCode;

    /**
     * 地区名
     */
    @TableField(value = "area_name")
    private String areaName;

    /**
     * 地区级别（1:省份province,2:市city,3:区县district,4:街道street）
     */
    @TableField(value = "level")
    private Byte level;

    /**
     * 城市编码
     */
    @TableField(value = "city_code")
    private String cityCode;

    /**
     * 城市中心点（即：经纬度坐标）
     */
    @TableField(value = "center")
    private String center;

    /**
     * 地区父节点
     */
    @TableField(value = "parent_id")
    private Integer parentId;

    /**
     * 逻辑删除 0表示未删除  1表示删除
     */
    @TableField(value = "is_del")
    @TableLogic
    private Integer isDel;

    /**
     * 乐观锁字段
     */
    @TableField(value = "version")
    @Version
    private Integer version;

    public static final String COL_AREA_ID = "area_id";

    public static final String COL_AREA_CODE = "area_code";

    public static final String COL_AREA_NAME = "area_name";

    public static final String COL_LEVEL = "level";

    public static final String COL_CITY_CODE = "city_code";

    public static final String COL_CENTER = "center";

    public static final String COL_PARENT_ID = "parent_id";

    public static final String COL_IS_DEL = "is_del";

    public static final String COL_VERSION = "version";
}