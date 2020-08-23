package com.huang.study.test.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 钱包提现表(PurseWithdrawalRequestLog)实体类
 * @Author : pc.huang
 * @Date : 2019-03-10 20:35:02
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurseWithdrawalRequestLog implements Serializable {
    private static final long serialVersionUID = 952370521454815851L;
    
    @ApiModelProperty(value = "主键")
    private String pkCpcnPurseWithdrawalRequestLog;
    
    @ApiModelProperty(value = "交易日期")
    private String tradeDate;
    
    @ApiModelProperty(value = "交易流水号")
    private String txSn;
    
    @ApiModelProperty(value = "资金账户")
    private String accountNo;
    
    @ApiModelProperty(value = "资金账户名")
    private String accountName;
    
    @ApiModelProperty(value = "银行卡号")
    private String bankCardNo;
    
    @ApiModelProperty(value = "开户名称")
    private String bankAccountName;
    
    @ApiModelProperty(value = "提现金额")
    private Long amount;
    
    @ApiModelProperty(value = "手续费")
    private Long poundage;
    
    @ApiModelProperty(value = "业务标示 A00 正常出金,B01 解冻资金后，再出金")
    private String trsFlag;
    
    @ApiModelProperty(value = "结算方式标示 AA=正常结算(默认) T0=T0 代付出金,T1=T1 代付出金")
    private String balFlag;
    
    @ApiModelProperty(value = "附言")
    private String remark;
    
    @ApiModelProperty(value = "响应码")
    private String code;
    
    @ApiModelProperty(value = "响应消息")
    private String msg;
    
    @ApiModelProperty(value = "中金交易流水号")
    private String cpcnSn;
    
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

}