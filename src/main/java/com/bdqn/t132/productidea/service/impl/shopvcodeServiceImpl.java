package com.bdqn.t132.productidea.service.impl;

import com.bdqn.t132.productidea.mapper.shopvcodeMapper;
import com.bdqn.t132.productidea.pojo.shopvcode;
import com.bdqn.t132.productidea.service.shopvcodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class shopvcodeServiceImpl implements shopvcodeService {
    @Resource
    private shopvcodeMapper shopvcodeMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return shopvcodeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(shopvcode record) {
        return shopvcodeMapper.insert(record);
    }

    @Override
    public int insertSelective(shopvcode record) {
        return shopvcodeMapper.insertSelective(record);
    }

    @Override
    public int updateByPrimaryKeySelectiveVcode(shopvcode record) {
        return shopvcodeMapper.updateByPrimaryKeySelectiveVcode(record);
    }

    @Override
    public shopvcode selectByPrimaryKey(Integer id) {
        return shopvcodeMapper.selectByPrimaryKey(id);
    }

    @Override
    public shopvcode selectvcodeTime(shopvcode shopvcode) {
        return shopvcodeMapper.selectvcodeTime(shopvcode);
    }

    @Override
    public int updateByPrimaryKeySelective(shopvcode record) {
        return shopvcodeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public shopvcode selectvcode(shopvcode shopvcode) {
        return shopvcodeMapper.selectvcode(shopvcode);
    }

    @Override
    public int updateByPrimaryKey(shopvcode record) {
        return shopvcodeMapper.updateByPrimaryKey(record);
    }
}
