package com.huang.study.test.controller;

import com.huang.study.test.entity.PurseWithdrawalRequestLog;
import com.huang.study.test.service.PurseWithdrawalRequestLogService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: 钱包提现表(PurseWithdrawalRequestLog)表控制层
 * @Author : pc.huang
 * @Date : 2019-03-10 20:33:48
 */
@RestController
@RequestMapping("purseWithdrawalRequestLog")
public class PurseWithdrawalRequestLogController {
    /**
     * 服务对象
     */
    @Resource
    private PurseWithdrawalRequestLogService purseWithdrawalRequestLogService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public PurseWithdrawalRequestLog selectOne(String id) {
        return this.purseWithdrawalRequestLogService.queryById(id);
    }

}