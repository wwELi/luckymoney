package com.example.luckymoney.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
@ConfigurationProperties(prefix = "limit")
public class LimitConfig {

    private BigDecimal min;

    private BigDecimal max;

}
