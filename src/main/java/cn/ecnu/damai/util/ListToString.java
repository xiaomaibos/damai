package cn.ecnu.damai.util;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.Collection;

public class ListToString {
    public static String listToString(ArrayList<String> list, String splitStr){
        if(list == null){
            return null;
        }
        else{
            StringBuffer buffer = new StringBuffer();
            int len = list.size();
            buffer.append(list.get(0));
            for (int i = 1; i < len; i++) {
                buffer.append(splitStr);
                buffer.append(list.get(i));
            }
            return buffer.toString();
        }
    }

    public static String listToString(JSONArray list, String splitStr){
        if(list == null){
            return null;
        }
        else{
            StringBuffer buffer = new StringBuffer();
            int len = list.size();
            buffer.append(list.get(0));
            for (int i = 1; i < len; i++) {
                buffer.append(splitStr);
                buffer.append(list.get(i));
            }
            return buffer.toString();
        }
    }

    public static String collectionToString(Collection<String> collection, String splitStr){
        return listToString(new ArrayList<>(collection), splitStr);
    }
}
