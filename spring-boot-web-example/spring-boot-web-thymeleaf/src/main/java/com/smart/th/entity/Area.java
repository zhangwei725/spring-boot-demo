package com.smart.th.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 累积代码  ---> 结合业务
 * 地区码表
 */
@Data
public class Area {
    /**
     * 地区Id
     */
    private Integer areaId;

    /**
     * 地区编码
     */
    private String areaCode;

    /**
     * 地区名
     */
    private String areaName;

    /**
     * 地区级别（1:省份province,2:市city,3:区县district,4:街道street）
     */
    private Byte level;

    /**
     * 城市编码
     */
    private String cityCode;

    /**
     * 城市中心点（即：经纬度坐标）
     */
    private String center;

    /**
     * 地区父节点
     */
    private Integer parentId;

    /**
     * 逻辑删除 0表示未删除  1表示删除
     */
    private Integer isDel;

    /**
     * 乐观锁字段
     */
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