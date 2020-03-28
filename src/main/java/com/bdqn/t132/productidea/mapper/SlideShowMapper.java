package com.bdqn.t132.productidea.mapper;

import com.bdqn.t132.productidea.pojo.SlideShow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SlideShowMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SlideShow record);

    int insertSelective(SlideShow record);

    SlideShow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SlideShow record);

    int updateByPrimaryKey(SlideShow record);

    List<SlideShow> selectslidelist();
}