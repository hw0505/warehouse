package com.hw.warehouse.service;

import com.hw.warehouse.vo.UserVo;
import org.springframework.stereotype.Service;

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
}
