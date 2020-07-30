package com.smart.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smart.mp.entity.Area;
import org.apache.ibatis.annotations.Param;

public interface AreaMapper extends BaseMapper<Area> {
    Area selectByName(@Param("name") String name);
}