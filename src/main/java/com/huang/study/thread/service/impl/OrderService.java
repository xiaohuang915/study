package com.huang.study.thread.service.impl;

import com.huang.study.common.util.IdGenerator;
import com.huang.study.thread.mapper.EntrepotMapper;
import com.huang.study.thread.mapper.OrderMapper;
import com.huang.study.thread.model.Entrepot;
import com.huang.study.thread.model.Order;
import com.huang.study.thread.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/19 0019 20:23
 * @Description:
 */
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private EntrepotMapper entrepotMapper;

    @Override
    public void create(Order order) {
        order.setGuid(IdGenerator.getId());
        order.setCreatetime(new Date());
        orderMapper.insert(order);
        Entrepot entrepot = entrepotMapper.selectById(123456);
        if (entrepot.getNumber() > 0) {
            entrepot.setNumber(entrepot.getNumber()-1);
            entrepotMapper.updateById(entrepot);
        }
    }
}
