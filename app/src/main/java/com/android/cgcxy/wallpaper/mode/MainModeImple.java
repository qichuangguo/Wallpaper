package com.android.cgcxy.wallpaper.mode;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.ClassifyBean;
import com.android.cgcxy.wallpaper.bean.ClassifyChildiSubBean;
import com.android.cgcxy.wallpaper.bean.ClassifySubBean;
import com.android.cgcxy.wallpaper.bean.EveryDaySubBean;
import com.android.cgcxy.wallpaper.bean.EveryDaybean;
import com.android.cgcxy.wallpaper.bean.HomePageHeadBean;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.android.cgcxy.wallpaper.bean.LandsCapeWallpaperBean;
import com.android.cgcxy.wallpaper.bean.LuckGiveBean;
import com.android.cgcxy.wallpaper.bean.RankingBean;
import com.android.cgcxy.wallpaper.bean.SearchBean;
import com.android.cgcxy.wallpaper.bean.SearchInoutBean;
import com.android.cgcxy.wallpaper.bean.SearchLabelBean;
import com.android.cgcxy.wallpaper.bean.SpeCialBean;
import com.android.cgcxy.wallpaper.bean.TotalBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
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
import java.io.Serializable;
import java.lang.reflect.Type;
import java.nio.channels.NotYetBoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import javax.xml.transform.stream.StreamResult;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public class MainModeImple implements MainMode{

    private static final String TAG = "MainModeImple";
    private Context mContext;
    private RequestQueue requestQueue;


    public MainModeImple(Context context) {
        this.mContext = context;
        requestQueue = Utils.getUtils().getRequestQueue(mContext);

    }

    @Override
    public void getHomePageFragmnetDataJson(final String url, final RefreshListener refreshListener,boolean isCache) {
        Log.i(TAG, "getHomePageFragmnetDataJson: "+url);
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

                Gson gson = new Gson();
                ClassifyBean classifyBean = gson.fromJson(s, ClassifyBean.class);
                refreshListener.resultListener(classifyBean);

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
                Log.i(TAG, "onResponse: "+homePageHeadBean.getRes().getWallpaper().size());
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

        MyStringRequest stringRequest = new MyStringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Gson gson = new Gson();
                ClassifySubBean classifySubBean = gson.fromJson(s, ClassifySubBean.class);
                if (!Constants.adult) {
                    if (classifySubBean != null && classifySubBean.getRes().getVertical().size() > 0) {
                        List<ClassifySubBean.ResBean.VerticalBean> vertical = classifySubBean.getRes().getVertical();
                        for (int i = 0; i <vertical.size() ; i++) {
                            ClassifySubBean.ResBean.VerticalBean bean = vertical.get(i);
                            if (bean.isXr()) {
                                classifySubBean.getRes().getVertical().remove(bean);
                                i--;
                            }
                        }

                    }
                }
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
    public void getClassifyNestSubJsonData(String url, final RefreshListener refreshListener) {

        MyStringRequest stringRequest = new MyStringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                ClassifySubBean classifySubBean = gson.fromJson(s, ClassifySubBean.class);
                if (!Constants.adult) {
                    if (classifySubBean != null && classifySubBean.getRes().getVertical().size() > 0) {
                        List<ClassifySubBean.ResBean.VerticalBean> vertical = classifySubBean.getRes().getVertical();
                        for (int i = 0; i <vertical.size() ; i++) {
                            ClassifySubBean.ResBean.VerticalBean bean = vertical.get(i);
                            if (bean.isXr()) {
                                classifySubBean.getRes().getVertical().remove(bean);
                                i--;
                            }
                        }

                    }
                }
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

    @Override

    public void getEveryDayJosnData(String url, final RefreshListener refreshListener) {
        Log.i(TAG, "getEveryDayJosnData: url:"+url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                List<EveryDaybean> listFromJSON = getListFromJSON(s, EveryDaybean[].class);
                Log.i(TAG, "onResponse: listFromJSON"+listFromJSON.size());
                refreshListener.resultListener(listFromJSON);

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
    public void getEveryDaySubJosnData(String url, final RefreshListener refreshListener) {

        Log.i(TAG, "getEveryDaySubJosnData: "+url);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Gson gson = new Gson();
                EveryDaySubBean everyDaySubBean = gson.fromJson(s, EveryDaySubBean.class);
                refreshListener.resultListener(everyDaySubBean);

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
    public void getRankingDownLoadJsonData(String url, final RefreshListener refreshListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                RankingBean rankingBean = gson.fromJson(s, RankingBean.class);
                refreshListener.resultListener(rankingBean);

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
    public void getLuckGiveJsonData(String url, final RefreshListener refreshListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                LuckGiveBean luckGiveBean = gson.fromJson(s, LuckGiveBean.class);
                refreshListener.resultListener(luckGiveBean);
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
    public void getLabelSearchJsonData(String url, final RefreshListener refreshListener) {
        StringRequest stringRequest   = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                Gson gson = new Gson();
                EveryDaySubBean searchLabelBean = gson.fromJson(s, EveryDaySubBean.class);
                refreshListener.resultListener(searchLabelBean);

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
    public void getSearchInputJsonData(String url, final RefreshListener refreshListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Gson gson = new Gson();
                SearchInoutBean searchInoutBean = gson.fromJson(s, SearchInoutBean.class);
                refreshListener.resultListener(searchInoutBean);
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
    public void getTotalUrl(String url, final RefreshListener refreshListener) {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                TotalBean totalBean = new Gson().fromJson(s,TotalBean.class);
                refreshListener.resultListener(totalBean);


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
    public void getNetWorkData(final MainPresenterImple.RequestSource requestSource, final String url, final RefreshListener refreshListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                if (requestSource==MainPresenterImple.RequestSource.LandscapeWallpaper){
                    Gson gson = new Gson();
                    LandsCapeWallpaperBean landsCapeWallpaperBean = gson.fromJson(s, LandsCapeWallpaperBean.class);
                    refreshListener.resultListener(landsCapeWallpaperBean);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        stringRequest.setShouldCache(false);
        requestQueue.add(stringRequest);

    }




    public  <T> List<T> getListFromJSON(String json, Class<T[]> type) {
        T[] list = new Gson().fromJson(json, type);
        return Arrays.asList(list);
    }


}
