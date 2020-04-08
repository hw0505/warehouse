package com.hw.warehouse.service;

import com.hw.warehouse.entity.InProductEntity;
import com.hw.warehouse.entity.OutProductEntity;
import com.hw.warehouse.vo.InProductVo;
import com.hw.warehouse.vo.UserVo;
import com.hw.warehouse.vo.OutProductVo;

import java.util.List;

/**
 * @author liurl
 */
public interface IDemoService {
    /**
     * 查询用户列表
     * @return
     */
    List<UserVo> getUserList();
    List<InProductVo> getInProductList();
    List<OutProductVo> getOutProductList();
    InProductVo addInProduct(InProductEntity inProductEntity);
    OutProductVo addOutProduct(OutProductEntity outProductEntity);
}
