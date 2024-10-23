package org.example.avemusicaback.config;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 在SpringBoot过滤器中配置跨域，
 * 跨域配置不能和拦截器写一起，
 * 会造成冲突，
 * 需要在过滤器中配置跨域，
 * 过滤器在拦截器前进行。
 * 在“Access-Control-Allow-Headers”中，
 * 需要添加上token，
 * 因为前端要传输token到后端，不能过滤掉。
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@WebFilter("/*")
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
        response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, token");
        response.setHeader("Access-Control-Max-Age", "3600");
        if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) req).getMethod())){
            response.setStatus(200);
        }else {
            chain.doFilter(req, res);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {
    }

}