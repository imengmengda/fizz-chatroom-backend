package com.follower.fizz.service;

import com.follower.fizz.entity.SendMessageStatus;

/**
 * Created by lin on 17-12-18.
 */
public interface ISendChatMessageService {

    public SendMessageStatus sendMessage(int userId, int roomID);
}
