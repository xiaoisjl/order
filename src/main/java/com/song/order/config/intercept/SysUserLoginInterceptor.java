package com.song.order.config.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysUserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginName = request.getSession().getAttribute("loginName");
        if (null == loginName || !(loginName instanceof String)) {
            System.out.println("拦截");
            // 未登录，重定向到登录页
            response.sendRedirect("/");
            return false;
        }
        String userName = (String) loginName;
        System.out.println("当前用户已登录，登录的用户名为： " + userName);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("中");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("后");
    }
}
