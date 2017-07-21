package com.android.cgcxy.wallpaper.mode;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public interface MainMode {

    void getHomePageFragmnetDataJson(String url,RefreshListener refreshListener,boolean isCache);
    void getClassifyFragmentJsonData(String url,RefreshListener refreshListener);
    void getSearchJsonData(String url,RefreshListener refreshListener,boolean isCache);
    void getHomePageHeadJsonData(String url,RefreshListener refreshListener);
    void getClassifySubJsonData(String url,RefreshListener refreshListener);
    void getClassifyNestSubJsonData(String url,RefreshListener refreshListener);
    void getClassifyChildishSubJsonData(String url,RefreshListener refreshListener);
    void getSpeCialJsonData(String url,RefreshListener refreshListener);
}
