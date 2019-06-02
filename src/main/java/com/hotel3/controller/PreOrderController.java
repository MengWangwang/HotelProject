package com.hotel3.controller;

import com.hotel3.model.InOrder;
import com.hotel3.model.PreOrder;
import com.hotel3.model.Room;
import com.hotel3.service.PreOrderService;
import com.hotel3.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class PreOrderController {

    @Resource(name="PreOrderService")
    private PreOrderService preOrderService;

    @Resource(name="RoomService")
    private RoomService roomService;

    private final String InOrderNum ="INON00";

    @GetMapping("/preOrders")
    public String preList(Model model){
       List<PreOrder> PreOrders= preOrderService.getPreOrderAll();
        model.addAttribute("PreOrders",PreOrders);
        return "preOrder/preOrderList";
    }

    @GetMapping("/perOrder")
    public String toAddPreOrderPage(Model model){
        List<Room> Rooms= roomService.getRoom("","","");
        model.addAttribute("Rooms",Rooms);
        return "preOrder/addPreOrder";
    }
    @PostMapping("/perOrder")
    public String addPreOrder(PreOrder preOrder){

        Date nowTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(nowTime);
        String Inid=InOrderNum+dateString+((int)(Math.random()*9+1)*10000);
        preOrder.setInId(Inid);
        preOrder.setOrderType("Scene");
        preOrder.setStatus("10");
        preOrderService.addPreOrder(preOrder);
        return "redirect:/preOrders";
    }

    @GetMapping("/preOrder/{inId}")
    public String toPreEditPage(@PathVariable("inId") String inId,Model model){
        PreOrder preOrder=preOrderService.getOnePreOrder(inId);
        List<Room> Rooms= roomService.getRoom("","","");
        model.addAttribute("Rooms",Rooms);
        model.addAttribute("perOrder",preOrder);
        return "preOrder/addPreOrder";
    }

    @PutMapping("/preOrder")
    public String updatePreOrder(PreOrder preOrder){

        preOrderService.updatePreOrderById(preOrder);

        return "redirect:/preOrders";
    }

    @DeleteMapping("/preOrder/{inId}")
    public String deletePreOrder(@PathVariable("inId") String inId){
        preOrderService.deletePreOrderById(inId);
        return "redirect:/preOrders";
    }
}
