package com.huang.study.thread.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/19 0019 20:19
 * @Description:
 */
public class Entrepot {
    @TableId(type=IdType.INPUT)
    private String guid;
    private Integer number;
    private Date createtime;
    private Integer type;
    private Integer version;

    @Override
    public String toString() {
        return "Entrepot{" +
                "guid='" + guid + '\'' +
                ", number=" + number +
                ", createtime=" + createtime +
                ", type=" + type +
                '}';
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
