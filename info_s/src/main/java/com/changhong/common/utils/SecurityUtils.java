package com.changhong.common.utils;

import com.changhong.system.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;

/**
 * User: Jack Wang
 * Date: 14-4-9
 * Time: 上午10:43
 */
public class SecurityUtils {

    public static boolean isAdminRole() {
        try {
            SecurityContext securityContent = SecurityContextHolder.getContext();
            Collection<GrantedAuthority> authorities = securityContent.getAuthentication().getAuthorities();
            GrantedAuthority authority = new ArrayList<GrantedAuthority>(authorities).get(0);
            return "ROLE_ADMIN".equals(authority.getAuthority());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static String currentAuthenticationRole() {
        try {
            SecurityContext securityContent = SecurityContextHolder.getContext();
            Collection<GrantedAuthority> authorities = securityContent.getAuthentication().getAuthorities();
            GrantedAuthority authority = new ArrayList<GrantedAuthority>(authorities).get(0);
            return authority.getAuthority();
        } catch (Exception e) {
            return null;
        }
    }

    public static User currentAuthentication() {
        try {
            SecurityContext securityContent = SecurityContextHolder.getContext();
            return (User) securityContent.getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }

    public static int currectAuthenticationId() {
        User user = currentAuthentication();
        if (user == null) return -1;
        return user.getId();
    }
}
