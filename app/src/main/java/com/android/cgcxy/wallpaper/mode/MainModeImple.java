package com.android.cgcxy.wallpaper.mode;

import android.content.Context;
import android.util.Log;

import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.ClassifyBean;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.android.cgcxy.wallpaper.bean.SearchBean;
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

        VolleyLog.DEBUG=true;
    }

    @Override
    public void getHomePageFragmnetDataJson(final String url, final RefreshListener refreshListener) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                Gson gson = new Gson();
                HompPagerBean hompPagerBean = gson.fromJson(jsonObject.toString(), HompPagerBean.class);
                refreshListener.resultListener(hompPagerBean);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Cache.Entry entry = requestQueue.getCache().get( url);
                Log.i(TAG, "onResponse: "+entry);
                refreshListener.onError(volleyError);
            }
        });
        Log.i(TAG, "getHomePageFragmnetDataJson: "+url);
        //byte[] data = requestQueue.getCache().get("http://api.lovebizhi.com/android_v3.php?a=home&spdy=1&device=samsungGT-I8262D&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=720&screen_height=1280&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0&p=1").data;
        //Log.i(TAG, "getHomePageFragmnetDataJson: entry"+data.length);

       // Log.i(TAG, "getHomePageFragmnetDataJson: "+data.length);
        jsonObjectRequest.setShouldCache(true);
        requestQueue.add(jsonObjectRequest);



    }

    @Override
    public void getClassifyFragmentJsonData(String url, final RefreshListener refreshListener) {
        Log.i(TAG, "getClassifyFragmentJsonData: " + url);
        StringRequest str = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                List<ClassifyBean> listFromJSON = getListFromJSON(s, ClassifyBean[].class);
                refreshListener.resultListener(listFromJSON);
                Log.i(TAG, "onResponse: " + listFromJSON.size());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i(TAG, "onErrorResponse: " + volleyError.getMessage());
            }
        });

        requestQueue.add(str);
    }

    @Override
    public void getSearchJsonData(String url, final RefreshListener refreshListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                List<SearchBean> listFromJSON = getListFromJSON(s, SearchBean[].class);
                refreshListener.resultListener(listFromJSON);
                Log.i(TAG, "onResponse: "+listFromJSON.size());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        requestQueue.add(stringRequest);
    }


    public  <T> List<T> getListFromJSON(String json, Class<T[]> type) {
        T[] list = new Gson().fromJson(json, type);
        return Arrays.asList(list);
    }


}
