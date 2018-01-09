package com.follower.fizz.controller;

import com.follower.fizz.service.impl.RoomActionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by lin on 18-1-7.
 */

@Controller
public class RoomActionController {

    @Resource
    private RoomActionService roomActionService;

    @ResponseBody
    @RequestMapping("/add_user_to_room")
    public String addUser2Room(@RequestParam("room_name") String roomName) {
        String userName = "hehe"; //TODO
        return roomActionService.insertUser2Room(userName, roomName).toString();
    }

    @ResponseBody
    @RequestMapping("/create_room")
    public String createRoom(@RequestParam("room_name") String roomName) {
        String ownerName = "hehe";
        return roomActionService.createRoom(roomName, ownerName).toString();
    }


}
