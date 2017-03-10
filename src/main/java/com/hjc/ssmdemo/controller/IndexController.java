package com.hjc.ssmdemo.controller;

import com.hjc.ssmdemo.persistence.entity.TUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Bravowhale on 2017/3/10.
 */
@Controller
@RequestMapping(value = "/*")
public class IndexController {

    public static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "")
    public String index(){
        logger.info("into index跳转到login");
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return "login";
//        return view;
    }
    @RequestMapping(value = "login")
    public String toIndex(HttpServletRequest request, Model model) {
        TUser user = new TUser();
        user.setUserName("测试111恭喜，翻山越岭，登录成功！");
        model.addAttribute("user", user);
        logger.info(user.getUserName());
        return "showUser";
    }
}
