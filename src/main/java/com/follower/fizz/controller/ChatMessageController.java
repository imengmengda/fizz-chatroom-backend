package com.follower.fizz.controller;

import com.follower.fizz.entity.SendMessageStatus;
import com.follower.fizz.service.ISendChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lin on 17-12-18.
 */

@Controller
public class ChatMessageController {

    @Resource(name = "sendChatMessageService")
    private ISendChatMessageService sendChatMessageService;

    @RequestMapping("/sendMessageTest")
    @ResponseBody
    public String sendMessage() {
        return "sendMessage";
    }

    @RequestMapping("/sendMessage")
    @ResponseBody
    private SendMessageStatus sendMessage(int userId, int roomId) {
        return sendChatMessageService.sendMessage(userId, roomId);
    }
}
