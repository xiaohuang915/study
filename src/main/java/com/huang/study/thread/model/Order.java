package com.huang.study.thread.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/19 0019 20:17
 * @Description:
 */
@TableName("test_order")
public class Order {
    @TableId(type=IdType.INPUT)
    private String guid;
    private String name;
    private Date createtime;

    @Override
    public String toString() {
        return "Order{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", createtime=" + createtime +
                '}';
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
