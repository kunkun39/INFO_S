package com.changhong.client.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.changhong.client.domain.ResponseCode;
import com.changhong.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: pengjie
 * Date: 2016/3/7
 * Time: 17:00
 */
@Controller
public class ClientRequestController {

    @Autowired
    private ClientService clientService;


}
