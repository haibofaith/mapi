package com.haibo.future.service;

import com.haibo.future.model.MapiInfo;

public interface MapiService {
    //验证
    void validate(MapiInfo mapiInfo);
    //发送请求
    byte[] sendHttpRequest(MapiInfo mapiInfo);
}
