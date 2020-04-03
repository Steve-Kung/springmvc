package cn.stevekung.controller;

import cn.stevekung.pojo.User;
import cn.stevekung.utils.JsonUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/springmvc")
public class UserController {
    @GetMapping("/mapping")
    public String getMapping(@RequestParam("username") String username, Model model){
        System.out.println(username);
        model.addAttribute("msg", username);
        return "home";

    }

//    @PostMapping(value = "/mapping", produces = "application/json;charset=utf-8")
    @PostMapping("/mapping")
    @ResponseBody
    public String postMapper(User user) throws JsonProcessingException, ParseException {
        System.out.println(user);
//        user.setGmtCreate(new Date());
//        String str = JSON.toJSONString(user);
        String gmtCreate = user.getGmtCreate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date time = sdf.parse(gmtCreate);
        System.out.println(time);
        String json = JsonUtil.getJson(user);
        return json;
    }
}
