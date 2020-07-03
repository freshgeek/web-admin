package com.demo.webadmin.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@WebFilter(filterName = "corsFilter", urlPatterns = {"/*"})
@Order(1)
public class CorsFilter implements Filter {



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        if ("OPTIONS".equals(request.getMethod())) {
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "Content-Type,token, userId, name, userName");
            response.addHeader("Access-Control-Max-Age", "1");
        } else {
//            response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,POST,PUT,DELETE,OPTIONS");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "*");
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

}
