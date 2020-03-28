package com.bdqn.t132.productidea.service.impl;

import com.bdqn.t132.productidea.mapper.ShopCartMapper;
import com.bdqn.t132.productidea.pojo.ShopCart;
import com.bdqn.t132.productidea.service.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Autowired
    ShopCartMapper shopCartMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return shopCartMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ShopCart record) {
        return shopCartMapper.insert(record);
    }

    @Override
    public int insertSelective(ShopCart record) {
        return shopCartMapper.insertSelective(record);
    }

    @Override
    public ShopCart selectByPrimaryKey(Integer id) {
        return shopCartMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(ShopCart record) {
        return shopCartMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ShopCart record) {
        return shopCartMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<ShopCart> selectCartList(Integer id) {
        return shopCartMapper.selectCartList(id);
    }
}
