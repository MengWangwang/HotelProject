package com.hotel3.controller;

import com.hotel3.model.InOrder;
import com.hotel3.model.Room;
import com.hotel3.service.InOrderService;
import com.hotel3.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class InOrderController {

    @Resource(name="InOrderService")
    private InOrderService inOrderService;

    @Resource(name="RoomService")
    private RoomService roomService;

    private final String InOrderNum ="INON00";

    @GetMapping("/inOrders")
    public String list(Model model){
       List<InOrder> InOrders= inOrderService.getInOrderAll();
        model.addAttribute("Orders",InOrders);
        return "inOrder/inOrderList";
    }

    @GetMapping("/inOrder")
    public String toAddInOrderPage(Model model){
        List<Room> Rooms= roomService.getRoom("","","");
        model.addAttribute("Rooms",Rooms);
        return "inOrder/addInOrder";
    }
    @PostMapping("/inOrder")
    public String addInOrder(InOrder inOrder){

        Date nowTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(nowTime);
        String Inid=InOrderNum+dateString+((int)(Math.random()*9+1)*10000);
        inOrder.setInId(Inid);
        inOrder.setOrderType("Scene");
        inOrder.setStatus("10");
        inOrderService.addInOrder(inOrder);
        return "redirect:/inOrders";
    }

    @GetMapping("/inOrder/{inId}")
    public String toEditPage(@PathVariable("inId") String inId,Model model){
        InOrder inOrder=inOrderService.getOneInOrder(inId);
        List<Room> Rooms= roomService.getRoom("","","");
        model.addAttribute("Rooms",Rooms);
        model.addAttribute("inOrder",inOrder);
        return "inOrder/addInOrder";
    }

    @PutMapping("/inOrder")
    public String updateInOrder(InOrder inOrder){

        inOrderService.updateInOrderById(inOrder);

        return "redirect:/inOrders";
    }

    @DeleteMapping("/inOrder/{inId}")
    public String deleteInOrder(@PathVariable("inId") String inId){
        inOrderService.deleteInOrderById(inId);
        return "redirect:/inOrders";
    }
}
