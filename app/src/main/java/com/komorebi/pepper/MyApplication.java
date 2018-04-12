package com.komorebi.pepper;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by Komorebi on 2018/4/12.
 */

public class MyApplication extends Application {

    public static String token = "";
    public static String sno = "", jwcPwd = "", ePwd = "",name="";


    @Override
    public void onCreate() {
        SharedPreferences userInfo = getApplicationContext().getSharedPreferences("userInfo", MODE_PRIVATE);
        if (userInfo.getString("sno", "").length() != 0) {
            sno = userInfo.getString("sno", "");
            jwcPwd = userInfo.getString("jwcPwd", "");
            ePwd = userInfo.getString("ePwd", "");
            name= userInfo.getString("name", "");
        }

        super.onCreate();
    }


    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        MyApplication.token = token;
    }
}
