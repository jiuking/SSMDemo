package com.hjc.ssmdemo.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Bravowhale on 2017/3/13.
 */
public class ExtendFormAuthenticationFilter extends FormAuthenticationFilter{

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {


        return super.onAccessDenied(request, response);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return super.isAccessAllowed(request, response, mappedValue);
    }
}
