package com.bdqn.t132.productidea.mapper;

import com.bdqn.t132.productidea.pojo.GoodsInfo;
import com.bdqn.t132.productidea.pojo.NoticeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface NoticeInfoMapper {
    int deleteByPrimaryKey(Integer noticeId);

    int insert(NoticeInfo record);

    int insertSelective(NoticeInfo record);

    NoticeInfo selectByPrimaryKey(Integer noticeId);

    int updateByPrimaryKeySelective(NoticeInfo record);
    List<NoticeInfo> selectNoticeList(NoticeInfo record);

    int updateByPrimaryKey(NoticeInfo record);
}