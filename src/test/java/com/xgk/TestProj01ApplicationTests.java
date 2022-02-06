package com.xgk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

// properties 属性可以为当前测试用例添加临时的属性配置
// @SpringBootTest(properties = "test.prop=testValue11")

// args属性可以为当前测试用例添加临时的命令行参数
// @SpringBootTest(args = {"--test.prop=testValue22"})
@SpringBootTest(properties = "test.prop=testValue11", args = {"--test.prop=testValue22"}) // 命令行args参数的级别较高
class TestProj01ApplicationTests {

    @Value("${servers.ip-address}")
    private String msg;

    @Value("${test.prop}")
    private String msg2;

    @Test
    void contextLoads() {
        System.out.println("---->" + msg2);
    }

}
