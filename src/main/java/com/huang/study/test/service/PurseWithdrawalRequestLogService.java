package com.huang.study.test.service;

import com.huang.study.test.entity.PurseWithdrawalRequestLog;
import java.util.List;

/**
 * @Description: 钱包提现表(PurseWithdrawalRequestLog)表服务接口
 * @Author : pc.huang
 * @Date : 2019-03-10 20:33:48
 */
public interface PurseWithdrawalRequestLogService {

    /**
     * 通过ID查询单条数据
     *
     * @param pkCpcnPurseWithdrawalRequestLog 主键
     * @return 实例对象
     */
    PurseWithdrawalRequestLog queryById(String pkCpcnPurseWithdrawalRequestLog);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PurseWithdrawalRequestLog> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param purseWithdrawalRequestLog 实例对象
     * @return 实例对象
     */
    PurseWithdrawalRequestLog insert(PurseWithdrawalRequestLog purseWithdrawalRequestLog);

    /**
     * 修改数据
     *
     * @param purseWithdrawalRequestLog 实例对象
     * @return 实例对象
     */
    PurseWithdrawalRequestLog update(PurseWithdrawalRequestLog purseWithdrawalRequestLog);

    /**
     * 通过主键删除数据
     *
     * @param pkCpcnPurseWithdrawalRequestLog 主键
     * @return 是否成功
     */
    boolean deleteById(String pkCpcnPurseWithdrawalRequestLog);

}