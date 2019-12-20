package it.cast;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Slf4jTest {
    @Test
    public void contextLoads(){
        Logger logger = LoggerFactory.getLogger(getClass());
        logger.trace("这是trace");
        logger.debug("这是debug 日志");
        logger.info("这是info 日志");
        logger.warn("这是warn 日志");
        logger.error("这是 err日志");
    }
}
