package com.huang.study.excel;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


/**
 * 电子福利券比对日志
 *
 * @author moon.l
 * @email liaoyue11@vip.qq.com
 * @date 2020-07-01 11:34:29
 * Copyright @ 2018 成都职工 labor Co. Ltd.
 * All right reserved.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountCompareUnionamountLogResponseVo  implements Serializable {
    private static final long serialVersionUID = -5809782578272943999L;

    @ApiModelProperty(value = "主键")
    private String pkCompareUaLog;

    @ApiModelProperty(value = "比对流水号")
    private String compareSn;

    @ApiModelProperty(value = "店铺id")
    private String shopId;

    @ApiModelProperty(value = "店铺名称")
    @ExcelProperty(index = 0, value = "店铺名称")
    private String shopName;

    @ApiModelProperty(value = "订单编号")
    @ExcelProperty(index = 1, value = "订单编号")
    private String orderSn;

    @ApiModelProperty(value = "支付编号")
    @ExcelProperty(index = 2, value = "支付编号")
    private String paySn;

    @ApiModelProperty(value = "支付宝流水号")
    @ExcelProperty(index = 3, value = "支付宝流水号")
    private String alipaySn;

    @ApiModelProperty(value = "订单金额")
    @ExcelProperty(index = 4, value = "订单金额")
    private String oderAmount;

    @ApiModelProperty(value = "电子钱包金额")
    @ExcelProperty(index = 5, value = "电子钱包金额")
    private String walletAmount;

    @ApiModelProperty(value = "工会券金额")
    @ExcelProperty(index = 6, value = "工会券金额")
    private String unionAmount;

    @ApiModelProperty(value = "个人支付金额")
    @ExcelProperty(index = 7, value = "个人支付金额")
    private String individualAmount;

    @ApiModelProperty(value = "支付时间")
    @ExcelProperty(index = 8, value = "支付时间")
    private String payTime;

    @ApiModelProperty(value = "交易状态")
    @ExcelProperty(index = 9, value = "交易状态")
    private String payState;

    @ApiModelProperty(value = "退款金额")
    @ExcelProperty(index = 10, value = "退款金额")
    private String refundAmount;

    @ApiModelProperty(value = "退款状态")
    @ExcelProperty(index = 11, value = "退款状态")
    private String refundState;

    @ApiModelProperty(value = "交易类型")
    @ExcelProperty(index = 12, value = "交易类型")
    private String payType;

    @ApiModelProperty(value = "支付宝交易号上传")
    @ExcelProperty(index = 13, value = "支付宝交易号上传")
    private String alipayTradeNoUp;

    @ApiModelProperty(value = "支付宝流水号上传")
    @ExcelProperty(index = 14, value = "支付宝流水号上传")
    private String alipaySnUp;

    @ApiModelProperty(value = "收入(+元)")
    @ExcelProperty(index = 15, value = "收入(+元)")
    private String incomeAmount;

    @ApiModelProperty(value = "支出(+元)")
    @ExcelProperty(index = 16, value = "支出(+元)")
    private String outcomeAmount;

    @ApiModelProperty(value = "支付渠道")
    @ExcelProperty(index = 17, value = "支付渠道")
    private String payChannel;

    @ApiModelProperty(value = "对方账户")
    @ExcelProperty(index = 18, value = "对方账户")
    private String reciprocalAccount;

    @ApiModelProperty(value = "对方名称")
    @ExcelProperty(index = 19, value = "对方名称")
    private String reciprocalName;

    @ApiModelProperty(value = "备注")
    @ExcelProperty(index = 20, value = "备注")
    private String remarkUp;

    @ApiModelProperty(value = "核对结果:0核对一致,1核对不一致")
    @ExcelProperty(index = 21, value = "核对结果:0核对一致,1核对不一致")
    private Integer compareResult;

    @ApiModelProperty(value = "数据状态：0 正常，1 删除")
    private Integer dataStatus;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "创建人id")
    private String createId;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "修改人id")
    private String updateId;

}