package com.leoncf.network.utils;

public class StrUtils {
    public static String dightFill(Integer num, Integer limit) {
        if(limit <= 0){
            System.out.println("Error");
            return null;
        }
        Integer digitNum = (num + "").length();
        StringBuilder prefix = new StringBuilder();
        int diff = limit - digitNum;
        if(0 < diff) {
            for(int i = 0; i < diff; i++){
                prefix.append("0");
            }
            return prefix.toString() + num;
        }else{
            return num + "";
        }

    }
}
