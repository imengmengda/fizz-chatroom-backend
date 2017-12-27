package com.follower.fizz.service;

import com.follower.fizz.entity.AuthStatusMessage;

/**
 * Created by lin on 17-12-18.
 */
public interface IRegisterAccessService {

    public AuthStatusMessage run(String nickname, String password);
}
