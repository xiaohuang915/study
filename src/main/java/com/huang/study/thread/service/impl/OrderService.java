package com.huang.study.thread.service.impl;

import com.huang.study.common.util.IdGenerator;
import com.huang.study.thread.mapper.EntrepotMapper;
import com.huang.study.thread.mapper.OrderMapper;
import com.huang.study.thread.model.Entrepot;
import com.huang.study.thread.model.Order;
import com.huang.study.thread.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional(rollbackFor = Exception.class)
    public void create(Order order) {
        order.setGuid(IdGenerator.getId());
        order.setCreatetime(new Date());
        Entrepot entrepot = entrepotMapper.selectById(order.getEnId());
        int i = entrepotMapper.updateEntrepot(entrepot);
        if (i == 0) {
            throw new RuntimeException("无库存");
        }
        orderMapper.insert(order);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Order order) {
        Order select = orderMapper.selectById(order.getGuid());
        select.setStatus(1);
        orderMapper.updateOrder(select);
        Entrepot entrepot = entrepotMapper.selectById(order.getEnId());
        int i = entrepotMapper.updateEntrepot(entrepot);
        if (i == 0) {
            throw new RuntimeException("无库存");
        }
    }
}
