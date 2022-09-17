package com.edevapps.rest.demo.configuration;

import com.edevapps.rest.demo.SpringContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public SpringContextHolder springContextHolder() {
        return SpringContextHolder.instance();
    }
}
