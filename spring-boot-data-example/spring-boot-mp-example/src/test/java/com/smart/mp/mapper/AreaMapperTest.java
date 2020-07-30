package com.smart.mp.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.mp.entity.Area;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

// 用面向对象的方式操作数据ORM框架
// 半自动

/**
 * 根据id查询
 * 根据条件查询单条记录(返回结果不是是单条记录)
 * 查询多条记录
 * 分页查询
 * 语法角度
 * 过滤列
 * 过滤行
 * where  限定符
 */
@SpringBootTest
@Slf4j
public class AreaMapperTest {
    @Autowired
    AreaMapper areaMapper;

    /**
     * select  * from  表名
     * where 条件
     * group by  分组
     * having  分组过滤
     * order by
     */
    @Test
    public void testSelectOne() {
//        QueryWrapper   过滤条件
//        select * from  t_area  where  area_name = '东城区'
        QueryWrapper<Area> qw = new QueryWrapper<>();

        Area area = areaMapper.selectOne(qw);
    }

    @Test
    public void testList() {
        QueryWrapper<Area> qw = new QueryWrapper<>();
        List<Area> areas = areaMapper.selectList(qw);
        log.info(areas.toString());
    }

    /**
     * 分页查询
     */
    @Test
    public void testPage() {
        Page<Area> page = new Page<>();
        // 查询第二页 每页20
        page.setCurrent(2);
        page.setSize(20);
        IPage<Area> page1 = areaMapper.selectPage(page, null);
        List<Area> records = page1.getRecords();
        // 总也数
        long total = page1.getTotal();
        // 总页数据
        long pages = page.getPages();
    }

    /**
     *
     */
    @Test
    public void insert() {

    }

    /**
     * sql学习方式
     * <p>
     * 1.8 新的特性
     * 参数是接口对象  接口只有一个方法的时候都可以转化lambda表达式
     */

    /**
     * 过滤列
     * select()方法
     * where 封装成限定符
     * >(gt) >=(ge)  =( eq  )  <(lt )  <=(le) !=(ne)
     * like 以什么开头  包含  结尾
     * in()
     * between()
     * or()
     * and()
     * 分组
     * groupBy()
     * having()
     * 排序
     * orderByxxx()
     */

    @Test
    public void testQueryWrapper() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
//        select * from where
        QueryWrapper<Area> qw = new QueryWrapper<>();
        //  xxx=zhi  and  level=1
//        (username="" and phone="")
        qw
                .select(Area.COL_CITY_CODE, Area.COL_CENTER)
                .eq(Area.COL_AREA_NAME, "")
                .and(query -> query.eq(Area.COL_LEVEL, 1))
                // 包含 %键字%
                //
                .like("", "")
                .likeLeft("", "")
                .likeRight("列名名", "")
                .or()
                .between(Area.COL_AREA_ID, 1, 1000)
                .in(Area.COL_AREA_ID, 1, 20, 50)
                .in(Area.COL_AREA_ID, ids)
                .orderByAsc()
                .orderByDesc()
                .groupBy();
    }

    @Test
    public void testPage1() {
        areaMapper.selectPage(new Page<Area>(1, 10), null);
    }
    // 了解
    @Test
    public void testLambda() {
//      select * from t_area where (area_code = -1 and area_id=1)
        QueryWrapper<Area> qw = new QueryWrapper<>();
        qw.lambda().and(query -> {
            query.eq(Area::getAreaCode, "-1").eq(Area::getAreaId, 1);
        });
    }
}
