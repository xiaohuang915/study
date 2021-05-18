package com.huang.study.mysql;

import com.huang.study.test.entity.UuidUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

/**
 * @Description:
 * @Author : pc.huang
 * @Date : 2020-08-23 21:00
 */
public class BatchInsertMuchTest {
    public static void main(String[] args) {
        try {
            // MYSQL驱动
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // 链接本地MYSQL
            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/batch?rewriteBatchedStatements=true&useUnicode=true&characterEncoding=UTF-8",
                    "root", "root");
            int batchSize = 5;
            int count = 10;
            //设置自动提交为false
            conn.setAutoCommit(false);
            Statement ps = conn.createStatement();
            Long t1 = System.currentTimeMillis();
            System.out.println("====================");
            for (long i = 0; i < count; i++) {
                //设置参数
                //将该条记录添加到批处理中

                String id = UuidUtil.getUpperId();
                String sq1 = "insert into student (id,create_time) values " +
                        "(" +
                        "'" + id + "'" +","+
                        "'" + DateUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm:ss") + "'" +
                        ")";
                String sq2 = "insert into teacher (id,create_time) values " +
                        "(" +
                        "'" + id + "'" +","+
                        "'" + DateUtil.dateToStr(new Date(),"yyyy-MM-dd HH:mm:ss") + "'" +
                        ")";
                ps.addBatch(sq1);
                ps.addBatch(sq2);
                if (i % batchSize == 0) {
                    ps.executeBatch();//执行批处理
                    conn.commit();//提交
                    System.out.println(i + ":添加" + batchSize + "条");
                }
            }
            ps.executeBatch();
            conn.commit();
            ps.close();
            conn.close();
            Long t2 = System.currentTimeMillis();
            System.out.println(count + "条    每次" + batchSize + "条   " + (t2 - t1) / 1000 + "秒");
        } catch (Exception e) {
            // TODO: handle exception  403秒  182秒
            e.printStackTrace();
        }
    }

}
