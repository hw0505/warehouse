package com.hw.warehouse.dao;

import com.hw.warehouse.entity.OutProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * dao 接口
 * @author hw
 */
@Mapper
public interface OutProductDao {
    /**
     * 查询
     * @return
     */
    @Select("select outId, outName, outNumber, outDate from product_out")
    List<OutProductEntity> query();
}
