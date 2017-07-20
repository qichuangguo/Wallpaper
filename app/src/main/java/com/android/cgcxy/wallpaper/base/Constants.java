package com.android.cgcxy.wallpaper.base;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public interface Constants {

     String HOMEPAGEJSONURL="http://api.lovebizhi.com/android_v3.php?a=home&spdy=1&device="+android.os.Build.BRAND+""+android.os.Build.MODEL+"&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=%s&screen_height=%s&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0&p=%s";

     String CLASSIFYJSONURL="http://api.lovebizhi.com/android_v3.php?a=browse&id=category&spdy=1&device="+android.os.Build.BRAND+""+android.os.Build.MODEL+"&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=%s&screen_height=%s&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0";

     String SEARCHJSONURL="http://api.lovebizhi.com/android_v3.php?a=hotword&spdy=1&device="+android.os.Build.BRAND+""+android.os.Build.MODEL+"&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=%s&screen_height=%s&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0";

     String INPUTSERACHJSONURL="http://api.lovebizhi.com/android_v3.php?a=search2&kw=%s&spdy=1&device="+android.os.Build.BRAND+""+android.os.Build.MODEL+"&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0";

     String HOMESHAREKEY="HomePager";
}
