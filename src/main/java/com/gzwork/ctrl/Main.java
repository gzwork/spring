package com.gzwork.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Gzwork
 */
@Controller
public class Main {

    /**
     * web主页
     * @return
     */
    @RequestMapping(path = "/",method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("jsp_home");
        return modelAndView;
    }

    /**
     * 用户登录页面
     * @return
     */
    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("fm_login");
        return modelAndView;
    }
}
