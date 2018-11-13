package com.huang.study.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Auther: pc.huang
 * @Date: 2018/11/13 11:06
 * @Description:
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return null;
    }
}
