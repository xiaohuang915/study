package com.huang.study.test.dao;

import com.huang.study.test.entity.PurseWithdrawalRequestLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @Description: 钱包提现表(PurseWithdrawalRequestLog)表数据库访问层
 * @Author : pc.huang
 * @Date : 2019-03-10 20:33:48
 */
@Mapper
public interface PurseWithdrawalRequestLogDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pkCpcnPurseWithdrawalRequestLog 主键
     * @return 实例对象
     */
    PurseWithdrawalRequestLog queryById(String pkCpcnPurseWithdrawalRequestLog);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<PurseWithdrawalRequestLog> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param purseWithdrawalRequestLog 实例对象
     * @return 对象列表
     */
    List<PurseWithdrawalRequestLog> queryAll(PurseWithdrawalRequestLog purseWithdrawalRequestLog);

    /**
     * 新增数据
     *
     * @param purseWithdrawalRequestLog 实例对象
     * @return 影响行数
     */
    int insert(PurseWithdrawalRequestLog purseWithdrawalRequestLog);

    /**
     * 修改数据
     *
     * @param purseWithdrawalRequestLog 实例对象
     * @return 影响行数
     */
    int update(PurseWithdrawalRequestLog purseWithdrawalRequestLog);

    /**
     * 通过主键删除数据
     *
     * @param pkCpcnPurseWithdrawalRequestLog 主键
     * @return 影响行数
     */
    int deleteById(String pkCpcnPurseWithdrawalRequestLog);

}