package com.changhong.system.web.paging;

import com.changhong.system.domain.User;
import com.changhong.system.service.UserService;

import java.util.List;

/**
 * User:wangxiufeng
 * Date:2016/3/14
 * Time:11:24
 */
public class UserManagePaging extends  AbstractPaging<User> {

    private UserService userService;


    public UserManagePaging(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getItems() {
        setPageSize(5);
        return  userService.loadAnyUsers(getStartPosition(), getPageSize());
    }

    @Override
    public long getTotalItemSize() {
        return userService.loadAllUsers().size();
    }

    @Override
    public String getParameterValues() {
        return "";
    }
}
