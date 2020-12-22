package com.spring20201220.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggingRqRs extends HandlerInterceptorAdapter {
//    private Logger logger = Logger.getLogger(LoggingRqRs.class.getName());
    @Override
    public String toString() {
        return "LoggingRqRs{}";
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        logger.log(Level.ALL,
//                "PreHandle------>"+
//                request.getRequestURI()+
//                "\r\n\t"+
//                request.getMethod());
        System.out.println("PreHandle============>"+
                request.getRequestURI()+
                "\r\n\t"+
                request.getMethod());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle============>"+
                response.getStatus()+
                "\r\n\t"+
                response.toString());
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion============>"+
                handler.toString()+
                "\r\n\t"+
                response.toString());
        super.afterCompletion(request, response, handler, ex);
    }
}
