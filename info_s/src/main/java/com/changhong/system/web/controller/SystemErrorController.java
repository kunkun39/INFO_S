package com.changhong.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: Jack Wang
 * Date: 16-2-23
 * Time: 上午9:07
 */
@Controller
@RequestMapping("/system/error.html")
public class SystemErrorController {

    @RequestMapping
    public String sendToError() {
        return "common/error";
    }
}
