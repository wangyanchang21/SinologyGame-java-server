package com.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import com.util.StatusCode;

public class ResponseUtil
{

    public static String success() {
        String result = success(null);
        return result;
    }

    public static String success(Object data) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", null == data ? "" : data);
        resultMap.put("isSuccess", true);
        resultMap.put("statusCode", StatusCode.SUCCESS);

        String result = JSON.toJSONString(resultMap);
        return result;
    }

    public static String successJSON(String json) {

        Object jsonObjc = null;
        if (json != null) {
            jsonObjc = JSON.parse(json);
        }

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", null == json ? "" : jsonObjc);
        resultMap.put("isSuccess", true);
        resultMap.put("statusCode", StatusCode.SUCCESS);

        String result = JSON.toJSONString(resultMap);
        return result;
    }

    public static String error(String errorCode) {
        String result = error(null, errorCode);
        return result;
    }

    public static String error(Object errorData, String errorCode) {

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("data", null == errorData ? "" : errorData);
        resultMap.put("isSuccess", false);
        resultMap.put("statusCode", errorCode);

        String result = JSON.toJSONString(resultMap);
        return result;
    }
}