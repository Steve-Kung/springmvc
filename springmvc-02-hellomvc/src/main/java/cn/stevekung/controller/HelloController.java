package cn.stevekung.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        // 模型和视图
        ModelAndView mv = new ModelAndView();
        // 封装对象放入mv中
        mv.addObject("msg","hello spring mvc!");
        // 封装跳转视图放入mv中
        mv.setViewName("hello"); // /WEB-INF/jsp/hello.jsp

        return mv;
    }
}