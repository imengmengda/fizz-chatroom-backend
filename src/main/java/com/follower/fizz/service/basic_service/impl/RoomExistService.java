package com.follower.fizz.service.basic_service.impl;

import com.follower.fizz.service.basic_service.IRoomExistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lin on 17-12-27.
 */

@Service
public class RoomExistService implements IRoomExistService {


    public boolean isRoomExist(int roomId) {
        return false; //TODO
    }
}
