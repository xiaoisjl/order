package com.song.order.config.intercept;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.Date;

public class GobalInterceptor implements HandlerInterceptor {

    public static final String START_TIME = "start_time";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(START_TIME, new Date().getTime());
        System.out.println("全局拦截器");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        Long start_time = (Long) request.getAttribute(START_TIME);
        System.out.println("执行时间" + (new Date().getTime() - start_time));
    }
}
