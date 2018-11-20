package com.huang.study.thread.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/19 0019 20:17
 * @Description:
 */
@TableName("test_order")
public class Order implements Serializable {
    @TableId(type=IdType.INPUT)
    private String guid;
    private String name;
    private Date createtime;
    private int version;
    @TableField(exist = false)
    private int enId;
    private int status;

    @Override
    public String toString() {
        return "Order{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", createtime=" + createtime +
                ", version=" + version +
                ", enId=" + enId +
                ", status=" + status +
                '}';
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getEnId() {
        return enId;
    }

    public void setEnId(int enId) {
        this.enId = enId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
