package com.xgk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xgk
 * @date 2022/1/31
 */
@Configuration
public class MyConfig {
    @Bean
    public String msg() {
        return "bean msg";
    }
}
