package com.hotel3.controller;


import com.hotel3.model.User;
import com.hotel3.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Resource(name="UserService")
    private UserService userService;

    private Integer stuid;

    @GetMapping(value = "loginNew")
    public String  loginG (HttpServletRequest request){
        return "loginNew";
    }

    @PostMapping(value = "loginNew")
    public String login (HttpServletRequest request,@RequestParam("userName")String userName, @RequestParam("userPassword")String userPassword, HttpSession session){
        System.out.println(userName+userPassword);
        User u=userService.getUserByNameAndPsw(userName,userPassword);
        if (u!=null){

            session.setAttribute("loginUser",u);

            return "redirect:/index.html";
        }else {
            request.setAttribute("msg","用户名或密码错误");
            return "loginNew";
        }
    }

    @GetMapping(value = "SignOut")
    public String  SignOut (HttpServletRequest request){

        HttpSession session = request.getSession();
        session.removeAttribute("loginUser");

        return "redirect:/loginNew.html";
    }

    @PostMapping(value = "register")
    public String registerG ( User user){
        if(userService.addUser(user)==1){
            return "redirect:login";
        }else return "register";
    }

    @GetMapping(value = "register")
    public String  registerG (HttpServletRequest request){

        return "register";
    }

}
