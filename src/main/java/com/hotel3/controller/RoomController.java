package com.hotel3.controller;

import com.hotel3.model.Room;
import com.hotel3.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
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

        return "";
    }
}
