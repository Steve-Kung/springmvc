package cn.stevekung.controller;

import cn.stevekung.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/goLoginPage")
    public String goLoginPage(){
        return "login";
    }
    @RequestMapping("/goMainPage")
    public String goMainPage(){
        return "main";
    }

    @RequestMapping("/login")
    public String login(User user, HttpSession session, Model model){
        model.addAttribute("username", user.getUsername());
        session.setAttribute("userInfo", user.getUsername());
        return "main";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
//        一个打开的浏览器对应一个Session
//        session.invalidate();
        session.removeAttribute("userInfo");
        return "login";
    }
}
