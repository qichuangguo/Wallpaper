package com.android.cgcxy.wallpaper.mode;

import android.content.Context;
import android.util.Log;

import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.android.cgcxy.wallpaper.utils.Utils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

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
    public void getHomePageFragmnetDataJson(String url, final RefreshListener refreshListener) {
        Log.i(TAG, "getHomePageFragmnetDataJson: " + url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject jsonObject) {
                Gson gson = new Gson();
                HompPagerBean hompPagerBean = gson.fromJson(jsonObject.toString(), HompPagerBean.class);
                refreshListener.resultListener(hompPagerBean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                refreshListener.onError(volleyError);
            }
        });
        requestQueue.add(jsonObjectRequest);

    }
}
