package com.follower.fizz.service;

import com.follower.fizz.entity.SendMessageStatus;

/**
 * Created by lin on 17-12-27.
 */
public interface ICheckSendMessageAuthService {

    public SendMessageStatus checkSendMessageAuthService(int userId, int roomId);

}
