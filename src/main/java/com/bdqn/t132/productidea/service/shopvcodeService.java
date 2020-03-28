package com.bdqn.t132.productidea.service;

import com.bdqn.t132.productidea.pojo.shopvcode;

public interface shopvcodeService {
    int deleteByPrimaryKey(Integer id);

    int insert(shopvcode record);



    int insertSelective(shopvcode record);

    int updateByPrimaryKeySelectiveVcode(shopvcode record);

    shopvcode selectByPrimaryKey(Integer id);

    shopvcode selectvcodeTime(shopvcode shopvcode);

    int updateByPrimaryKeySelective(shopvcode record);

    /**
     * 注册判断验证码是否正确
     * @param shopvcode
     * @return
     */
    shopvcode selectvcode(shopvcode shopvcode);
    int updateByPrimaryKey(shopvcode record);
}
