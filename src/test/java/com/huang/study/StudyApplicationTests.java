package com.huang.study;

import com.huang.study.zset.ZsetTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = StudyApplication.class)
public class StudyApplicationTests {

    @Autowired
    private ZsetTest zsetTest;

    @Test
    public void contextLoads() {
        zsetTest.score();
    }


}
