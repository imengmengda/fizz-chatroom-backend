package com.follower.fizz.entity;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by lin on 17-12-23.
 */
@Entity
@Table(name = "room")
public class Room {
    private int roomId;
    private Timestamp roomCreatedTime;
    private String roomName;
    private Set<User> users;

    @Id
    @Column(name = "room_id", nullable = false)
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "room_created_time", nullable = false)
    public Timestamp getRoomCreatedTime() {
        return roomCreatedTime;
    }

    public void setRoomCreatedTime(Timestamp roomCreatedTime) {
        this.roomCreatedTime = roomCreatedTime;
    }

    @Basic
    @Column(name = "room_name", nullable = false, length = 50)
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @ManyToMany
    @JoinTable(name = "room_member",
            joinColumns = {@JoinColumn(name = "room_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;

        if (roomId != room.roomId) return false;
        if (roomCreatedTime != null ? !roomCreatedTime.equals(room.roomCreatedTime) : room.roomCreatedTime != null)
            return false;
        if (roomName != null ? !roomName.equals(room.roomName) : room.roomName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roomId;
        result = 31 * result + (roomCreatedTime != null ? roomCreatedTime.hashCode() : 0);
        result = 31 * result + (roomName != null ? roomName.hashCode() : 0);
        return result;
    }
}
