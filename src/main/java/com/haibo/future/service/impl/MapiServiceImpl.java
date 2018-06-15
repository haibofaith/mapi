package com.haibo.future.service.impl;

import com.haibo.future.model.MapiInfo;
import com.haibo.future.service.MapiService;
import com.haibo.future.util.HttpHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Service
public class MapiServiceImpl implements MapiService{

    @Override
    public void validate(MapiInfo mapiInfo) {
        if (StringUtils.isEmpty(mapiInfo.getServiceName()) || StringUtils.isEmpty(mapiInfo.getProductName())
                || StringUtils.isEmpty(mapiInfo.getMethodName())) {
            throw new RuntimeException("serviceName, productName 或者 methodName 参数为空");
        }else {
            System.out.println("校验通过：mapiInfo.getServiceName()"+mapiInfo.getServiceName()+"mapiInfo.getProductName()"+mapiInfo.getProductName()+"mapiInfo.getMethodName()"+mapiInfo.getMethodName());
        }
    }

    @Override
    public String sendHttpRequest(MapiInfo mapiInfo) {
        validate(mapiInfo);
        String response = process(mapiInfo);
        return response;
    }

    private String process(MapiInfo mapiInfo) {
        String msg = "";
        if (mapiInfo.getServiceName().equals("test")){
            try {
                msg = HttpHelper.httpReq("http://localhost:8080/test/hiSql");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return msg;
    }
}
