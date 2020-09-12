package com.huang.study.method;

import com.huang.study.common.util.IdGenerator;
import com.huang.study.thread.mapper.OrderMapper;
import com.huang.study.thread.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020-09-12 10:03
 */
@Service
@AllArgsConstructor
public class OrderBiz extends AbstractBiz {

    private OrderMapper orderMapper;


    @Override
    void saveRequest(Object req, String uid) {
        Order order = (Order) req;
        order.setGuid(uid);
        order.setCreatetime(new Date());
        orderMapper.insert(order);
    }

    @Override
    void saveResponse(Object res, String uid) {
        Order order = (Order) res;
        order.setGuid(uid);
        orderMapper.updateById(order);
    }

}
