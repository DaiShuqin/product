package com.bdqn.t132.productidea.pojo;

import com.bdqn.t132.productidea.util.BaseEntity;

import java.util.List;

public class GoodsCategory extends BaseEntity {
    private Integer id;

    private String name;

    private Integer parentId;

    private Integer type;

    private String iconclass;

    private List<GoodsCategory> list;

    public List<GoodsCategory> getList() {
        return list;
    }

    public void setList(List<GoodsCategory> list) {
        this.list = list;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIconclass() {
        return iconclass;
    }

    public void setIconclass(String iconclass) {
        this.iconclass = iconclass == null ? null : iconclass.trim();
    }
}