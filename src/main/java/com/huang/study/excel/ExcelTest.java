package com.huang.study.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.WriteContext;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.huang.study.test.entity.UuidUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020/7/8 11:26
 */
public class ExcelTest {

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {

        List<AccountCompareUnionamountLogResponseVo> list = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            AccountCompareUnionamountLogResponseVo req = new AccountCompareUnionamountLogResponseVo();
            req.setShopName("123");
            req.setOrderSn(String.valueOf(i));
            list.add(req);
        }

        ExcelWriter write = EasyExcel.write(UuidUtil.getTxsn() +".xlsx",AccountCompareUnionamountLogResponseVo.class).build();
        WriteSheet build = EasyExcel.writerSheet("模板").build();

        write.write(list,build);
        write.finish();
    }


}
