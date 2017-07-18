package com.android.cgcxy.wallpaper.utils;

import android.content.Context;
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
            requestQueue = Volley.newRequestQueue(context);
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


}
