package com.huang.study.thread.service;

import com.huang.study.thread.model.Entrepot;
import com.huang.study.thread.model.Order;
import com.huang.study.thread.model.OrderSearchModel;

import java.util.List;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/19 0019 20:23
 * @Description:
 */
public interface IOrderService {
    void create(Order order);
    void insertOrder(Order order);
    void testTra(Order order);
    void insertEntrepot(Entrepot order);

    void update(Order order);

    List<Order> select (OrderSearchModel orderSearchModel);
}
