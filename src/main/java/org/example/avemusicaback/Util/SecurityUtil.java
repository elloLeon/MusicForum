package org.example.avemusicaback.Util;


import jakarta.servlet.http.HttpServletRequest;
import org.example.avemusicaback.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class SecurityUtil {

    @Autowired
    HttpServletRequest httpServletRequest;

    public User getCurrentUser(){
        return (User)httpServletRequest.getSession().getAttribute("currentUser");
    }
}
