package com.hjc.ssmdemo.controller;

import com.hjc.ssmdemo.persistence.entity.SRole;
import com.hjc.ssmdemo.persistence.entity.SUser;
import com.hjc.ssmdemo.persistence.entity.TUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
    public String toIndex(String username, String pwd,Model model) {
        logger.info("------------------login-----------");
        TUser user1 = new TUser();
        user1.setUserName("测试111恭喜，翻山越岭，登录成功！");
        model.addAttribute("user", user1);
        logger.info(user1.getUserName());

        SUser user = new SUser("admin", "111111");
        user.setsRole(new SRole("member"));
        // 如果登陆成功
        if (user.getUsername().equals(username) && user.getPassword().equals(pwd)) {
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user
                .getPassword().toString());
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            return "showUser";
        }
        return "redirect:index";
    }
}
