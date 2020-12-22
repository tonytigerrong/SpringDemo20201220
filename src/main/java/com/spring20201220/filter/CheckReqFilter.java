package com.spring20201220.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class CheckReqFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(
                "CheckReqFilter======>" +
                        request.getParameter("name")
        );
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
