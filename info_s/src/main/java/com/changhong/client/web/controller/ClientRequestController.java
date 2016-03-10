package com.changhong.client.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.changhong.client.domain.ResponseCode;
import com.changhong.client.service.ClientService;
import com.changhong.client.service.DataProcessService;
import com.changhong.common.utils.CHListUtils;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: pengjie
 * Date: 2016/3/7
 * Time: 17:00
 */
@Controller
public class ClientRequestController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private DataProcessService dataProcessService;

    @RequestMapping("/client/projectformat.html")
    public ModelAndView sendToProjectFormat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String projectCode = ServletRequestUtils.getStringParameter(request, "projectCode", "");

        String responseJSON = clientService.obtainProjectFormat(projectCode);

        //返回结果
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(responseJSON);
        writer.flush();
        writer.close();

        return null;
    }

    @RequestMapping("/client/infodataupload.html")
    public ModelAndView sendtoDataUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String content = ServletRequestUtils.getStringParameter(request, "content", "");
        String responseJSON = clientService.processInfoData(content);

        //返回结果
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(responseJSON);
        writer.flush();
        writer.close();
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        map.put("projectName", "test");
//        map.put("content", "test1");
//
//        dataProcessService.insertData(map);
//
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        list.add(map);
//        dataProcessService.insertData(list);

        return null;
    }
}
