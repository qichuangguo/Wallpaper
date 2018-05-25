package com.android.cgcxy.wallpaper.presenter;

import android.content.Context;
import android.util.Log;

import com.android.cgcxy.wallpaper.base.BaseActivity;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.HomePageHeadBean;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.android.cgcxy.wallpaper.bean.RankingBean;
import com.android.cgcxy.wallpaper.mode.MainMode;
import com.android.cgcxy.wallpaper.mode.MainModeImple;
import com.android.cgcxy.wallpaper.mode.RefreshListener;
import com.android.cgcxy.wallpaper.ui.ShowView;
import com.android.cgcxy.wallpaper.utils.JsonUtils;
import com.android.cgcxy.wallpaper.utils.Utils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.annotations.Until;

import org.json.JSONObject;

import java.io.Serializable;
import java.net.URL;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public class MainPresenterImple implements MainPresenter,Serializable{

    public static final String TAG ="MainPresenterImple" ;
    private ShowView showView;
    private Context mContext;
    private HompPagerBean hompPagerBean;
    private final MainModeImple mainModeImple;
    private HomePageHeadBean headBean;
    public enum RequestSource{
        LandscapeWallpaper
    }



    public MainPresenterImple(ShowView showView, Context context){
        this.showView=showView;
        this.mContext=context;
        mainModeImple = new MainModeImple(context);
    }

    public void getHomePageFragmnetDataJson(){

        mainModeImple.getHomePageFragmnetDataJson(Constants.HomePage, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                MainPresenterImple.this.hompPagerBean= (HompPagerBean) t;
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        },true);
    }

    public void getHomePageFragmentNextDatajson(int index){
        String url = Constants.HomePage+String.format(Constants.HomePageParameter,index*30,Utils.getUUid(mContext));
        mainModeImple.getHomePageFragmnetDataJson(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                MainPresenterImple.this.hompPagerBean= (HompPagerBean) t;
                showView.setNextData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        },false);

    }

    public void getClassifyFragmnetDatajson(){

        mainModeImple.getClassifyFragmentJsonData(Constants.categoryUrl, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }

    public void getSearchJsonData(boolean isCache){
        //String url = String.format(Constants.SEARCHJSONURL,Utils.getScreenDispaly(mContext)[0],Utils.getScreenDispaly(mContext)[1]);
        String url = ((BaseActivity)mContext).getTotalBean().getTag().getCloud();
        mainModeImple.getSearchJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        },isCache);
    }

    public void getHomePageHeadJsonData(String url){

        mainModeImple.getHomePageHeadJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                headBean = (HomePageHeadBean) t;
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }

    public void getHomePageNextHeadJsonData(String url){

        mainModeImple.getHomePageHeadJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                headBean = (HomePageHeadBean) t;
                showView.setNextData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });

    }

    public void getClassifySubJsonData(String url){

        mainModeImple.getClassifySubJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
                Log.i(TAG, "resultListener: ");
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }

    public void getClassifySubHotJsonData(String url){

        mainModeImple.getClassifySubJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }


    public void getClassifyNestSubJsonData(String url){
        mainModeImple.getClassifyNestSubJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
               showView.setNextData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }

    public void getClassifyChildishSubJsonData(String url){

        mainModeImple.getClassifyChildishSubJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }

    public void getClassifyChildishSubNextJsonData(String url){

        mainModeImple.getClassifyChildishSubJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setNextData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }

    public void getNetworkBeanData(RequestSource requestSource,String url){
        mainModeImple.getNetWorkData(requestSource, url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }

    public void getNextNetworkBeanData(RequestSource requestSource,String url){
        mainModeImple.getNetWorkData(requestSource, url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setNextData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }



    public void getSpeCialJsonData(String url){

        mainModeImple.getSpeCialJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });

    }

    public void getEveryDayJosnData(){

        //String url = String.format(Constants.EVERYDAYURL,Utils.getScreenDispaly(mContext)[0],Utils.getScreenDispaly(mContext)[1]);
       String url = ((BaseActivity)mContext).getTotalBean().getBrowse().get(1).getApi();
        mainModeImple.getEveryDayJosnData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });

    }

    public void getEveryDaySubJosnData(String url){

        mainModeImple.getEveryDaySubJosnData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }

    public void getRankingDownLoadJsonData(String url){
        mainModeImple.getRankingDownLoadJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }

    public void getLuckGiveJsonData(){
        //String url = String.format(Constants.LUCKGIVEURL,Utils.getScreenDispaly(mContext)[0],Utils.getScreenDispaly(mContext)[1]);
        String url = ((BaseActivity)mContext).getTotalBean().getTryluck();
        mainModeImple.getLuckGiveJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });

    }

    public void getLabelSearchJsonData(String url){

        mainModeImple.getLabelSearchJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }

    public void getSearchInputJsonData(String url){
        mainModeImple.getSearchInputJsonData(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
    }

    public void getTotalUrl(String url){

        mainModeImple.getTotalUrl(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });


    }

}
