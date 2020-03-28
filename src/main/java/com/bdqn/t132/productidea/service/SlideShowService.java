package com.bdqn.t132.productidea.service;

import com.bdqn.t132.productidea.pojo.SlideShow;

import java.util.List;

public interface SlideShowService {
    int deleteByPrimaryKey(Integer id);

    int insert(SlideShow record);

    int insertSelective(SlideShow record);

    SlideShow selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SlideShow record);

    int updateByPrimaryKey(SlideShow record);

    List<SlideShow> selectslidelist();
}
