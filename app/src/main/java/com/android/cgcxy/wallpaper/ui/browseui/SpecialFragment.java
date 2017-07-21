package com.android.cgcxy.wallpaper.ui.browseui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.SpecialAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.base.OnClickListener;
import com.android.cgcxy.wallpaper.bean.SpeCialBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenter;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.ShowView;
import com.android.cgcxy.wallpaper.ui.homepageui.HomePageHeadFragment;
import com.android.cgcxy.wallpaper.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpecialFragment extends BaseFragment implements ShowView ,OnClickListener{


    private Toolbar toolbar;
    private RecyclerView recycle;
    private MainPresenterImple mainPresenterImple;
    private SpecialAdapter specialAdapter;
    private boolean isLoading=false;
    private GridLayoutManager layoutManager;
    private String nextUrl;

    public SpecialFragment() {
        // Required empty public constructor
    }

    public static SpecialFragment newInstance() {

        Bundle args = new Bundle();
        SpecialFragment fragment = new SpecialFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_special;
    }

    @Override
    public void initAttach() {
        mainPresenterImple = new MainPresenterImple(this,getContext());



    }

    @Override
    public void findView() {
        toolbar = findViewById(R.id.toolbar);
        recycle = findViewById(R.id.recycleView);
    }

    @Override
    public void initView() {
        String url = String.format(Constants.BROWSESPECIAL, Utils.getScreenDispaly(getContext())[0],Utils.getScreenDispaly(getContext())[1]);
        mainPresenterImple.getSpeCialJsonData(url);
        toolbar.setTitle("壁纸专题");
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

        specialAdapter = new SpecialAdapter();
        specialAdapter.setOnClickListener(this);
        layoutManager = new GridLayoutManager(getContext(),1);
        recycle.setLayoutManager(layoutManager);
        recycle.setAdapter(specialAdapter);

        recycle.setOnScrollListener(new RecyclerView.OnScrollListener() {

            int lastVisibleItem = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == specialAdapter.getItemCount() && !isLoading) {
                    mainPresenterImple.getSpeCialJsonData(nextUrl);
                    isLoading = true;

                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            }
        });

    }

    @Override
    public <T> void setData(T t) {
        SpeCialBean speCialBean = (SpeCialBean) t;
        nextUrl = speCialBean.getLink().getNext();
        if (specialAdapter.getSpeCialBean()==null) {
            specialAdapter.setData(speCialBean);
            specialAdapter.notifyDataSetChanged();
        }else {
            specialAdapter.getSpeCialBean().getData().addAll(speCialBean.getData());
            specialAdapter.notifyDataSetChanged();
        }
        isLoading=false;
    }

    @Override
    public <T> void setNextData(T t) {

    }

    @Override
    public void clickListener(View view, int position) {
        getBaseActivity().commitFragment(R.id.fragmeLaout, HomePageHeadFragment.newInstance( specialAdapter.getSpeCialBean().getData().get(position).getDetail(),specialAdapter.getSpeCialBean().getData().get(position).getName()),true);
    }
}
