package com.haibo.future.service.impl;

import com.haibo.future.model.MapiInfo;
import com.haibo.future.service.MapiService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public byte[] sendHttpRequest(MapiInfo mapiInfo) {
        validate(mapiInfo);
        return new byte[0];
    }
}
