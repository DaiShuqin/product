package com.bdqn.t132.productidea.service.impl;

import com.bdqn.t132.productidea.mapper.SlideShowMapper;
import com.bdqn.t132.productidea.pojo.SlideShow;
import com.bdqn.t132.productidea.service.SlideShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SlideShowServiceImpl implements SlideShowService {
    @Autowired
    SlideShowMapper slideShowMapper;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(SlideShow record) {
        return 0;
    }

    @Override
    public int insertSelective(SlideShow record) {
        return 0;
    }

    @Override
    public SlideShow selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SlideShow record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SlideShow record) {
        return 0;
    }

    @Override
    public List<SlideShow> selectslidelist() {
        return slideShowMapper.selectslidelist();
    }
}
