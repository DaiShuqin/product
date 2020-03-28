package com.bdqn.t132.productidea.service;

import com.bdqn.t132.productidea.pojo.ShopCart;

import java.util.List;

public interface ShopCartService {
    int deleteByPrimaryKey(Integer id);

    int insert(ShopCart record);

    int insertSelective(ShopCart record);

    ShopCart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShopCart record);

    int updateByPrimaryKey(ShopCart record);

    List<ShopCart> selectCartList(Integer id);

}
