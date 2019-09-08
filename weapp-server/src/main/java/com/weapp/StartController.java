package com.weapp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import com.config.AppConfig;
import com.util.RequestUtil;
import com.util.JsonFileUtil;
import com.util.ResponseUtil;


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
        String result;

        try {
            Map<String, Object> paraMap = new HashMap<String, Object>();
            paraMap.put("appid", AppConfig.APP_ID);
            paraMap.put("secret", AppConfig.APP_SECRET);
            paraMap.put("js_code", js_code);
            paraMap.put("grant_type", "authorization_code");
            String paraString = RequestUtil.parametersFormat(paraMap);

            result = RequestUtil.get(url + paraString);
         } catch (Exception e) {
            result = "Error";
             e.printStackTrace();
             bizLogger.error("requestCode2Session Error", e);
         }
         return result;
    }

    // auth.getAccessToken
    @RequestMapping(value = "/getToken", method = RequestMethod.GET)
    @ResponseBody
    public String requestAccessToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token";
        String result;

        try {
            Map<String, Object> paraMap = new HashMap<String, Object>();
            paraMap.put("appid", AppConfig.APP_ID);
            paraMap.put("secret", AppConfig.APP_SECRET);
            paraMap.put("grant_type", "client_credential");
            String paraString = RequestUtil.parametersFormat(paraMap);

            result = RequestUtil.get(url + paraString);
         } catch (Exception e) {
            result = "Error";
             e.printStackTrace();
             bizLogger.error("requestCode2Session Error", e);
         }
         return result;
    }

    // 获取小程序二维码
    // wxacode.createQRCode

    // 获取数据分析



    // Custom Interface
    // 唐诗
    @RequestMapping(value = "/getTangList", method = RequestMethod.GET)
    public String getTangList(@RequestParam(value = "page") String page) {

        String resource = "json/tang/poet.tang." + page + "000.json";
        try {
            String path = getClass().getClassLoader().getResource(resource).getPath();
            String tang = JsonFileUtil.read(path);

            String result = ResponseUtil.jsonData(tang, true);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.data(null, false);
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

            String result = ResponseUtil.jsonData(song, true);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.data(null, false);
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

            String result = ResponseUtil.jsonData(lunyu, true);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.data(null, false);
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

            String result = ResponseUtil.jsonData(mengzi, true);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.data(null, false);
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

            String result = ResponseUtil.jsonData(shijing, true);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.data(null, false);
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

            String result = ResponseUtil.jsonData(daxue, true);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.data(null, false);
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

            String result = ResponseUtil.jsonData(zhongyong, true);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.data(null, false);
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

            String result = ResponseUtil.jsonData(dioimList, true);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            String result = ResponseUtil.data(null, false);
            return result;
        }
    }

}