package com.android.cgcxy.wallpaper.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.WindowManager;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public class Utils {

    private static Utils utils;
    private RequestQueue requestQueue;

    public static Utils getUtils() {

        if (utils == null) {
            utils = new Utils();
        }

        return utils;
    }

    public RequestQueue getRequestQueue(Context context){

        if (requestQueue==null){
            requestQueue = Volley.newRequestQueue(context,1024*1024*1024);
        }

        return requestQueue;
    }

    public static int[] getScreenDispaly(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        //手机屏幕的宽度
        int width = wm.getDefaultDisplay().getWidth();
        //手机屏幕的高度
        int height = wm.getDefaultDisplay().getHeight();
        int result[] = { width, height };
        return result;
    }

    public static void saveSharedPreferences(Context context,String key,String ContentKey,String Content){
        SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        sp.edit().putString(ContentKey, Content).commit();
    }

    public static String getStringSharedPreferences(Context context,String key,String ContentKey){
        SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return sp.getString(ContentKey, null);
    }


}
