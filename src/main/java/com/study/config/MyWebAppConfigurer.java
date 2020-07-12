package com.study.config;

import com.study.interceptor.URLInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

    private static List<String> EXCLUDE_PATH = Arrays.asList("/","/login/toLogin/**","/login/getCode/**","/error","/resources/**");

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new URLInterceptor()).addPathPatterns("/**").excludePathPatterns(EXCLUDE_PATH);
        super.addInterceptors(registry);
    }
}
