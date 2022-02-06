package com.xgk;

import com.alibaba.druid.pool.DruidDataSource;
import com.xgk.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({ServerConfig.class})
public class ProjApplication {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DruidDataSource dataSource (){
        DruidDataSource ds = new DruidDataSource();
        // ds.setDriverClassName("com.mysql.jdbc.driver");
        return ds;
    }

    public static void main(String[] args) {
        // 获取ioc容器
        ConfigurableApplicationContext app = SpringApplication.run(ProjApplication.class, args);
//        ServerConfig config = app.getBean(ServerConfig.class);
//        System.out.println(config);

        DruidDataSource ds = app.getBean(DruidDataSource.class);
        System.out.println(ds);
        System.out.println(ds.getDriverClassName());
        System.out.println("Test App...");
        System.out.println("Test App git...");
    }

}
