package com.follower.fizz.service;

import com.follower.fizz.dao.impl.RoomActionDao;
import com.follower.fizz.entity.RoomActionMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lin on 18-1-7.
 */

@Service
public interface IRoomActionService {

    boolean isRoomCreated(String roomName);

    boolean isUserInRoom(String userName, String roomName);

    RoomActionMessage createRoom(String roomName, String ownerName);

    RoomActionMessage insertUser2Room(String userName, String roomName);

    RoomActionMessage deleteUserFromRoom(String userName, String roomName);
}
