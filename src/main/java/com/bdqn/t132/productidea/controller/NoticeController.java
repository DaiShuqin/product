package com.bdqn.t132.productidea.controller;

import com.bdqn.t132.productidea.pojo.GoodsCategory;
import com.bdqn.t132.productidea.pojo.NoticeInfo;
import com.bdqn.t132.productidea.service.GoodsCService;
import com.bdqn.t132.productidea.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    NoticeService noticeService;
    @RequestMapping("/list")
    public Object nn(NoticeInfo noticeInfo){
        Map map=noticeService.dolist(noticeInfo);
        return map;
    }
}
