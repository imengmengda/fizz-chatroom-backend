package com.follower.fizz.service;

import com.follower.fizz.entity.AuthStatusMessage;

/**
 * Created by lin on 17-12-18.
 */
public interface ILoginAccessService {
    public AuthStatusMessage loginAccess(String nickname, String password);
}
