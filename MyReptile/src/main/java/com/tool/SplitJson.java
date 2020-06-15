//从对应api获得的json数据中获取字符串

package com.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.reptile.json.GetHttpInterface.GetHttpInterface;
import static com.tool.ListToString.ArrayListToString;

public class SplitJson {


    //code获取用于判断空页面404
    public String splitCode(String str)
    {
        String temp;
        List<String> s = new ArrayList<String>();
        Pattern p = Pattern.compile("\\\"code\":\\-?\\d+");
        Matcher m = p.matcher(str);
        while(m.find()) {
            s.add(m.group());

        }
        temp = ArrayListToString(s);
        return temp.substring(temp.indexOf(":")+1);
    }

    //观看数
    public String splitView(String str)
    {
        String temp;
        List<String> s = new ArrayList<String>();
        Pattern p = Pattern.compile("\\\"view\":\\d+");
        Matcher m = p.matcher(str);
        while(m.find()) {
            s.add(m.group());

        }
        temp = ArrayListToString(s);
        return temp.substring(temp.indexOf(":")+1);
    }

    //弹幕数
    public String splitDanmaku(String str)
    {
        String temp;
        List<String> s = new ArrayList<String>();
        Pattern p = Pattern.compile("\\\"danmaku\":\\d+");
        Matcher m = p.matcher(str);
        while(m.find()) {
            s.add(m.group());

        }
        temp = ArrayListToString(s);
        return temp.substring(temp.indexOf(":")+1);
    }

}
