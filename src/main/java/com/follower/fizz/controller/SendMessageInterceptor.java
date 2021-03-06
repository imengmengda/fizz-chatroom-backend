package com.follower.fizz.controller;

import com.follower.fizz.entity.AuthStatusMessage;
import com.follower.fizz.entity.SendMessageStatus;
import com.follower.fizz.entity.SessionParam;
import com.follower.fizz.service.ICheckSendMessageAuthService;
import com.follower.fizz.util.SendMessageUtil;
import org.omg.PortableInterceptor.Interceptor;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lin on 17-12-27.
 */
public class SendMessageInterceptor implements HandlerInterceptor {

    @Resource(name = "checkSendMessageAuthService")
    private ICheckSendMessageAuthService iCheckSendMessageAuthService;

    private static final String ROOMID_PARAM_STRING = "roomId";

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        int roomId = Integer.parseInt(httpServletRequest.getParameter(ROOMID_PARAM_STRING));
        int userId = Integer.parseInt((String) httpServletRequest.getSession().getAttribute(SessionParam.USER_ID_KEY));

        SendMessageStatus checkResult = iCheckSendMessageAuthService.checkSendMessageAuthService(userId, roomId);

        if (checkResult != null) {
            SendMessageUtil.sendMessage(httpServletResponse, checkResult);
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
