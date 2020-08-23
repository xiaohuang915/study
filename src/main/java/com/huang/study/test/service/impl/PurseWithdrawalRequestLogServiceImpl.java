package com.huang.study.test.service.impl;

import com.huang.study.test.entity.PurseWithdrawalRequestLog;
import com.huang.study.test.dao.PurseWithdrawalRequestLogDao;
import com.huang.study.test.service.PurseWithdrawalRequestLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 钱包提现表(PurseWithdrawalRequestLog)表服务实现类
 * @Author : pc.huang
 * @Date : 2019-03-10 20:33:48
 */
@Service("purseWithdrawalRequestLogService")
public class PurseWithdrawalRequestLogServiceImpl implements PurseWithdrawalRequestLogService {
    @Resource
    private PurseWithdrawalRequestLogDao purseWithdrawalRequestLogDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pkCpcnPurseWithdrawalRequestLog 主键
     * @return 实例对象
     */
    @Override
    public PurseWithdrawalRequestLog queryById(String pkCpcnPurseWithdrawalRequestLog) {
        return this.purseWithdrawalRequestLogDao.queryById(pkCpcnPurseWithdrawalRequestLog);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<PurseWithdrawalRequestLog> queryAllByLimit(int offset, int limit) {
        return this.purseWithdrawalRequestLogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param purseWithdrawalRequestLog 实例对象
     * @return 实例对象
     */
    @Override
    public PurseWithdrawalRequestLog insert(PurseWithdrawalRequestLog purseWithdrawalRequestLog) {
        this.purseWithdrawalRequestLogDao.insert(purseWithdrawalRequestLog);
        return purseWithdrawalRequestLog;
    }

    /**
     * 修改数据
     *
     * @param purseWithdrawalRequestLog 实例对象
     * @return 实例对象
     */
    @Override
    public PurseWithdrawalRequestLog update(PurseWithdrawalRequestLog purseWithdrawalRequestLog) {
        this.purseWithdrawalRequestLogDao.update(purseWithdrawalRequestLog);
        return this.queryById(purseWithdrawalRequestLog.getPkCpcnPurseWithdrawalRequestLog());
    }

    /**
     * 通过主键删除数据
     *
     * @param pkCpcnPurseWithdrawalRequestLog 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String pkCpcnPurseWithdrawalRequestLog) {
        return this.purseWithdrawalRequestLogDao.deleteById(pkCpcnPurseWithdrawalRequestLog) > 0;
    }
}