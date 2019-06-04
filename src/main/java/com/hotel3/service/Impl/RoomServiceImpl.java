package com.hotel3.service.Impl;

import com.hotel3.mapper.RoomMapper;
import com.hotel3.model.Room;
import com.hotel3.service.RoomService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("RoomService")
public class RoomServiceImpl implements RoomService {

    @Resource(name="RoomMapper")
    private RoomMapper roomMapper;


    @Override
    public List<Room> getRoom(String roomId, String roomType, String status) {
        return roomMapper.getRoom(roomId,roomType,status);
    }

    @Override
    public int addRoom(Room room) {
        return roomMapper.addRoom(room);
    }

    @Override
    public Room getOneRoom(String roomId) {
        return roomMapper.getOneRoom(roomId);
    }

    @Override
    public int updateRoomById(Room room) {
        return roomMapper.updateRoomById(room);
    }

    @Override
    public int deleteRoomById(String roomId) {
        return roomMapper.deleteRoomById(roomId);
    }

    @Override
    public int OpenRoom(String[] roomIds,String status) {
        return roomMapper.OpenRoom(roomIds,status);
    }
}
