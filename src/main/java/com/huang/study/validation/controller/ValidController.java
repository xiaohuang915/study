package com.huang.study.validation.controller;

import com.huang.study.validation.dto.ExcelTest;
import com.huang.study.validation.dto.Order;
import com.huang.study.validation.util.IPAddressUtil;
import com.wuwenze.poi.ExcelKit;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

/**
 * @Auther: pc.huang
 * @Date: 2018/9/27 09:22
 * @Description:
 */
@RestController
@RequestMapping("/test/")
public class ValidController {
    @PostMapping(value = "valid")
    public Order valid(@RequestBody @Valid Order order) {
        return order;
    }

    @PostMapping(value = "test")
    public Order test(@RequestBody @Valid Order order) {
        return order;
    }

    @PostMapping(value = "test1")
    public Order test1(@RequestBody @Valid Order order) {
        return order;
    }

    @GetMapping("excel")
    public void excel(HttpServletResponse response) {
        List<ExcelTest> list = new ArrayList<>();
        ExcelTest excelTest = new ExcelTest();
        excelTest.setId("1");
        excelTest.setName("小张");
        excelTest.setCreateTime(new Date());
        list.add(excelTest);

        ExcelTest excelTest1 = new ExcelTest();
        excelTest1.setId("2");
        excelTest1.setName("小李");
        excelTest1.setCreateTime(new Date());
        list.add(excelTest1);

        ExcelKit.$Export(ExcelTest.class, response).downXlsx(list, false);
    }

    @GetMapping("userAgent")
    public Map<String, Object> userAgent(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        //获取浏览器信息
        String ua = request.getHeader("User-Agent");
        //转成UserAgent对象
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);
        //获取浏览器信息
        Browser browser = userAgent.getBrowser();
        //获取系统信息
        OperatingSystem os = userAgent.getOperatingSystem();
        //系统名称
        String system = os.getName();
        //浏览器名称
        String browserName = browser.getName();

        map.put("browserName", browserName);
        map.put("systemName", system);
        map.put("ipAddress", IPAddressUtil.getIpAddress(request));
        return map;
    }
}
