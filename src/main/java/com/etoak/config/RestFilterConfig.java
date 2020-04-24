/*
package com.etoak.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@Configuration
public class RestFilterConfig {
    @Bean
    public FilterRegistrationBean<HiddenHttpMethodFilter> restFilter(){
    FilterRegistrationBean<HiddenHttpMethodFilter> restFilter =
            new FilterRegistrationBean<>(new HiddenHttpMethodFilter());
    restFilter.addUrlPatterns("/*");
    return  restFilter;
}

}
*/
