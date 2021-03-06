package com.etoak.interceptor;

import com.etoak.bean.User;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(ObjectUtils.isEmpty(user)){
            response.sendRedirect(request.getContextPath()+"/user/toLogin");
            return false;
        }
        return true;
    }
}
