package com.bdqn.t132.productidea.service;

import com.bdqn.t132.productidea.pojo.GoodsCategory;
import com.bdqn.t132.productidea.pojo.GoodsInfo;

import java.util.List;
import java.util.Map;

public interface GoodsCService {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsCategory record);
    Map doclist(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);

}
