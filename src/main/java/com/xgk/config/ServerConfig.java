package com.xgk.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author xgk
 * @date 2022/1/31
 */
//@Component
@ConfigurationProperties(prefix = "servers")
@Data
// 2.开启对当前bean的属性注入校验
@Validated
public class ServerConfig {
    private String ipAddress;
    // 3.设置具体的校验规则
    @Max(value = 8888, message = "最大值不能超过8888")
    @Min(value = 202, message = "最小值不能低于202")
    private String port;
    private long timeout;
    @DurationUnit(ChronoUnit.MINUTES)   // 时间单位 min
    private Duration serverTimeOut;     // 超时时间
    @DataSizeUnit(DataUnit.MEGABYTES)   // 存储容量单位 MB
    private DataSize dataSize;
}
