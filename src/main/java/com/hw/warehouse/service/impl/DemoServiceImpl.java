package com.hw.warehouse.service.impl;

import com.hw.warehouse.dao.IUserDao;
import com.hw.warehouse.entity.UserEntity;
import com.hw.warehouse.service.IDemoService;
import com.hw.warehouse.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liurl
 */
@Service
public class DemoServiceImpl implements IDemoService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<UserVo> getUserList() {
        List<UserEntity> userEntityList = userDao.query();
        List<UserVo> userVoList = new ArrayList<>(2);
        for(UserEntity userEntity: userEntityList) {
            UserVo userVo = new UserVo();
            String name = userEntity.getName();
            userVo.setName(name);
            userVoList.add(userVo);
        }
        return userVoList;
    }
}
