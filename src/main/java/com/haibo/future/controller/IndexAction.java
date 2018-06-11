package com.haibo.future.controller;

import com.haibo.future.model.MapiInfo;
import com.haibo.future.service.MapiService;
import com.haibo.future.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class IndexAction{

    @Autowired
    private MapiService mapiService;

    /**
     * 简单的请求转发
     * @param request 请求对象
     * @return 返回结果
     */
    @ResponseBody
    @RequestMapping(value = "/{productName}/{serviceName}")
    public Object index(HttpServletRequest request) {
        // 根据http请求信息初始化Mapi业务信息
        MapiInfo mapiInfo = initMapiContext(request);
        byte[] result =mapiService.sendHttpRequest(mapiInfo);
        return new ResponseEntity<byte[]>(result, HttpStatus.OK);
    }

    private MapiInfo initMapiContext(HttpServletRequest request) {
        System.out.println("------看看数据");
        MapiInfo mapiInfo = new MapiInfo();
        // 从URL中解析出productName和serviceName
        String requestUrl = request.getRequestURI();
        String[] urlList = CommonUtil.parseUrl(requestUrl);
        // 设置SOA坐标参数
        if (urlList.length >= 2) {
            System.out.println("------"+urlList[0]+"-----"+urlList[1]);
            mapiInfo.setServiceName(urlList[0]);
            mapiInfo.setProductName(urlList[1]);
        }
        mapiInfo.setMethodName(request.getParameter("action"));
        return mapiInfo;
    }



}
