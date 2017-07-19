package com.android.cgcxy.wallpaper.presenter;

import android.content.Context;
import android.util.Log;

import com.android.cgcxy.wallpaper.base.Constants;
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
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public class MainPresenterImple implements MainPresenter {

    public static final String TAG ="MainPresenterImple" ;
    private ShowView showView;
    private Context mContext;
    private HompPagerBean hompPagerBean;

    private final MainModeImple mainModeImple;

    public MainPresenterImple(ShowView showView, Context context){
        this.showView=showView;
        this.mContext=context;
        mainModeImple = new MainModeImple(context);
    }

    public void getHomePageFragmnetDataJson(){
        int[] screenDispaly = Utils.getScreenDispaly(mContext);
        String url = String.format(Constants.HOMEPAGEJSONURL,screenDispaly[0]+"",screenDispaly[1]+"",1+"");
        mainModeImple.getHomePageFragmnetDataJson(url, new RefreshListener() {
            @Override
            public <T> void resultListener(T t) {
                MainPresenterImple.this.hompPagerBean= (HompPagerBean) t;
                showView.setData(t);
            }

            @Override
            public <E> void onError(E e) {

            }
        });
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
        });

    }
}
