package com.huang.study.thread.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.study.thread.model.Entrepot;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/19 0019 20:22
 * @Description:
 */
@Mapper
public interface EntrepotMapper extends BaseMapper<Entrepot> {
    int updateEntrepot(Entrepot entrepot);
}
