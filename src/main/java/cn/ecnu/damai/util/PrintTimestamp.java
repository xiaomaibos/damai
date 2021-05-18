package cn.ecnu.damai.util;

import java.sql.Timestamp;

public class PrintTimestamp {
    public static String printToSecond(Timestamp timestamp){
        try{
            return timestamp
                    .toString()
                    .substring(0, timestamp.toString().indexOf("."));
        }
        catch (Exception e){
            return null;
        }
    }
}
