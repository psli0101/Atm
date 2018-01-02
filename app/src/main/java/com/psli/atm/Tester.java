package com.psli.atm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 2018/1/2.
 */

public class Tester {
    public static void main(String[] args) {
        Date now = new Date();
        System.out.println(now); // 取得時間
        System.out.println(now.getTime()); // 取得毫秒數
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 設定顯示格式
        System.out.println(sdf.format(now)); // 時間以sdf格式顯示

        // 轉換字串
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String date = "1998-01-01";
        try {
            Date brith = sdf2.parse(date);
            System.out.println(brith);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
