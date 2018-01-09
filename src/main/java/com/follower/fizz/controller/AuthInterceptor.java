package com.follower.fizz.controller;

import com.follower.fizz.entity.AuthStatusMessage;
import com.follower.fizz.entity.SessionParam;
import com.follower.fizz.util.SendMessageUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lin on 17-12-20.
 */

public class AuthInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String loginedFlag = (String)httpServletRequest.getSession().getAttribute(SessionParam.LOGIN_SUCCESS_FLAG_KEY);

        if (StringUtils.isEmpty(loginedFlag)) {
            SendMessageUtil.sendMessage(httpServletResponse, AuthStatusMessage.SESSEION_NOT_EXIST);
            return false;
        } else {
            return true;
        }

    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
