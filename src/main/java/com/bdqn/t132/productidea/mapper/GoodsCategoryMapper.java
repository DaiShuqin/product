package com.bdqn.t132.productidea.mapper;

import com.bdqn.t132.productidea.pojo.GoodsCategory;
import com.bdqn.t132.productidea.pojo.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GoodsCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsCategory record);
    List<GoodsCategory> selectGoodsCList(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);
}