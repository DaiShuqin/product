package com.bdqn.t132.productidea.controller;

import com.bdqn.t132.productidea.pojo.GoodsCategory;
import com.bdqn.t132.productidea.pojo.GoodsInfo;
import com.bdqn.t132.productidea.service.GoodsCService;
import com.bdqn.t132.productidea.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/cate")
public class GoodsCateController {
    @Autowired
    GoodsCService goodsCService;
    @RequestMapping("/list")
    public Object nn(GoodsCategory goodsCategory){
        Map map=goodsCService.doclist(goodsCategory);
        return map;
    }
}
