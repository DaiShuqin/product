package com.bdqn.t132.productidea.controller;

import com.bdqn.t132.productidea.service.WmOprService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试
 */
@CrossOrigin
@RestController
@RequestMapping("/w")
public class Wm {
    @Autowired
    private WmOprService wmOprService;
    @RequestMapping("/wm")
    public Object nn(){
        Map map=new HashMap();
        map.put("msg",wmOprService.selectByPrimaryKey(2));
        return map;
    }
}
