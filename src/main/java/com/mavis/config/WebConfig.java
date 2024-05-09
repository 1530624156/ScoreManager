package com.mavis.config;
import com.mavis.config.interceptor.AdminInterceptor;
import com.mavis.config.interceptor.LoginInterceptor;
import com.mavis.entity.Admin;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * WebConfig
 *
 * @author Mavis郭逸轩
 * @since 2024/5/9 17:31
 */


@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Resource
    private LoginInterceptor loginInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns(
                        "/student/**",
                        "/course/**",
                        "/score/**"
                ) //被拦截的接口
                .excludePathPatterns(
                        "/student/login",
                        "/student/logout",
                        "/admin/login",
                        "/admin/logout"); // 排除登录路径

    }
}