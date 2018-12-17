package com.huang.study.thread.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.study.thread.model.Order;
import com.huang.study.thread.model.OrderSearchModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/19 0019 20:22
 * @Description:
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    void updateOrder(Order order);

    List<Order> selectOrder(OrderSearchModel orderSearchModel);
}
