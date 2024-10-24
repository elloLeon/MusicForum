package org.example.avemusicaback.Interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.avemusicaback.Util.TokenUtil;
import org.example.avemusicaback.exception.AveMusicaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    TokenUtil tokenUtil;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("token");
        System.out.println(token);
        if (token != null && tokenUtil.verifyToken(token)) {
            request.getSession().setAttribute("currentUser", tokenUtil.getUser(token));
            System.out.println(token);
            return true;

        } else {

            throw AveMusicaException.notLogin();
        }


    }
}
