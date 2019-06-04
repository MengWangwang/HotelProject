package com.hotel3.controller;

import com.hotel3.mapper.Message;
import com.hotel3.model.InOrder;
import com.hotel3.model.PreOrder;
import com.hotel3.model.Room;
import com.hotel3.model.User;
import com.hotel3.service.InOrderService;
import com.hotel3.service.PreOrderService;
import com.hotel3.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class InOrderController {

    @Resource(name="InOrderService")
    private InOrderService inOrderService;

    @Resource(name="RoomService")
    private RoomService roomService;

    @Resource(name="PreOrderService")
    private PreOrderService preOrderService;

    private final String InOrderNum ="INON";

    @GetMapping("/inOrders")
    public String list(Model model){
        InOrder inOrder=new InOrder();
        List<InOrder> InOrders= inOrderService.getInOrderAll(inOrder);
        List<Room> Rooms= roomService.getRoom("","","");
        model.addAttribute("Rooms",Rooms);
        model.addAttribute("InOrders",InOrders);
        return "inOrder/inOrderList";
    }

    @PostMapping("/inOrders")
    public String Selectlist(Model model,InOrder inOrder){

        inOrder.setInTime(inOrder.getInTime().replace("T"," "));
        inOrder.setOutTime(inOrder.getOutTime().replace("T"," "));
        inOrder.setCreaterDate(inOrder.getCreaterDate().replace("T"," "));
        List<InOrder> InOrders= inOrderService.getInOrderAll(inOrder);
        List<Room> Rooms= roomService.getRoom("","","闲置");
        model.addAttribute("Rooms",Rooms);
        model.addAttribute("InOrders",InOrders);
        return "inOrder/inOrderList";
    }

    @GetMapping("/inOrder")
    public String toAddInOrderPage(Model model){
        List<Room> Rooms= roomService.getRoom("","","闲置");
        model.addAttribute("Rooms",Rooms);
        return "inOrder/addInOrder";
    }
    @PostMapping("/inOrder")
    @Transactional
    public String addInOrder(InOrder inOrder, HttpSession session){

        Date nowTime = new Date();
        User user= (User)session.getAttribute("loginUser");
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
        SimpleDateFormat CreaterFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = formatter.format(nowTime);
        String Inid=InOrderNum+dateString+((int)(Math.random()*9+1)*10000);
        inOrder.setInId(Inid);
        inOrder.setInTime(inOrder.getInTime().replace("T"," "));
        inOrder.setOutTime(inOrder.getOutTime().replace("T"," "));
        inOrder.setCreaterDate(CreaterFormatter.format(nowTime));
        inOrder.setCreaterBy(user.getUserName());
        inOrder.setStatus("入住");
        String[] RoomIds=new String[]{inOrder.getRoomId()};
        roomService.OpenRoom(RoomIds,"占用");
        inOrderService.addInOrder(inOrder);
        return "redirect:/inOrders";
    }

    @GetMapping("/inOrder/{inId}")
    public String toEditPage(@PathVariable("inId") String inId,Model model,HttpSession session){

        Date nowTime = new Date();
        User user= (User)session.getAttribute("loginUser");
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
        SimpleDateFormat CreaterFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        InOrder inOrder=inOrderService.getOneInOrder(inId);
        if(inOrder.getInTime()!=null)
        {
            inOrder.setInTime(inOrder.getInTime().replace(" ","T"));
        }
        if(inOrder.getOutTime()!=null)
        {
            inOrder.setOutTime(inOrder.getOutTime().replace(" ","T"));
        }
        List<Room> Rooms= roomService.getRoom("","","闲置");
        model.addAttribute("Rooms",Rooms);
        model.addAttribute("inOrder",inOrder);
        return "inOrder/addInOrder";
    }

    @PutMapping("/inOrder")
    public String updateInOrder(InOrder inOrder,HttpSession session){

        Date nowTime = new Date();
        User user= (User)session.getAttribute("loginUser");
        SimpleDateFormat CreaterFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        inOrder.setInTime(inOrder.getInTime().replace("T"," "));
        inOrder.setOutTime(inOrder.getOutTime().replace("T"," "));
        inOrder.setModifiedDate(CreaterFormatter.format(nowTime));
        inOrder.setModifiedBy(user.getUserName());

        inOrderService.updateInOrderById(inOrder);

        return "redirect:/inOrders";
    }

    @DeleteMapping("/inOrder/{inId}")
    public String deleteInOrder(@PathVariable("inId") String inId){
        inOrderService.deleteInOrderById(inId);
        return "redirect:/inOrders";
    }

    @PostMapping("/OverInOrder")
    @ResponseBody
    @Transactional
    public Message OverInOrder(@RequestParam(value = "InIds[]")String[] InIds,@RequestParam(value = "RoomIds[]")String[] RoomIds, @RequestParam(value = "PreIds[]")String[] PreIds,HttpSession session){

        User user= (User)session.getAttribute("loginUser");
        inOrderService.OverInOrder(InIds,"结单",user.getUserName());
        roomService.OpenRoom(RoomIds,"闲置");
        if(!Arrays.asList(PreIds).contains("temp")){
            preOrderService.OverPreOrder(PreIds,"结单");
        }

        return new Message("", "success");
    }
}
