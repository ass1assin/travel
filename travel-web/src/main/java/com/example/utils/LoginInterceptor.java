package com.example.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
//还没改
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object userLoggedIn = request.getSession().getAttribute("userLoggedIn");

        // 如果是登录页面，不拦截
        if (request.getRequestURI().endsWith("/view/common/login.html")) {
            return true;
        }

        if (userLoggedIn != null && (Boolean) userLoggedIn) {
            // 用户已登录，继续执行后续的请求处理
            return true;
        } else {
            // 用户未登录，进行拦截并重定向到登录页面
            response.sendRedirect("/view/common/login.html");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
