package com.smart.example.domain.entity;

import lombok.Data;

/**
    * 地区码表
    */
@Data
public class Area {
    /**
    * 地区Id
    */
    private Integer areaid;

    /**
    * 地区编码
    */
    private String areacode;

    /**
    * 地区名
    */
    private String areaname;

    /**
    * 地区级别（1:省份province,2:市city,3:区县district,4:街道street）
    */
    private Byte level;

    /**
    * 城市编码
    */
    private String citycode;

    /**
    * 城市中心点（即：经纬度坐标）
    */
    private String center;

    /**
    * 地区父节点
    */
    private Integer parentid;
}