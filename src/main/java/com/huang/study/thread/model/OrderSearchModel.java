package com.huang.study.thread.model;

import java.util.Date;

/**
 * @Auther: pc.huang
 * @Date: 2018/12/17 0017 20:10
 * @Description:
 */
public class OrderSearchModel {
    private Date startTime;
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "OrderSearchModel{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
