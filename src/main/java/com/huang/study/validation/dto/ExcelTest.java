package com.huang.study.validation.dto;

import com.huang.study.validation.util.IdCard;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2019-04-30 15:50
 */
@Getter
@Setter
@Excel("测试")
@IdCard
public class ExcelTest {

    @ExcelField(value = "编号")
    private String id;

    @ExcelField(value = "姓名")
    private String name;

    @ExcelField(value = "创建时间")
    private Date createTime;
}
