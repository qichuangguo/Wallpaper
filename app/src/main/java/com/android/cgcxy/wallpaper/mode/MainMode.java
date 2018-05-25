package com.android.cgcxy.wallpaper.mode;

import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;

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
    void getEveryDayJosnData(String url,RefreshListener refreshListener);
    void getEveryDaySubJosnData(String url,RefreshListener refreshListener);
    void getRankingDownLoadJsonData(String url,RefreshListener refreshListener);
    void getLuckGiveJsonData(String url,RefreshListener refreshListener);
    void getLabelSearchJsonData(String url,RefreshListener refreshListener);
    void getSearchInputJsonData(String url,RefreshListener refreshListener);
    void getTotalUrl(String url, RefreshListener refreshListener);
    void getNetWorkData(MainPresenterImple.RequestSource requestSource,String url, RefreshListener refreshListener);
}
