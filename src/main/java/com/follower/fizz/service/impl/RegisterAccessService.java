package com.follower.fizz.service.impl;

import com.follower.fizz.dao.impl.LoginAdapterUserDao;
import com.follower.fizz.dao.impl.RegisterDao;
import com.follower.fizz.entity.AuthStatusMessage;
import com.follower.fizz.service.IRegisterAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lin on 17-12-18.
 */

@Service
public class RegisterAccessService implements IRegisterAccessService {

    @Autowired
    private RegisterDao registerDao;

    @Autowired
    private LoginAdapterUserDao loginAdapterUserDao;

    public AuthStatusMessage run(String nickname, String password) {
        if (loginAdapterUserDao.findUserByNickname(nickname) != null) {
            return AuthStatusMessage.REGISTER_USER_EXIST;
        } else {
            registerDao.registerUser(nickname, password);
            return AuthStatusMessage.REGISTER_SUCCESS;
        }
    }
}
