package com.follower.fizz.service.impl;

import com.follower.fizz.dao.impl.LoginAdapterUserDao;
import com.follower.fizz.entity.AuthStatusMessage;
import com.follower.fizz.entity.User;
import com.follower.fizz.service.ILoginAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lin on 17-12-18.
 */

@Service("loginAccessService")
public class LoginAccessService implements ILoginAccessService {

    @Autowired
    private LoginAdapterUserDao loginAdapterUserDao;

    public AuthStatusMessage loginAccess(String nickname, String password) {
        User user = loginAdapterUserDao.findUserByNickname(nickname);
        if (user == null) {
            return AuthStatusMessage.LOGIN_USER_NOT_EXIST;
        }
        if (!password.equals(user.getPassword())) {
            return AuthStatusMessage.LOGIN_PASSWORD_ERROR;
        } else {
            return AuthStatusMessage.LOGIN_SUCCESS;
        }
    }
}
