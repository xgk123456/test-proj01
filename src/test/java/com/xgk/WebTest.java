package com.xgk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.*;

/**
 * @author xgk
 * @date 2022/1/31
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// 开启虚拟MVC调用
@AutoConfigureMockMvc
public class WebTest {

    @Test
    public void testWeb(@Autowired MockMvc mvc) throws Exception {
        // 创建虚拟请求，当前访问/books
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        // 执行对应的请求
        ResultActions active = mvc.perform(builder);
    }

    @Test
    void testStatus(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions active = mvc.perform(builder);

        // 定义预期值与真实值进行比较，成功测试通过，失败测试失败
        // 定义本测调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // 预计本测调用是成功的：状态200
        ResultMatcher ok = status.isOk();
        // 使用本次真实执行结果与预期结果进行比对
        active.andExpect(ok);
    }

    @Test
    void testBody(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions active = mvc.perform(builder);

        // 设定预期值与真实值进行比较
        // 定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.string("springboot!");
        active.andExpect(result);
    }

    @Test
    void testJson(@Autowired MockMvc mvc) throws Exception{
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions active = mvc.perform(builder);
        // 设定预期值与真实值进行比较
        // 定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{id:1, name: zhangsan}");
        active.andExpect(result);
    }

    @Test
    void testHeader(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books");
        ResultActions active = mvc.perform(builder);

        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher result = header.string("Content-Type", "application/json");
        active.andExpect(result);
    }
}
