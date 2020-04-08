package com.hw.warehouse.service.impl;

import com.hw.warehouse.dao.IUserDao;
import com.hw.warehouse.dao.InProductDao;
import com.hw.warehouse.dao.OutProductDao;
import com.hw.warehouse.entity.InProductEntity;
import com.hw.warehouse.entity.OutProductEntity;
import com.hw.warehouse.entity.UserEntity;
import com.hw.warehouse.service.IDemoService;
import com.hw.warehouse.vo.InProductVo;
import com.hw.warehouse.vo.OutProductVo;
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

    @Autowired
    private InProductDao inProductDao;

    @Autowired
    private OutProductDao outProductDao;

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


    @Override
    public List<InProductVo> getInProductList() {
        List<InProductEntity> inProductEntityList = inProductDao.query();
        List<InProductVo> inProductVoList = new ArrayList<>(2);
        for(InProductEntity inProductEntity: inProductEntityList) {
            InProductVo inProductVo = new InProductVo();
            String inId= inProductEntity.getInId();
            String inName = inProductEntity.getInName();
            String inNumber = inProductEntity.getInNumber();
            String inDate = inProductEntity.getInDate();
            inProductVo.setInId(inId);
            inProductVo.setInName(inName);
            inProductVo.setInNumber(inNumber);
            inProductVo.setInDate(inDate);
            inProductVoList.add(inProductVo);
        }
        return inProductVoList;
    }

    @Override
    public List<OutProductVo> getOutProductList() {
        List<OutProductEntity> outProductEntityList = outProductDao.query();
        List<OutProductVo> outProductVoList = new ArrayList<>(2);
        for(OutProductEntity outProductEntity: outProductEntityList) {
            OutProductVo outProductVo = new OutProductVo();
            String outId = outProductEntity.getOutId();
            String outName = outProductEntity.getOutName();
            String outNumber = outProductEntity.getOutNumber();
            String outDate = outProductEntity.getOutDate();
            outProductVo.setOutId(outId);
            outProductVo.setOutName(outName);
            outProductVo.setOutNumber(outNumber);
            outProductVo.setOutDate(outDate);
            outProductVoList.add(outProductVo);
        }
        return outProductVoList;
    }

    @Override
    public InProductVo addInProduct(InProductEntity inProductEntity){
        inProductDao.saveInProduct(inProductEntity);
        return null;
    }

    @Override
    public OutProductVo addOutProduct(OutProductEntity outProductEntity){
        outProductDao.saveOutProduct(outProductEntity);
        return null;
    }

    public InProductDao getInProductDao() {
        return inProductDao;
    }

    public void setInProductDao(InProductDao inProductDao) {
        this.inProductDao = inProductDao;
    }

    public OutProductDao getOutProductDao() {
        return outProductDao;
    }

    public void setOutProductDao(OutProductDao outProductDao) {
        this.outProductDao = outProductDao;
    }
}
