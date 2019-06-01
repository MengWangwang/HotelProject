package com.hotel3.mapper;

import com.hotel3.model.Room;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("RoomMapper")
public interface RoomMapper {

    public List<Room> getRoom(@Param("roomId") String roomId, @Param("roomType") String roomType, @Param("status") String status);
}