package com.bdqn.t132.productidea.service;

import com.bdqn.t132.productidea.pojo.GoodsInfo;
import com.bdqn.t132.productidea.pojo.NoticeInfo;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(NoticeInfo record);

    int insertSelective(NoticeInfo record);

    NoticeInfo selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(NoticeInfo record);
    int updateByPrimaryKey(NoticeInfo record);
    Map dolist(NoticeInfo record);

}
