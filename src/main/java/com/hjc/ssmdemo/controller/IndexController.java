package com.hjc.ssmdemo.controller;

import com.hjc.ssmdemo.persistence.entity.SRole;
import com.hjc.ssmdemo.persistence.entity.SUser;
import com.hjc.ssmdemo.persistence.entity.TUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
    @ResponseBody
    @RequestMapping(value = "login")
    public Map toIndex(String username, String pwd, Model model) {
        logger.info("------------------login-----------");
        TUser user1 = new TUser();
        user1.setUserName("测试111恭喜，翻山越岭，登录成功！");
        model.addAttribute("user", user1);
        logger.info(user1.getUserName());
        logger.info(username);
        logger.debug(pwd);

        SUser user = new SUser("admin", "111111");
        user.setsRole(new SRole("member"));
        // 如果登陆成功
//        if (user.getUsername().equals(username) && user.getPassword().equals(pwd)) {
//            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user
//                .getPassword().toString());
        Map<String,String> result = new HashMap<String, String>();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, pwd);
            Subject subject = SecurityUtils.getSubject();
            //if(subject == null ||subject.getPrincipal() == null|| !subject.isAuthenticated()) {感觉没必要，登录时踢人因换个地方判断

//            if(!subject.isAuthenticated()) {
                subject.login(token);
                result.put("message", "登录成功");
                result.put("status", "S");
                return result;
           /* }else{//多地点登录
                result.put("message","账号另地方登录");
                result.put("status","F");
                return result;
            }*/
            /*}else{//重复登录
//                SUser suser = (SUser) subject.getPrincipal();
                result.put("message","重复登录");
                result.put("status","F");
                return result;
            }*/
        }catch (IncorrectCredentialsException e) {
            result.put("message","密码错误");
            result.put("status","F");
            return result;
        }catch(UnknownAccountException e) {
            result.put("message","账号不存在");
            result.put("status","F");
            return result;
        }catch (LockedAccountException e) {
            result.put("message","账号被锁定");
            result.put("status","S");
            return result;
        } catch (Exception e){
            result.put("message","未知错误");
            result.put("status","S");
            return result;
        }
//        return "redirect:index";
    }

    @RequestMapping(value = "/success")
    public String success(){
        logger.info("登录成功");
        return "index";
//        return view;
    }

    @ResponseBody
    @RequestMapping(value = "/logout")
    public Map logout(){
        logger.info("退出");
        Map<String,String> result = new HashMap<String,String>();

        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        result.put("status","S");
        result.put("message","退出成功");
        return result;
    }
}
