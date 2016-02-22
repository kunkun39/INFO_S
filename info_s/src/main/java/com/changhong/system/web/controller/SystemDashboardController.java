package com.changhong.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * User: Jack Wang
 * Date: 16-2-19
 * Time: 下午5:37
 */
@Controller
@RequestMapping("/system/dashboard.html")
public class SystemDashboardController {

    @RequestMapping
    public String sendToDashboardPage(HttpServletRequest request) {
        return "system/dashboard";
    }
}
