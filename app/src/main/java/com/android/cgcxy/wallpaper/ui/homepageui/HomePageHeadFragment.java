package com.android.cgcxy.wallpaper.ui.homepageui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.HomePageHeadAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.bean.HomePageHeadBean;
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
    private String TAG = "HomePageHeadFragment";
    private RecyclerView recycle;
    private HomePageHeadAdapter adapter;
    private boolean isLoading = false;
    private GridLayoutManager gridLayoutManager;
    private MainPresenterImple presenter;
    private int index=0;

    public static HomePageHeadFragment newInstance(String url, String tilte) {

        Bundle args = new Bundle();
        args.putString("url", url);
        args.putString("title", tilte);
        HomePageHeadFragment fragment = new HomePageHeadFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home_page_head;
    }

    @Override
    public void initAttach() {

        Bundle arguments = getArguments();
        url = arguments.getString("url");
        title = arguments.getString("title");

        presenter = new MainPresenterImple(this, getContext());

    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        presenter.getHomePageHeadJsonData(url);
    }

    @Override
    public void findView() {

        toolbar = findViewById(R.id.toolbar);
        recycle = findViewById(R.id.recycleView);
    }

    @Override
    public void initView() {


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

        gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recycle.setLayoutManager(gridLayoutManager);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 3;
                } else if (adapter.getItemCount()-1==position){

                    return 3;

                }else {
                    return 1;
                }
            }
        });
        adapter = new HomePageHeadAdapter();
        adapter.setOnClickListener(this);
        recycle.setAdapter(adapter);

        recycle.setOnScrollListener(new RecyclerView.OnScrollListener() {

            int lastVisibleItem = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.i(TAG, "onScrollStateChanged: lastVisibleItem:" + lastVisibleItem + "::" + adapter.getItemCount() + "::" + isLoading);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount() && !isLoading) {
                    isLoading = true;
                    presenter.getHomePageNextHeadJsonData(url+"&skip="+index*30);
                    Log.i(TAG, "onScrollStateChanged: ");
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = gridLayoutManager.findLastVisibleItemPosition();
            }
        });


    }

    @Override
    public <T> void setData(T t) {
        super.setData(t);
        HomePageHeadBean headBean = (HomePageHeadBean) t;
        adapter.setData(headBean);
        adapter.notifyDataSetChanged();
        index++;
        // Log.i(TAG, "setData: "+headBean.getData().size());

    }

    @Override
    public <T> void setNextData(T t) {
        HomePageHeadBean headBean = (HomePageHeadBean) t;
        adapter.getHomePageHeadBean().getRes().getWallpaper().addAll(headBean.getRes().getWallpaper());
        adapter.notifyDataSetChanged();
        index++;
        isLoading = false;
    }
}
