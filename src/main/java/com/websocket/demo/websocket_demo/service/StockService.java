package com.websocket.demo.websocket_demo.service;

/**
 * @Author: Elvis
 * @Description:
 * @Date: 2020/2/12 10:21
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.websocket.demo.websocket_demo.utils.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口服务，调用股票行情接口
 */
public class StockService {

    public static Map<String, String> getStockInfo(){
        String host = "https://stock.api51.cn";
        String path = "/stock/";
        String method = "GET";
        String appcode = "748ffa05c4c54cf391ebe231b3b2bbab";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("en_prod_code", "000006.SZ");


        try{
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);

            JSONObject obj = JSONObject.parseObject(EntityUtils.toString(response.getEntity()));

            if(obj.containsKey("data")){
                JSONObject snapshotObj = obj.getJSONObject("data");

                if(snapshotObj.containsKey("snapshot")){
                    JSONArray szArray = snapshotObj.getJSONObject("snapshot").getJSONArray("000006.SZ");
                    JSONArray fields = snapshotObj.getJSONObject("snapshot").getJSONArray("fields");
                    Map<String, String> mapInfo = new HashMap<>();

                    for(int i = 0; i<szArray.size(); i++){
                        mapInfo.put(fields.getString(i),szArray.getString(i));
                    }
                    System.out.println(mapInfo);
                    return mapInfo;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
