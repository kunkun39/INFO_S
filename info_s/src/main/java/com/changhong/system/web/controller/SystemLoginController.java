package com.changhong.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Jack Wang
 * Date: 16-2-19
 * Time: 下午4:13
 */
@Controller
@RequestMapping("/system/login.html")
public class SystemLoginController {

    @RequestMapping
    public String sendToLoginPage(HttpServletRequest request) {
        return "system/login";
    }
}
