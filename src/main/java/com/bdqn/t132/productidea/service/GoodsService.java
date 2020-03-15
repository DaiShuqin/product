package com.bdqn.t132.productidea.service;

import com.bdqn.t132.productidea.pojo.GoodsInfo;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);

    Map dolist(GoodsInfo record);

}
