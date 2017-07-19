package com.android.cgcxy.wallpaper.ui;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.bean.SearchBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenter;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.view.FlowLayout;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment implements ShowView{


    private FlowLayout flowLayout;
    private LayoutInflater from;
    private String TAG="SearchFragment";

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_ringtone;
    }

    @Override
    public void findView() {
        from = LayoutInflater.from(getContext());
        flowLayout = findViewById(R.id.flowLayout);
    }

    @Override
    public void initView() {

        MainPresenterImple mainPresenterImple = new MainPresenterImple(this,getContext());
        mainPresenterImple.getSearchJsonData();
    }

    @Override
    public <T> void setData(T t) {
        List<SearchBean> searchBeanS = (List<SearchBean>) t;
        for (int i = 0; i < searchBeanS.size(); i++) {
            TextView textView = (TextView) from.inflate(R.layout.search_label_tv,flowLayout,false);
            textView.setText(searchBeanS.get(i).getName());
            Log.i(TAG, "setData: "+searchBeanS.get(i).getName());
            flowLayout.addView(textView);
        }
    }

    @Override
    public <T> void setNextData(T t) {

    }
}
