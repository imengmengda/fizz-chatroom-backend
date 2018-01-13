package com.follower.fizz.dao.impl;

import com.follower.fizz.entity.LoginAdapterUser;
import com.follower.fizz.entity.Room;
import com.follower.fizz.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lin on 18-1-6.
 */
@Repository
public class RoomActionDao {

    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Resource(name = "loginAdapterUserDao")
    private LoginAdapterUserDao loginAdapterUserDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void insertUser2Room(String userName, String roomName) {
        Room room = findRoomByName(roomName);
        User user = loginAdapterUserDao.findUserByNickname(userName);
        user.getRooms().add(room);
        hibernateTemplate.save(user);
    }

    public Room findRoomByName(String roomName) {
        String findByRoomNameSql = "from Room where roomName = ?";
        List<Room> rooms = (List)hibernateTemplate.find(findByRoomNameSql, roomName);
        if (rooms.size() > 0) {
            return rooms.get(0);
        }
        return null;
    }

    public void createRoomByName(String roomName, String ownerName) {

    }

    public boolean isUserInRoom(Room room, String userName) {
        for (User user: room.getUsers()) {
            if (user.getNickname().equals(userName)) return true;
        }
        return false;
    }
}
