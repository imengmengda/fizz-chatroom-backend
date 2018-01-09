package com.follower.fizz.service.basic_service.impl;

import com.follower.fizz.service.basic_service.IRoomExistService;
import com.follower.fizz.service.basic_service.IUserInRoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lin on 17-12-27.
 */

@Service
public class UserInRoomService implements IUserInRoomService {

    @Resource(name = "roomExistService")
    private IRoomExistService roomExistService;

    public boolean isUserInRoom(int userId, int roomId) {
        if (!roomExistService.isRoomExist(roomId)) {
            return false;
        } else {
            return true; //TODO
        }
    }
}
