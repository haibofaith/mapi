package com.haibo.future.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHelper {
    public static String httpReq(String url) throws IOException {
        // 利用string url构建URL对象
        HttpURLConnection conn;
        URL mURL = new URL(url);
        conn = (HttpURLConnection) mURL.openConnection();
        conn.setRequestMethod("GET");
        conn.setReadTimeout(5000);
        conn.setConnectTimeout(10000);
        int responseCode = conn.getResponseCode();
        String msg = "";
        if (responseCode == 200) {
            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = reader.readLine()) != null) { // 循环从流中读取
                msg += line + "\n";
            }
            reader.close();
            is.close();
        }
        conn.disconnect();
        return msg;
    }
}
