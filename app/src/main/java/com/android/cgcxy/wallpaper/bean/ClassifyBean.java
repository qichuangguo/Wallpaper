package com.android.cgcxy.wallpaper.bean;

import com.google.gson.reflect.TypeToken;

/**
 * Created by chuangguo.qi on 2017/7/19.
 */

public class ClassifyBean {


    /**
     * tid : 1
     * name : 影视明星
     * icon : http://s.qdcdn.com/cl/11328885,256,256.webp
     * url : http://api.lovebizhi.com/android_v3.php?a=category&spdy=1&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0&tid=1
     */

    private int tid;
    private String name;
    private String icon;
    private String url;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
