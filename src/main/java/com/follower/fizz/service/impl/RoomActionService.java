package com.follower.fizz.service.impl;

import com.follower.fizz.dao.impl.RoomActionDao;
import com.follower.fizz.entity.RoomActionMessage;
import com.follower.fizz.service.IRoomActionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lin on 18-1-7.
 */

@Service
public class RoomActionService implements IRoomActionService {

    @Resource(name = "roomActionDao")
    private RoomActionDao roomActionDao;

    public boolean isRoomCreated(String roomName) {
        if (roomActionDao.findRoomByName(roomName) == null) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isUserInRoom(String userName, String roomName) {
        return roomActionDao.isUserInRoom(roomName, userName);
    }

    public RoomActionMessage createRoom(String roomName, String ownerName) {
        if (isRoomCreated(roomName)) {
            return RoomActionMessage.CREATE_ROOM_EXIST_ERROR;
        } else {
            //real action, TODO
            return RoomActionMessage.CREATE_ROOM_SUCCESS;
        }
    }

    public RoomActionMessage insertUser2Room(String userName, String roomName) {
        if (!isRoomCreated(roomName)) {
            return RoomActionMessage.JOIN_ROOM_NOT_EXIST_ERROR;
        }
        if (isUserInRoom(userName, roomName)) {
            return RoomActionMessage.JOIN_ROOM_ALREADY_IN_ERROR;
        }
        roomActionDao.insertUser2Room(userName, roomName);
        return RoomActionMessage.JOIN_ROOM_SUCCESS;
    }

    public RoomActionMessage deleteUserFromRoom(String userName, String roomName) {
        return null; //TODO, implement
    }
}
