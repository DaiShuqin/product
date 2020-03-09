package com.bdqn.t132.productidea.mapper;

import com.bdqn.t132.productidea.pojo.WmOpr;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WmOprMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WmOpr record);

    int insertSelective(WmOpr record);

    WmOpr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WmOpr record);

    int updateByPrimaryKey(WmOpr record);
}