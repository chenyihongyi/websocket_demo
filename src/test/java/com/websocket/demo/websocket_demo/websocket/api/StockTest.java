package com.websocket.demo.websocket_demo.websocket.api;

import com.websocket.demo.websocket_demo.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/12 8:01
 */
public class StockTest {

    @Test
    public void testStock(){
        String host = "https: //stock.api51.cn";
        String path = "/stock/";
        String method = "GET";
        String appcode = "你自己的AppCode";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE" + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("en_prod+code", "000001.SZ");

        try{
            HttpResponse response = HttpUtils.doGet(host,path, method, headers, querys);
            System.out.println(response.toString());
            System.out.println(EntityUtils.toString(response.getEntity()));
        }catch (Exception e){
            e.printStackTrace();
        }

















    }
}
