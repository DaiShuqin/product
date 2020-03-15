package com.bdqn.t132.productidea.service.impl;

import com.bdqn.t132.productidea.mapper.GoodsCategoryMapper;
import com.bdqn.t132.productidea.mapper.GoodsInfoMapper;
import com.bdqn.t132.productidea.pojo.GoodsCategory;
import com.bdqn.t132.productidea.pojo.GoodsInfo;
import com.bdqn.t132.productidea.service.GoodsCService;
import com.bdqn.t132.productidea.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsCServiceImpl implements GoodsCService {
    @Autowired
    private GoodsCategoryMapper goodsCategoryMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(GoodsCategory record) {
        return 0;
    }

    @Override
    public int insertSelective(GoodsCategory record) {
        return 0;
    }

    @Override
    public GoodsCategory selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsCategory record) {
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map doclist(GoodsCategory record) {
        List<GoodsCategory> list=goodsCategoryMapper.selectGoodsCList(record);
        Map map=new HashMap();
        map.put("retData",list);
        return map;
    }

    @Override
    public int updateByPrimaryKey(GoodsCategory record) {
        return 0;
    }
}
