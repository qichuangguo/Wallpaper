package com.android.cgcxy.wallpaper.mode;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.ClassifyBean;
import com.android.cgcxy.wallpaper.bean.ClassifyChildiSubBean;
import com.android.cgcxy.wallpaper.bean.ClassifySubBean;
import com.android.cgcxy.wallpaper.bean.HomePageHeadBean;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.android.cgcxy.wallpaper.bean.SearchBean;
import com.android.cgcxy.wallpaper.bean.SpeCialBean;
import com.android.cgcxy.wallpaper.utils.MyJsonObjectRequest;
import com.android.cgcxy.wallpaper.utils.MyStringRequest;
import com.android.cgcxy.wallpaper.utils.Utils;
import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.lang.reflect.Type;
import java.nio.channels.NotYetBoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public class MainModeImple implements MainMode {

    private static final String TAG = "MainModeImple";
    private Context mContext;
    private RequestQueue requestQueue;


    public MainModeImple(Context context) {
        this.mContext = context;
        requestQueue = Utils.getUtils().getRequestQueue(mContext);

    }

    @Override
    public void getHomePageFragmnetDataJson(final String url, final RefreshListener refreshListener,boolean isCache) {
        MyJsonObjectRequest jsonObjectRequest = new MyJsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                Gson gson = new Gson();
                HompPagerBean hompPagerBean = gson.fromJson(jsonObject.toString(), HompPagerBean.class);
                refreshListener.resultListener(hompPagerBean);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                String cacheString = Utils.getCacheString(requestQueue, url);
                if (cacheString!=null) {
                    Gson gson = new Gson();
                    HompPagerBean hompPagerBean = gson.fromJson(cacheString, HompPagerBean.class);
                    refreshListener.resultListener(hompPagerBean);
                }else {
                    refreshListener.onError(volleyError);
                }
            }
        });
        jsonObjectRequest.setShouldCache(isCache);
        requestQueue.add(jsonObjectRequest);
    }

    @Override
    public void getClassifyFragmentJsonData(final String url, final RefreshListener refreshListener) {
        Log.i(TAG, "getClassifyFragmentJsonData: "+url);
        MyStringRequest str = new MyStringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                List<ClassifyBean> listFromJSON = getListFromJSON(s, ClassifyBean[].class);
                refreshListener.resultListener(listFromJSON);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                String cacheString = Utils.getCacheString(requestQueue, url);
                if (cacheString!=null){
                    List<ClassifyBean> listFromJSON = getListFromJSON(cacheString, ClassifyBean[].class);
                    refreshListener.resultListener(listFromJSON);
                }else {

                    refreshListener.onError(volleyError);
                }

            }
        });

        requestQueue.add(str);
    }

    @Override
    public void getSearchJsonData(final String url, final RefreshListener refreshListener,boolean isCache) {
        Log.i(TAG, "getSearchJsonData: "+url);
        MyStringRequest stringRequest = new MyStringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                List<SearchBean> listFromJSON = getListFromJSON(s, SearchBean[].class);
                refreshListener.resultListener(listFromJSON);
                Log.i(TAG, "onResponse: "+listFromJSON.size());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                String cacheString = Utils.getCacheString(requestQueue, url);
                if (cacheString!=null){
                    List<SearchBean> listFromJSON = getListFromJSON(cacheString, SearchBean[].class);
                    refreshListener.resultListener(listFromJSON);
                }else {
                    refreshListener.onError(volleyError);
                }
            }
        });
        stringRequest.setShouldCache(isCache);
        requestQueue.add(stringRequest);
    }

    @Override
    public void getHomePageHeadJsonData(String url, final RefreshListener refreshListener) {
        Log.i(TAG, "getHomePageHeadJsonData: "+url);
        MyStringRequest myStringRequest = new MyStringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                Log.i(TAG, "onResponse: ======");
                HomePageHeadBean homePageHeadBean = gson.fromJson(s, HomePageHeadBean.class);
                Log.i(TAG, "onResponse: "+homePageHeadBean.getData().size());
                refreshListener.resultListener(homePageHeadBean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        requestQueue.add(myStringRequest);
    }

    @Override
    public void getClassifySubJsonData(String url, final RefreshListener refreshListener) {
        Log.i(TAG, "getClassifySubJsonData: "+url);
        MyStringRequest stringRequest = new MyStringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Gson gson = new Gson();
                ClassifySubBean classifySubBean = gson.fromJson(s, ClassifySubBean.class);
                refreshListener.resultListener(classifySubBean);
                Log.i(TAG, "onResponse: ======");

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        stringRequest.setShouldCache(false);
        requestQueue.add(stringRequest);
    }

    @Override
    public void getClassifyNestSubJsonData(String url, final RefreshListener refreshListener) {

        MyStringRequest stringRequest = new MyStringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                ClassifySubBean classifySubBean = gson.fromJson(s, ClassifySubBean.class);
                refreshListener.resultListener(classifySubBean);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        stringRequest.setShouldCache(false);
        requestQueue.add(stringRequest);
    }

    @Override
    public void getClassifyChildishSubJsonData(String url, final RefreshListener refreshListener) {
        MyStringRequest myStringRequest = new MyStringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                ClassifySubBean classifyChildiSubBean = gson.fromJson(s, ClassifySubBean.class);
                refreshListener.resultListener(classifyChildiSubBean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        myStringRequest.setShouldCache(false);
        requestQueue.add(myStringRequest);
    }

    @Override
    public void getSpeCialJsonData(String url, final RefreshListener refreshListener) {
        Log.i(TAG, "getSpeCialJsonData: "+url);
        MyStringRequest myStringRequest = new MyStringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                SpeCialBean speCialBean = gson.fromJson(s, SpeCialBean.class);
                refreshListener.resultListener(speCialBean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        myStringRequest.setShouldCache(true);
        requestQueue.add(myStringRequest);
    }


    public  <T> List<T> getListFromJSON(String json, Class<T[]> type) {
        T[] list = new Gson().fromJson(json, type);
        return Arrays.asList(list);
    }


}
