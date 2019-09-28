package com.weapp.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.Lang;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.config.AppConfig;
import com.util.RequestUtil;
import com.util.JsonFileUtil;
import com.util.ResponseUtil;
import com.util.StatusCode;
import com.weapp.dto.User;


 @RestController
 public class StartController {
    private static final Logger bizLogger = LoggerFactory.getLogger(StartController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello word!";
    }

    // Wechat Server API Interface
    // auth.code2Session
    @RequestMapping(value = "/getSession", method = RequestMethod.GET)
    @ResponseBody
    public String requestCode2Session(@RequestParam(value = "code") String js_code) {
        String url = "https://api.weixin.qq.com/sns/jscode2session";

        try {
            Map<String, Object> paraMap = new HashMap<String, Object>();
            paraMap.put("appid", AppConfig.APP_ID);
            paraMap.put("secret", AppConfig.APP_SECRET);
            paraMap.put("js_code", js_code);
            paraMap.put("grant_type", "authorization_code");
            String paraString = RequestUtil.parametersFormat(paraMap);

            String json = RequestUtil.get(url + paraString);
            String result = ResponseUtil.successJSON(json);
            return result;
         } catch (Exception e) {
            bizLogger.error("requestCode2Session Error", e);
            String result = ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            return result;
         }
    }

    // auth.getAccessToken
    @RequestMapping(value = "/getToken", method = RequestMethod.GET)
    @ResponseBody
    public String requestAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token";

        try {
            Map<String, Object> paraMap = new HashMap<String, Object>();
            paraMap.put("appid", AppConfig.APP_ID);
            paraMap.put("secret", AppConfig.APP_SECRET);
            paraMap.put("grant_type", "client_credential");
            String paraString = RequestUtil.parametersFormat(paraMap);

            String json = RequestUtil.get(url + paraString);
            String result = ResponseUtil.successJSON(json);
             System.out.println(result);
            return result;
         } catch (Exception e) {
            bizLogger.error("requestCode2Session Error", e);
            String result = ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            return result;
         }
    }

    // User System
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(User user) {

        return "";
    }

    @RequestMapping(value = "/getUserRankList", method = RequestMethod.GET)
    public String getUserRankList() {

        return "";
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public String getUserInfo(Lang openId) {

        return "";
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.GET)
    public String updateUserInfo(User user) {

        return "";
    }


    // Custom Interface
    // 唐诗
    @RequestMapping(value = "/getTangList", method = RequestMethod.GET)
    public String getTangList(@RequestParam(value = "page") String page) {

        String resource = "json/tang/poet.tang." + page + "000.json";
        try {
            String path = getClass().getClassLoader().getResource(resource).getPath();
            String tang = JsonFileUtil.read(path);

            String result = ResponseUtil.successJSON(tang);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            return result;
        }
    }

    // 宋词
    @RequestMapping(value = "/getSongList", method = RequestMethod.GET)
    public String getSongList(@RequestParam(value = "page") String page) {

        String resource = "json/song/ci.song." + page + "000.json";
        try {
            String path = getClass().getClassLoader().getResource(resource).getPath();
            String song = JsonFileUtil.read(path);

            String result = ResponseUtil.successJSON(song);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            return result;
        }
    }

    // 论语
    @RequestMapping(value = "/getLunyuList", method = RequestMethod.GET)
    public String getLunyuList(@RequestParam(value = "page") String page) {

        String resource = "json/siwu/lunyu.json";
        try {
            String path = getClass().getClassLoader().getResource(resource).getPath();
            String lunyu = JsonFileUtil.read(path);

            String result = ResponseUtil.successJSON(lunyu);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            return result;
        }
    }
    
    // 孟子
    @RequestMapping(value = "/getMengziList", method = RequestMethod.GET)
    public String getMengziList(@RequestParam(value = "page") String page) {

        String resource = "json/siwu/mengzi.json";
        try {
            String path = getClass().getClassLoader().getResource(resource).getPath();
            String mengzi = JsonFileUtil.read(path);

            String result = ResponseUtil.successJSON(mengzi);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            return result;
        }
    }

    // 诗经
    @RequestMapping(value = "/getShijingList", method = RequestMethod.GET)
    public String getShijingList(@RequestParam(value = "page") String page) {

        String resource = "json/siwu/shijing.json";
        try {
            String path = getClass().getClassLoader().getResource(resource).getPath();
            String shijing = JsonFileUtil.read(path);

            String result = ResponseUtil.successJSON(shijing);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            return result;
        }
    }
      
    // 大学
    @RequestMapping(value = "/getDaxue", method = RequestMethod.GET)
    public String getDaxue() {

        String resource = "json/siwu/daxue.json";
        try {
            String path = getClass().getClassLoader().getResource(resource).getPath();
            String daxue = JsonFileUtil.read(path);

            String result = ResponseUtil.successJSON(daxue);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            return result;
        }
    }
   
    // 中庸
    @RequestMapping(value = "/getZhongyong", method = RequestMethod.GET)
    public String getZhongyong() {

        String resource = "json/siwu/zhongyong.json";
        try {
            String path = getClass().getClassLoader().getResource(resource).getPath();
            String zhongyong = JsonFileUtil.read(path);

            String result = ResponseUtil.successJSON(zhongyong);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            return result;
        }
    }

    // 成语
    @RequestMapping(value = "/getIdiomList", method = RequestMethod.GET)
    public String getIdiomList() {

        // String resource = "json/idiom/idiom.json";
        String resource = "json/idiom/idiomlist.json";
        try {
            String path = getClass().getClassLoader().getResource(resource).getPath();
            String dioimList = JsonFileUtil.read(path);

            String result = ResponseUtil.successJSON(dioimList);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.error(e.getMessage(), StatusCode.COMMON_ERROR);
            return result;
        }
    }

}