package com.bdqn.t132.productidea.mapper;

import com.bdqn.t132.productidea.pojo.NoticeInfo;
import com.bdqn.t132.productidea.pojo.PicInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PicInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PicInfo record);

    int insertSelective(PicInfo record);

    PicInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PicInfo record);
    List<PicInfo> selectPicList(Integer goodsId);

    int updateByPrimaryKey(PicInfo record);
}