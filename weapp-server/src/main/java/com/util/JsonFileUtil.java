package com.util;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;


public class JsonFileUtil
{
    /**
     * 读取json文件，返回json串
     * @param fileName
     * @return
     */
    public static String read(String fileName) {
        String jsonStr = "";

        try {
            // 解决中文路径错误的问题
            String utf8Path = java.net.URLDecoder.decode(fileName,"utf-8");

            File jsonFile = new File(utf8Path);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
