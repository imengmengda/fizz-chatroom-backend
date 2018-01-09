package com.follower.fizz.service.impl;

import com.follower.fizz.entity.SendMessageStatus;
import com.follower.fizz.service.ISendChatMessageService;
import org.springframework.stereotype.Service;

/**
 * Created by lin on 17-12-18.
 */

@Service
public class SendChatMessageService implements ISendChatMessageService{

    public SendMessageStatus sendMessage(int userId, int roomID) {
        return null; //TODO
    }

}
