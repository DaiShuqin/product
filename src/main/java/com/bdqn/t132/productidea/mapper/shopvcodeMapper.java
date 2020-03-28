package com.bdqn.t132.productidea.mapper;

import com.bdqn.t132.productidea.pojo.shopvcode;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface shopvcodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(shopvcode record);

    int insertSelective(shopvcode record);

    shopvcode selectByPrimaryKey(Integer id);
    shopvcode selectvcodeTime(shopvcode shopvcode);
    int updateByPrimaryKeySelective(shopvcode record);
    int updateByPrimaryKeySelectiveVcode(shopvcode record);
    shopvcode selectvcode(shopvcode shopvcode);
    int updateByPrimaryKey(shopvcode record);
}