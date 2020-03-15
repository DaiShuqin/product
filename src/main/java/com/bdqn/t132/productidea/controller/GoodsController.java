package com.bdqn.t132.productidea.controller;

import com.bdqn.t132.productidea.pojo.GoodsInfo;
import com.bdqn.t132.productidea.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @RequestMapping("/list")
    public Object nn(GoodsInfo goodsInfo){
        Map map=goodsService.dolist(goodsInfo);
        return map;
    }
}
