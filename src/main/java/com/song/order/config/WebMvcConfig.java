package com.song.order.config;

import com.song.order.config.intercept.GobalInterceptor;
import com.song.order.config.intercept.SysUserLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    SysUserLoginInterceptor sysUserLoginInterceptor() {
        return new SysUserLoginInterceptor();
    }

    @Bean
    GobalInterceptor gobalInterceptor() { return new GobalInterceptor();}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(gobalInterceptor());

        InterceptorRegistration loginRegistry  = registry.addInterceptor(sysUserLoginInterceptor());
        loginRegistry.addPathPatterns("/**");
        // 排除路径
        loginRegistry.excludePathPatterns("/");
        loginRegistry.excludePathPatterns("/login");
        loginRegistry.excludePathPatterns("/logout");
        loginRegistry.excludePathPatterns("/account/*");
        // 排除资源请求
        loginRegistry.excludePathPatterns("/static/js/*");
        loginRegistry.excludePathPatterns("/css/login/*.css");
        loginRegistry.excludePathPatterns("/js/login/**/*.js");
        loginRegistry.excludePathPatterns("/image/login/*.png");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
    }
}