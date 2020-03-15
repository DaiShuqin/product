package com.bdqn.t132.productidea.mapper;

import com.bdqn.t132.productidea.pojo.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface GoodsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsInfo record);
    List<GoodsInfo> selectGoodsList(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);
}