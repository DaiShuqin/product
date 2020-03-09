package com.bdqn.t132.productidea.service.impl;

import com.bdqn.t132.productidea.mapper.WmOprMapper;
import com.bdqn.t132.productidea.pojo.WmOpr;
import com.bdqn.t132.productidea.service.WmOprService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class WmOprServiceImpl implements WmOprService {
    @Resource
    private WmOprMapper wmOprMapper;

    @Override
    public WmOpr selectByPrimaryKey(Integer id) {
        return wmOprMapper.selectByPrimaryKey(id);
    }
}
