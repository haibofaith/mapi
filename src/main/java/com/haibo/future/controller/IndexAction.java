package com.haibo.future.controller;

import com.haibo.future.model.MapiInfo;
import com.haibo.future.service.MapiService;
import com.haibo.future.util.CommonUtil;
import com.haibo.future.util.HttpHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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
        String result =mapiService.sendHttpRequest(mapiInfo);
        return new ResponseEntity<String>(result, HttpStatus.OK);
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

//    @ResponseBody
//    @RequestMapping(value = "/test/soa/testSoa")
//    public String testSoa(HttpServletRequest request){
//        String msg = "";
//        try {
//            msg = HttpHelper.httpReq("http://localhost:8080/test/hiSql");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return msg;
//    }

}
