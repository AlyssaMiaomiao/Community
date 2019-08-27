package com.nowcoder.community;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
//这个注解表示接下来运行的这个类的代码都是以这个类作为配置类，同时这个类也被@SpringBootApplication标识
@ContextConfiguration(classes=CommunityApplication.class)
public class LoggerTests {
    private static final Logger logger= LoggerFactory.getLogger(LoggerTests.class);
    @Test
    public void testLogger(){
        System.out.println(logger.getName());
        logger.debug("debug log");
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
    }
}

