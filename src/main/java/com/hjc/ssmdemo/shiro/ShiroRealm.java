package com.hjc.ssmdemo.shiro;

import com.hjc.ssmdemo.persistence.entity.Role;
import com.hjc.ssmdemo.persistence.entity.SRole;
import com.hjc.ssmdemo.persistence.entity.SUser;
import com.hjc.ssmdemo.persistence.entity.User;
import com.hjc.ssmdemo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bravowhale on 2017/3/9.
 */
public class ShiroRealm extends AuthorizingRealm{

    private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private UserService userService;
    /**
     * 授权
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("shiro授权");
        if (principalCollection == null){
            logger.info("principalCollection is null");
            throw new AuthorizationException("principalCollection method argument cannot be null");
        }
        String username = (String) getAvailablePrincipal(principalCollection);
        List<String> roles = new ArrayList<String>();
        // 简单默认一个用户与角色，实际项目应User user = userService.getByAccount(name);
        SUser user = new SUser("admin","111111");
        SRole role = new SRole("member");
        user.setsRole(role);
        if(user.getUsername().equals(username)){
            if(user.getsRole()!=null){
                roles.add(user.getsRole().getRolename());
            }
        }else{
            throw new AuthorizationException();
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        authorizationInfo.setRoles(userService.findRoles(username));
//        authorizationInfo.setStringPermissions(userService.findPermissions(username));
        authorizationInfo.addRoles(roles);
        return authorizationInfo;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("认证");
        String username = (String) token.getPrincipal();
       /* User user = userService.findByUsername(username);
        if(user == null){
            throw new UnknownAccountException();
        }
        if(Boolean.TRUE.equals(user.getLocked())){
            throw new LockedAccountException();
        }*/
        SUser user = new SUser("admin","111111");
        if(user == null){
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(
            user.getUsername(),
            user.getPassword(),
//            ByteSource.Util.bytes(user.getCredentialsSalt()),//salt = username + salt
                getName()
                );
    }
}
