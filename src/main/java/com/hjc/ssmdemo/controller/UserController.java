package com.hjc.ssmdemo.controller;

import com.hjc.ssmdemo.persistence.entity.TUser;
import com.hjc.ssmdemo.service.IUserService;
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
    @Resource
    private IUserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        TUser user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "showUser";
    }
}
