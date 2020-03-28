package com.bdqn.t132.productidea.service.impl;

import com.bdqn.t132.productidea.mapper.NoticeInfoMapper;
import com.bdqn.t132.productidea.pojo.GoodsCategory;
import com.bdqn.t132.productidea.pojo.NoticeInfo;
import com.bdqn.t132.productidea.service.NoticeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeInfoMapper noticeInfoMapper;
    @Override
    public int deleteByPrimaryKey(Integer noticeId) {
        return 0;
    }

    @Override
    public int insert(NoticeInfo record) {
        return 0;
    }

    @Override
    public int insertSelective(NoticeInfo record) {
        return 0;
    }

    @Override
    public int count() {
        return noticeInfoMapper.count();
    }

    @Override
    public Map selectByPrimaryKey(Integer noticeId) {
        NoticeInfo noticeInfo=noticeInfoMapper.selectByPrimaryKey(noticeId);
        Map map=new HashMap();
        map.put("retData",noticeInfo);
        return map;
    }

    @Override
    public int updateByPrimaryKeySelective(NoticeInfo record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(NoticeInfo record) {
        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map dolist(NoticeInfo record) {
        List<NoticeInfo> list=noticeInfoMapper.selectNoticeList(record);
        Map map=new HashMap();
        map.put("retData",list);
        return map;
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Map list(NoticeInfo record) {
        PageHelper.startPage(record.getPageNum(),record.getPageSize());
        List<NoticeInfo> list=noticeInfoMapper.selectNoticeList(record);
        Map map=new HashMap();
        map.put("retData",list);
        System.out.println("================"+this.count());
        map.put("retTotal",this.count());
        return map;
    }

}
