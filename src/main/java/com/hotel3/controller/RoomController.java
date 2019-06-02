package com.hotel3.controller;

import com.hotel3.model.InOrder;
import com.hotel3.model.Room;
import com.hotel3.model.User;
import com.hotel3.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RoomController {

    @Resource(name="RoomService")
    private RoomService roomService;

    @GetMapping("/Rooms")
    public String Roomlist(Model model){
        List<Room> Rooms= roomService.getRoom("","","");
        model.addAttribute("Rooms",Rooms);
        return "/Room/RoomList";
    }

    @GetMapping("/Room")
    public String toAddRoomPage(){

        return "/Room/addRoom";
    }

    @PostMapping("/Room")
    public String addInOrder(Room room, HttpSession session){

        roomService.addRoom(room);

        return "redirect:/Rooms";
    }

    @GetMapping("/Room/{roomId}")
    public String toEditPage(@PathVariable("roomId") String roomId, Model model){

        Room room= roomService.getOneRoom(roomId);
        model.addAttribute("Room",room);
        return "/Room/addRoom";
    }

    @PutMapping("/Room")
    public String updateRoom(Room room){

        roomService.updateRoomById(room);

        return "redirect:/Rooms";
    }

    @DeleteMapping("/Room/{roomId}")
    public String deleteRoom(@PathVariable("roomId") String roomId){
        roomService.deleteRoomById(roomId);
        return "redirect:/Rooms";
    }

}
