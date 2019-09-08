package com.util;

import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.awt.List;
import java.io.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ResponseUtil
{
    public static String data(Object data, Boolean isSuccess) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", data == null ? "" : data);
        resultMap.put("isSuccess", isSuccess);
        resultMap.put("statusCode", isSuccess ? "10000" : "未定义");

        String result = JSON.toJSONString(resultMap);
        return result;
    }

    public static String jsonData(String json, Boolean isSuccess) {

        Object jsonObjc = null;
        if (json != null) {
            jsonObjc = JSON.parse(json);
        } 

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", json == null ? "" : jsonObjc);
        resultMap.put("isSuccess", isSuccess);
        resultMap.put("statusCode", isSuccess ? "10000" : "未定义");

        String result = JSON.toJSONString(resultMap);
        return result;
    }
}