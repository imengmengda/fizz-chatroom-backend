package com.follower.fizz.controller;

import com.follower.fizz.entity.SessionParam;
import com.follower.fizz.service.ICheckSendMessageAuthService;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lin on 17-12-27.
 */
public class SendMessageInterceptor implements HandlerInterceptor {

    @Resource(name = "")
    private ICheckSendMessageAuthService iCheckSendMessageAuthService;

    private static final String ROOMID_PARAM_STRING = "roomId";

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        int roomId = Integer.parseInt(httpServletRequest.getParameter(ROOMID_PARAM_STRING));
        int userId = Integer.parseInt(httpServletRequest.getSession().getAttribute(SessionParam.USER_ID_KEY);)
        iCheckSendMessageAuthService.checkSendMessageAuthService(userId, roomId);
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
