package com.android.cgcxy.wallpaper.presenter;

import android.content.Context;
import android.util.Log;

import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.HomePageHeadBean;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
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

    public MainPresenterImple(ShowView showView, Context context){
        this.showView=showView;
        this.mContext=context;
        mainModeImple = new MainModeImple(context);
    }

    public void getHomePageFragmnetDataJson(){
        int[] screenDispaly = Utils.getScreenDispaly(mContext);
        String url = String.format(Constants.HOMEPAGEJSONURL,screenDispaly[0]+"",screenDispaly[1]+"");
        mainModeImple.getHomePageFragmnetDataJson(url, new RefreshListener() {
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

    public void getHomePageFragmentNextDatajson(){
        mainModeImple.getHomePageFragmnetDataJson(hompPagerBean.getLink().getNext(), new RefreshListener() {
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
        String url = String.format(Constants.CLASSIFYJSONURL,Utils.getScreenDispaly(mContext)[0],Utils.getScreenDispaly(mContext)[1]);
        mainModeImple.getClassifyFragmentJsonData(url, new RefreshListener() {
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
        String url = String.format(Constants.SEARCHJSONURL,Utils.getScreenDispaly(mContext)[0],Utils.getScreenDispaly(mContext)[1]);
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

    public void getHomePageNextHeadJsonData(){

        String url = headBean.getLink().getNext();
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

        String url = String.format(Constants.EVERYDAYURL,Utils.getScreenDispaly(mContext)[0],Utils.getScreenDispaly(mContext)[1]);
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
        String url = String.format(Constants.LUCKGIVEURL,Utils.getScreenDispaly(mContext)[0],Utils.getScreenDispaly(mContext)[1]);
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

}
