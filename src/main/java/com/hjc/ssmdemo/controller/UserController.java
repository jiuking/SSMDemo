package com.hjc.ssmdemo.controller;

import com.hjc.ssmdemo.persistence.entity.TUser;
import com.hjc.ssmdemo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Bravowhale on 2017/3/9.
 */

@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private IUserService iuserService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        TUser user = iuserService.getUserById(userId);
        model.addAttribute("user", user);
        logger.info(user.getUserName());
        return "showUser";
    }
}
