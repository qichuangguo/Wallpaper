package com.android.cgcxy.wallpaper.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.view.WindowManager;

import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.io.File;
import java.io.FileOutputStream;

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

    public static String getCacheString(RequestQueue requestQueue,String url){
        Cache.Entry entry = requestQueue.getCache().get("0:"+url);
        String cachedResponse="";
        if (entry!=null){
            cachedResponse = new String(entry.data);
            return cachedResponse;

        }
        return null;
    }

    public static boolean seave(Bitmap bitmap,String name){

        try {
            String path = Environment.getExternalStorageDirectory().getPath()+File.separator+"酷爱";
            File file = new File(path);
            if (!file.exists()){
                file.mkdir();
                File file1 = new File(path+File.separator+name);
                FileOutputStream out = new FileOutputStream(file1);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.flush();
                out.close();
                return true;
            }else {
                File file1 = new File(path+File.separator+name);
                FileOutputStream out = new FileOutputStream(file1);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
                out.flush();
                out.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }


}
