package com.bdqn.t132.productidea.service;

import com.bdqn.t132.productidea.pojo.NoticeInfo;
import com.bdqn.t132.productidea.pojo.PicInfo;

import java.util.List;
import java.util.Map;

public interface PicService {
    int deleteByPrimaryKey(Integer id);

    int insert(PicInfo record);

    int insertSelective(PicInfo record);

    PicInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PicInfo record);
    List<PicInfo> selectPicList(Integer goodsId);

    int updateByPrimaryKey(PicInfo record);
}
