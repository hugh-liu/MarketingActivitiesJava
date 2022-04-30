package com.hugh.config;

import com.hugh.interceptor.WxRequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Copyright © 2022 hugh. Tech Ltd. All rights reserved.
 * 功能描述：
 *
 * @author: 刘锦辉
 * @date: 2022/4/24
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WxRequestInterceptor())
                .addPathPatterns("/", "view/index.html")
                .excludePathPatterns("/**");
    }

}
