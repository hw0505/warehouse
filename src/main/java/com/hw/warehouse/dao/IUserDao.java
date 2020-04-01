package com.hw.warehouse.dao;

import com.hw.warehouse.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * dao 接口
 * @author liurl
 */
@Mapper
public interface IUserDao {
    /**
     * 查询
     * @return
     */
    @Select("select id, name, password from user")
    List<UserEntity> query();
}
