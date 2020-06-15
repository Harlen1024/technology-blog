//通过访问api返回的json数据用于获取网页中的动态渲染部分

package com.reptile.json;

import com.tool.SplitJson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.tool.ListToString.ArrayListToString;

public class GetHttpInterface {

    // 调用http接口获取数据
    public static String GetHttpInterface(String path){

        BufferedReader in = null;
        StringBuffer result;

        try {
            URL url = new URL(path);
            //打开和url之间的连接
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Charset", "utf-8");
            connection.connect();

            result = new StringBuffer();
            //读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }
            return result.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        return null;

    }

    public static void main(String[] args){

        String a;

        SplitJson sj = new SplitJson();

        List<String> s = new ArrayList<String>();
        String str = GetHttpInterface("https://api.bilibili.com/x/web-interface/archive/stat?aid=" + 2);
        Pattern p = Pattern.compile("\\\"code\":\\-?\\d+");
        Matcher m = p.matcher(str);
        while(m.find()) {
            s.add(m.group());

        }

        System.out.println(str);
        System.out.println(str.substring(str.indexOf("{")+1, str.indexOf("}")));
//        System.out.println(str.substring(str.indexOf("=")+1, str.indexOf("&")));
        System.out.println(ArrayListToString(s));
        a=ArrayListToString(s);
//        System.out.println(a.substring(a.indexOf(":")+1));

        System.out.println(sj.splitCode(str));

    }
}
