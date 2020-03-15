package com.bdqn.t132.productidea.service.impl;

import com.bdqn.t132.productidea.mapper.GoodsInfoMapper;
import com.bdqn.t132.productidea.pojo.GoodsInfo;
import com.bdqn.t132.productidea.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsInfoMapper goodsInfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(GoodsInfo record) {
        return 0;
    }

    @Override
    public int insertSelective(GoodsInfo record) {
        return 0;
    }

    @Override
    public GoodsInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(GoodsInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(GoodsInfo record) {
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map dolist(GoodsInfo record) {
        Map map=new HashMap();
        List<GoodsInfo> goodslist=goodsInfoMapper.selectGoodsList(record);
//        System.out.println(goodslist.get(0).getGoodsName());
        map.put("retData",goodslist);
        map.put("count",goodslist.size());
        return map;
    }
}
