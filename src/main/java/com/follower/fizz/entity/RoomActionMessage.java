package com.follower.fizz.entity;

/**
 * Created by lin on 18-1-7.
 */
public enum RoomActionMessage {

    CREATE_ROOM_EXIST_ERROR(-1, "room exist"),

    CREATE_ROOM_SUCCESS(0, "create room success"),

    JOIN_ROOM_NOT_EXIST_ERROR(-1, "room not exist"),

    JOIN_ROOM_ALREADY_IN_ERROR(-1, "user in room already"),

    JOIN_ROOM_SUCCESS(0, "user join room success");

    private int statusCode; //0 success, -1 fail

    private String statusMessage;

    private RoomActionMessage(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
