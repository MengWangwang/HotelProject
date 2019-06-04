package com.hotel3.controller;

import com.hotel3.model.InOrder;
import com.hotel3.model.PreOrder;
import com.hotel3.model.Room;
import com.hotel3.model.User;
import com.hotel3.service.InOrderService;
import com.hotel3.service.PreOrderService;
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
public class PreOrderController {

    @Resource(name="PreOrderService")
    private PreOrderService preOrderService;

    @Resource(name="InOrderService")
    private InOrderService inOrderService;

    @Resource(name="RoomService")
    private RoomService roomService;

    private final String InOrderNum ="INON";

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
        return "addInOrderByPreOrder";
    }
    @PostMapping("/inOrderByPreOrder")
    public String inOrderByPreOrder(InOrder inOrder, HttpSession session){

        Date nowTime = new Date();
        User user= (User)session.getAttribute("loginUser");
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmmss");
        SimpleDateFormat CreaterFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = formatter.format(nowTime);
        String Inid=InOrderNum+dateString+((int)(Math.random()*9+1)*10000);
        inOrder.setInId(Inid);
        if(inOrder.getInTime()!=null)
        {
            inOrder.setInTime(inOrder.getInTime().replace("T"," "));
        }
        if(inOrder.getOutTime()!=null)
        {
            inOrder.setOutTime(inOrder.getOutTime().replace("T"," "));
        }
        inOrder.setCreaterDate(CreaterFormatter.format(nowTime));
        inOrder.setCreaterBy(user.getUserName());
        inOrder.setStatus("入住");
        String[] RoomIds=new String[]{inOrder.getRoomId()};
        roomService.OpenRoom(RoomIds,"占用");
        inOrderService.addInOrder(inOrder);
        PreOrder preOrder=new PreOrder();
        preOrder.setStatus("入住");
        preOrder.setPreId(inOrder.getPreId());
        preOrderService.updatePreOrderById(preOrder);
        return "redirect:/inOrders";
    }

    @GetMapping("/preOrder/{preId}")
    public String toPreEditPage(@PathVariable("preId") String preId, Model model, HttpSession session){
        PreOrder preOrder=preOrderService.getOnePreOrder(preId);
        Date nowTime = new Date();
        User user= (User)session.getAttribute("loginUser");
        SimpleDateFormat CreaterFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        preOrder.setPreInTime(preOrder.getPreInTime().replace(" ","T"));
        preOrder.setPreOutTime(preOrder.getPreOutTime().replace(" ","T"));

        preOrder.setCreaterDate(CreaterFormatter.format(nowTime));
        preOrder.setCreaterBy(user.getUserName());
        List<Room> Rooms= roomService.getRoom("","","闲置");
        model.addAttribute("Rooms",Rooms);
        model.addAttribute("perOrder",preOrder);
        return "preOrder/addInOrderByPreOrder";
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
