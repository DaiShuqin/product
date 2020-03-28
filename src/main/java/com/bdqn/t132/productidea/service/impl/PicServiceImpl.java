package com.bdqn.t132.productidea.service.impl;

import com.bdqn.t132.productidea.mapper.PicInfoMapper;
import com.bdqn.t132.productidea.pojo.NoticeInfo;
import com.bdqn.t132.productidea.pojo.PicInfo;
import com.bdqn.t132.productidea.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class PicServiceImpl implements PicService {
    @Autowired
    PicInfoMapper picInfoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(PicInfo record) {
        return 0;
    }

    @Override
    public int insertSelective(PicInfo record) {
        return 0;
    }

    @Override
    public PicInfo selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(PicInfo record) {
        return 0;
    }

    @Override
    public List<PicInfo> selectPicList(Integer goodsId) {
        return picInfoMapper.selectPicList(goodsId);
    }

    @Override
    public int updateByPrimaryKey(PicInfo record) {
        return 0;
    }
}
