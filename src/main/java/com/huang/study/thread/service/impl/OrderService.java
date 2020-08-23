package com.huang.study.thread.service.impl;

import com.huang.study.common.util.IdGenerator;
import com.huang.study.thread.mapper.EntrepotMapper;
import com.huang.study.thread.mapper.OrderMapper;
import com.huang.study.thread.model.Entrepot;
import com.huang.study.thread.model.Order;
import com.huang.study.thread.model.OrderSearchModel;
import com.huang.study.thread.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/19 0019 20:23
 * @Description:
 */
@Service
@SuppressWarnings("all")
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

    @Override
    public List<Order> select(OrderSearchModel orderSearchModel) {
        return orderMapper.selectOrder(orderSearchModel);
    }


    @Override
    public void insertOrder(Order order) {
        order.setGuid(IdGenerator.getId());
        order.setCreatetime(new Date());
        orderMapper.insert(order);
    }

    @Override
    @Transactional
    public void testTra(Order order) {
        order.setGuid(IdGenerator.getId());
        order.setCreatetime(new Date());
        orderMapper.insert(order);

        Entrepot entrepot = new Entrepot();
        entrepot.setGuid(IdGenerator.getId());
        entrepot.setCreatetime(new Date());
        entrepot.setVersion(order.getVersion());
        insertEntrepot(entrepot);
    }

    @Override
    @Transactional
    public void insertEntrepot(Entrepot entrepot) {
        entrepot.setGuid(IdGenerator.getId());
        entrepot.setCreatetime(new Date());
        entrepotMapper.insert(entrepot);
        throw new RuntimeException("test error");

    }

    public CompletableFuture<Void> test(){

        return CompletableFuture.completedFuture(null);
    }




}
