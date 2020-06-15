//将List中元素存到一个字符串中的工具类

package com.tool;

import java.util.List;

public class ListToString {

    public static String ArrayListToString(List<String> list){

        if(list == null || list.size() ==0){
            return null;
        }

        boolean isFirst = true;

        StringBuffer result = new StringBuffer();

        for (String s : list) {
            if(isFirst){
                isFirst = false;
            }else {
                result.append(",");
            }
            result.append(s);
        }
        return result.toString();
    }
}
