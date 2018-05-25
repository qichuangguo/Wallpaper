package com.android.cgcxy.wallpaper.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.Toast;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.BaseActivity;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

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
        boolean navigationBarShow = isNavigationBarShow(context);
        if (navigationBarShow){
            height=height+getNavigationBarHeight(context);
        }
        int result[] = { width, height };
        return result;
    }



    public static int getNavigationBarHeight(Context activity) {
        Resources resources = activity.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height","dimen", "android");
        //获取NavigationBar的高度
        int height = resources.getDimensionPixelSize(resourceId);
        return height;
    }

    public static boolean isNavigationBarShow(Context context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Display display = ((BaseActivity)context).getWindowManager().getDefaultDisplay();
            Point size = new Point();
            Point realSize = new Point();
            display.getSize(size);
            display.getRealSize(realSize);
            return realSize.y!=size.y;
        }else {
            boolean menu = ViewConfiguration.get(context).hasPermanentMenuKey();
            boolean back = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);
            if(menu || back) {
                return false;
            }else {
                return true;
            }
        }
    }


    public static void saveSharedPreferences(Context context,String key,String ContentKey,String Content){
        SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        sp.edit().putString(ContentKey, Content).commit();
    }

    public static String getStringSharedPreferences(Context context,String key,String ContentKey){
        SharedPreferences sp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return sp.getString(ContentKey, null);
    }

    public static boolean setObjectToShare(Context context, Object object,
                                       String key) {
// TODO Auto-generated method stub
        SharedPreferences share = PreferenceManager
                .getDefaultSharedPreferences(context);
        if (object == null) {
            SharedPreferences.Editor editor = share.edit().remove(key);
            return editor.commit();
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
       // 将对象放到OutputStream中
       // 将对象转换成byte数组，并将其进行base64编码
        String objectStr = new String(Base64.encode(baos.toByteArray(),
                Base64.DEFAULT));
        try {
            baos.close();
            oos.close();
        } catch (IOException e) {
       // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SharedPreferences.Editor editor = share.edit();
        // 将编码后的字符串写到base64.xml文件中
        editor.putString(key, objectStr);
        return editor.commit();
    }

    public static Object getObjectFromShare(Context context, String key) {
        SharedPreferences sharePre = PreferenceManager
                .getDefaultSharedPreferences(context);
        try {
            String wordBase64 = sharePre.getString(key, "");
             // 将base64格式字符串还原成byte数组
            if (wordBase64 == null || wordBase64.equals("")) { // 不可少，否则在下面会报java.io.StreamCorruptedException
                return null;
            }
            byte[] objBytes = Base64.decode(wordBase64.getBytes(),
                    Base64.DEFAULT);
            ByteArrayInputStream bais = new ByteArrayInputStream(objBytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
           // 将byte数组转换成product对象
            Object obj = ois.readObject();
            bais.close();
            ois.close();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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

    public static String getUUid(Context context){

        final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        final String tmDevice, tmSerial, tmPhone, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
        return deviceUuid.toString().replaceAll("-","");
    }

    public static String getDeviceId(Context context){
        final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        final String tmDevice;
        tmDevice = "" + tm.getDeviceId();
        return tmDevice;
    }

    public static String GetNetworkType(Context context) {
        String strNetworkType = "";

        ConnectivityManager systemService = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = systemService.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            if (networkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                strNetworkType = "WIFI";
            } else {
                strNetworkType = "4G";
            }
        }
        return strNetworkType;
    }

    public static void Toast(Context context,String str){
        Toast.makeText(context, str,Toast.LENGTH_SHORT).show();
    }

    public static String getFilePathFromContentUri(Uri uri, Context context) {
        String filePath;
        String[] filePathColumn = {MediaStore.MediaColumns.DATA};
        Cursor cursor = context.getContentResolver().query(uri, filePathColumn, null, null, null);
        if (cursor == null) return null;
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        filePath = cursor.getString(columnIndex);
        cursor.close();
        return filePath;
    }


    public static String  bitMapUrlSplice(Context mContent, String img, String rule, int width, int height) {
        if (!TextUtils.isEmpty(rule)) {
            return img + rule.replaceAll("\\$<Width>", width + "").replaceAll("\\$<Height>", height + "");
        }else {
            return img;
        }
    }

    public static String  bitMapUrlSplice(Context mContent, String img, String rule) {
        if (!TextUtils.isEmpty(rule)) {
            return img + rule.replaceAll("\\$<Width>", Utils.getScreenDispaly(mContent)[0] + "").replaceAll("\\$<Height>", Utils.getScreenDispaly(mContent)[1] + "");
        }else {
            return img;
        }
    }
}
