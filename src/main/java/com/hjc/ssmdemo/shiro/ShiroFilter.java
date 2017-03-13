package com.hjc.ssmdemo.shiro;


import com.hjc.ssmdemo.persistence.entity.Role;
import com.hjc.ssmdemo.persistence.entity.SRole;
import com.hjc.ssmdemo.persistence.entity.SUser;
import com.hjc.ssmdemo.persistence.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;

/**
 * Created by Bravowhale on 2017/3/10.
 */
public class ShiroFilter implements Filter{
    private static final Logger logger = LoggerFactory.getLogger(ShiroFilter.class);
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("run into filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        Principal principal = request.getUserPrincipal();
        logger.info(request.getParameter("username"));
        logger.info("principal:"+(principal==null));
        logger.info("question:"+(SecurityUtils.getSubject() == null));
        if(principal != null){
            Subject subjects = SecurityUtils.getSubject();
            SUser user = new SUser();
            user.setUsername("admin");
            user.setPassword("111111");
            user.setsRole(new SRole("member"));
            if (user.getUsername().equals(principal.getName())) {
                UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user
                        .getPassword());
                subjects = SecurityUtils.getSubject();
                subjects.login(token);
                subjects.getSession();
            } else {
                // 如果用户为空，则subjects信息登出
                if (subjects != null) {
                    subjects.logout();
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    public void destroy() {

    }
}
