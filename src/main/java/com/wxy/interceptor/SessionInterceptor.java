package com.wxy.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SessionInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(SessionInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(httpServletRequest.getRequestURI().equals("/")||httpServletRequest.getRequestURI().equals("/logout")
                ||httpServletRequest.getRequestURI().equals("/start")||httpServletRequest.getRequestURI().equals("/addUser")
                ||httpServletRequest.getRequestURI().equals("/login")||httpServletRequest.getRequestURI().equals("/register")){
            return true;
        }
        /*Object object = httpServletRequest.getSession().getAttribute("user");
        if(object==null){
            httpServletResponse.sendRedirect("/addUser");
            return false;
        }*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
