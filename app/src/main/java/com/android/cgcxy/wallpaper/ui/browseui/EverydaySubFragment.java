package com.android.cgcxy.wallpaper.ui.browseui;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.EveryDaySubAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.bean.EveryDaySubBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.ShowView;

/**
 * Created by chuangguo.qi on 2017/7/24.
 */

public class EverydaySubFragment extends BaseFragment implements ShowView{

    private Toolbar toolbar;
    private String url;
    private String name;
    private RecyclerView recyclerView;
    private MainPresenterImple mainPresenterImple;
    private EveryDaySubAdapter adapter;
    private boolean isLoading=false;
    private GridLayoutManager gridLayoutManager;
    private String nextUrl;

    public static EverydaySubFragment newInstance(String url, String name) {

        Bundle args = new Bundle();
        args.putString("url",url);
        args.putString("name",name);
        EverydaySubFragment fragment = new EverydaySubFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_everyday_sub;
    }

    @Override
    public void initAttach() {

        mainPresenterImple = new MainPresenterImple(this,getContext());

    }

    @Override
    public void findView() {
        url = (String) getArguments().get("url");
        name = (String) getArguments().get("name");
        mainPresenterImple.getEveryDaySubJosnData(url);
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycleView);
    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        mainPresenterImple.getEveryDaySubJosnData(url);
    }

    @Override
    public void initView() {



        toolbar.setTitle(name);
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

        adapter = new EveryDaySubAdapter();
        gridLayoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position==adapter.getItemCount()-1){
                    return 3;
                }else {
                    return 1;
                }

            }
        });

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            int lastVisibleItem = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount() && !isLoading) {
                    mainPresenterImple.getEveryDaySubJosnData(nextUrl);
                    isLoading = true;

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
        EveryDaySubBean everyDaySubBean = (EveryDaySubBean) t;
        nextUrl = everyDaySubBean.getLink().getNext();
        if (adapter.getEveryDaySubBean()==null) {
            adapter.setData(everyDaySubBean);
        }else {
            adapter.getEveryDaySubBean().getData().addAll(everyDaySubBean.getData());
        }
        isLoading=false;
        adapter.notifyDataSetChanged();
    }

    @Override
    public <T> void setNextData(T t) {

    }
}
