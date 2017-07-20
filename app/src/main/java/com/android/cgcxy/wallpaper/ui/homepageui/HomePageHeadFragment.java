package com.android.cgcxy.wallpaper.ui.homepageui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.mode.MainMode;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.ShowView;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageHeadFragment extends BaseFragment implements ShowView {


    private Toolbar toolbar;
    private String url;
    private String title;
    private String TAG="HomePageHeadFragment";
    private RecyclerView recycle;

    public static HomePageHeadFragment newInstance(String url,String tilte) {

        Bundle args = new Bundle();
        args.putString("url",url);
        args.putString("title",tilte);
        HomePageHeadFragment fragment = new HomePageHeadFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_page_head;
    }

    @Override
    public void findView() {
        Bundle arguments = getArguments();
        url = arguments.getString("url");
        title = arguments.getString("title");

        Log.i(TAG, "findView: url"+url);

        toolbar = findViewById(R.id.toolbar);
        recycle = findViewById(R.id.recycleView);
    }

    @Override
    public void initView() {
        MainPresenterImple presenter = new MainPresenterImple(this,getContext());
        presenter.getHomePageHeadJsonData(url);

        toolbar.setTitle(title);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        getBaseActivity().setSupportActionBar(toolbar);
        getBaseActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getBaseActivity().getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBaseActivity().onBackPressed();
            }
        });
    }

    @Override
    public <T> void setData(T t) {

    }

    @Override
    public <T> void setNextData(T t) {

    }
}
