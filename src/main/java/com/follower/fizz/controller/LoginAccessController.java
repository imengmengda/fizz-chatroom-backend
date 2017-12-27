package com.follower.fizz.controller;

import com.follower.fizz.entity.AuthStatusMessage;
import com.follower.fizz.entity.SessionParam;
import com.follower.fizz.service.ILoginAccessService;
import com.follower.fizz.service.IRegisterAccessService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by lin on 17-12-17.
 */

@Controller
public class LoginAccessController {

    /*
    @Autowired
    private ILoginAccessLogService loginAccessLogService;
    */

    @Resource(name = "loginAccessService")
    private ILoginAccessService loginAccessService;


    @Resource(name = "registerAccessService")
    private IRegisterAccessService registerAccessService;


    @RequestMapping("/register")
    @ResponseBody
    public String registerAccess(@RequestParam("username") String nickname,
                                 @RequestParam("password") String password,
                                 HttpSession session) {
        AuthStatusMessage authFailMessage = registerAccessService.run(nickname, password);
        if (authFailMessage.getIsSuccess()) {
            session.setAttribute(SessionParam.LOGIN_SUCCESS_FLAG_KEY, SessionParam.LOGIN_SUCCESS_FLAG_VALUE);
        }
        return authFailMessage.toString();
    }

    @ResponseBody
    @RequestMapping("/login")
    public String loginAccess(@RequestParam("username") String nickname,
                                         @RequestParam("password") String password,
                                         HttpSession session) {

        AuthStatusMessage authFailMessage = loginAccessService.loginAccess(nickname, password);
        if (authFailMessage.getIsSuccess()) {
            session.setAttribute(SessionParam.LOGIN_SUCCESS_FLAG_KEY, SessionParam.LOGIN_SUCCESS_FLAG_VALUE);
        }
        return authFailMessage.toString();
    }
}
