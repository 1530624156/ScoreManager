package com.mavis.config.interceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * LoginInterceptor
 * 登录拦截器
 * @author Mavis郭逸轩
 * @since 2024/5/9 17:30
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在这里写拦截逻辑，返回true则继续执行后续操作，返回false则中断请求
        //System.out.println("进入接口，拦截器触发");
        HttpSession session = request.getSession();

        if (session.getAttribute("student") != null || session.getAttribute("admin") != null){
            return true;
        }else {
            response.sendRedirect("/index.html");
            return false;
        }
    }

}