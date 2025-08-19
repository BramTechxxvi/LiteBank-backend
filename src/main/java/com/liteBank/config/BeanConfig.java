package com.liteBank.config;

import org.springframework.context.annotation.Bean;

public class BeanConfig {

    @Bean
    public BeanConfig modelMapper() {
        return new BeanConfig();
    }
}
