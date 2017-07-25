package com.android.cgcxy.wallpaper.ui.browseui;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.GriddingAdapter;
import com.android.cgcxy.wallpaper.adapter.LuckGiveAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.bean.LuckGiveBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.ShowView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LuckGiveFragment extends BaseFragment implements ShowView{


    private Toolbar toolbar;
    private MainPresenterImple mainPresenterImple;
    private RecyclerView recyclerView;
    private LuckGiveAdapter adapter;

    public static LuckGiveFragment newInstance() {
        
        Bundle args = new Bundle();
        
        LuckGiveFragment fragment = new LuckGiveFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_luck_give;
    }

    @Override
    public void initAttach() {

        mainPresenterImple = new MainPresenterImple(this,getContext());

    }

    @Override
    public void findView() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycleView);
       FloatingActionButton actionButton= findViewById(R.id.flowbutton);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenterImple.getLuckGiveJsonData();
            }
        });
    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        mainPresenterImple.getLuckGiveJsonData();
    }

    @Override
    public void initView() {


        toolbar.setTitle("试试手气");
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

        adapter = new LuckGiveAdapter();
        recyclerView.setAdapter(adapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public <T> void setData(T t) {
        super.setData(t);
        LuckGiveBean luckGiveBean = (LuckGiveBean) t;
        adapter.setData(luckGiveBean);
        adapter.notifyDataSetChanged();
    }

    @Override
    public <T> void setNextData(T t) {

    }
}
