package com.xgk;

import com.xgk.config.MyConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

/**
 * @author xgk
 * @date 2022/1/31
 */
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.NONE)
@Import({MyConfig.class})
public class ConfigurationTest {

    @Autowired
    private String msg;

    @Test
    public void test() {
        System.out.println(msg);
    }
}
