package com.hotel3.service;

import com.hotel3.model.Room;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoomService {

    public List<Room> getRoom(String roomId, String roomType, String status);
}
