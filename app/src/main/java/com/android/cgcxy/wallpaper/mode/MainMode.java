package com.android.cgcxy.wallpaper.mode;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public interface MainMode {

    void getHomePageFragmnetDataJson(String url,RefreshListener refreshListener);
    void getClassifyFragmentJsonData(String url,RefreshListener refreshListener);
    void getSearchJsonData(String url,RefreshListener refreshListener);
}
