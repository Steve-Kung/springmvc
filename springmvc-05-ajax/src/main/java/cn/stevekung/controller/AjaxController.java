package cn.stevekung.controller;

import cn.stevekung.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
public class AjaxController {
    @RequestMapping("/ajax")
    public List<User> ajax(String name){
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(1L, "steve",new Date()));
        users.add(new User(2L, "gj",new Date()));
        users.add(new User(3L, "jg",new Date()));
        users.add(new User(4L, "你好呀",new Date()));
        return users;
    }

    @RequestMapping("/myname")
    public String myname(String myname, String mypassword){
        String msg = "";
        if (myname != null){
//            root等数据应该在数据库查询获取
            if ("root".equals(myname)){
                msg = "ok";
            } else {
                msg = "用户名不存在";
            }
        }
        if (mypassword != null){
            if ("admin".equals(mypassword)){
                msg = "ok";
            } else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
