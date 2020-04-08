package com.hw.warehouse.dao;

import com.hw.warehouse.entity.InProductEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * dao 接口
 * @author hw
 */
@Mapper
public interface InProductDao {
    /**
     * 查询
     * @return
     */
    @Select("select inId, inName, inNumber, inDate from product_in")
    List<InProductEntity> query();

    @Insert("insert into product_in(inName, inNumber, inDate) values(#{inName},#{inNumber},#{inDate})")
    boolean saveInProduct(InProductEntity inProductEntity);
}
