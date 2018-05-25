package com.android.cgcxy.wallpaper.ui;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.GriddingAdapter;
import com.android.cgcxy.wallpaper.adapter.LandscapeWallpaperAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.HeadBean;
import com.android.cgcxy.wallpaper.bean.LandsCapeWallpaperBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.browseui.EverydayFragment;
import com.android.cgcxy.wallpaper.ui.browseui.LuckGiveFragment;
import com.android.cgcxy.wallpaper.ui.browseui.RankingFragment;
import com.android.cgcxy.wallpaper.ui.browseui.SpecialFragment;
import com.android.cgcxy.wallpaper.utils.Utils;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandscapeWallpaperFragment extends BaseFragment {
    private static final String TAG = "LandscapeWallpaperFragment";
    private RecyclerView recyclerView;
    private LandscapeWallpaperAdapter landscapeWallpaperAdapter;
    private MainPresenterImple mainPresenterImple;
    private boolean isLoading;
    private int index;
    private String url;


    public LandscapeWallpaperFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_browse;
    }

    @Override
    public void initAttach() {
        url = Constants.wallpaperUrl+Constants.wallpaperParam;
        mainPresenterImple = new MainPresenterImple(this,getContext());
    }


    @Override
    public void findView() {
        recyclerView = findViewById(R.id.recycleView);

    }

    @Override
    public void initView() {
        final GridLayoutManager gridLayoutManager = new  GridLayoutManager(getActivity(),3);
        landscapeWallpaperAdapter = new LandscapeWallpaperAdapter(getContext());
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return gridLayoutManager.getSpanCount();
                } else if (position == landscapeWallpaperAdapter.getItemCount() - 1) {
                    return gridLayoutManager.getSpanCount();
                } else {
                    return 1;
                }

            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(landscapeWallpaperAdapter);
        landscapeWallpaperAdapter.setItemOnclick(this);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            int lastVisibleItem = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == landscapeWallpaperAdapter.getItemCount() && !isLoading) {
                    mainPresenterImple.getNextNetworkBeanData(MainPresenterImple.RequestSource.LandscapeWallpaper,url+"&skip="+index*30);
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
    protected void lazyLoad() {
        super.lazyLoad();

        mainPresenterImple.getNetworkBeanData(MainPresenterImple.RequestSource.LandscapeWallpaper,url);
    }

    @Override
    public <T> void setNextData(T t) {
        super.setNextData(t);
        landscapeWallpaperAdapter.getDataBean().getRes().getWallpaper().addAll(((LandsCapeWallpaperBean) t).getRes().getWallpaper());
        landscapeWallpaperAdapter.notifyDataSetChanged();
        isLoading=false;
        index++;
    }

    @Override
    public <T> void setData(T t) {
        super.setData(t);
        index++;
        LandsCapeWallpaperBean t1 = (LandsCapeWallpaperBean) t;
        List<LandsCapeWallpaperBean.ResBean.WallpaperBean> wallpaper = t1.getRes().getWallpaper();
        List<LandsCapeWallpaperBean.ResBean.WallpaperBean> handBean = new ArrayList<>();
        handBean.add(wallpaper.get(1));
        handBean.add(wallpaper.get(2));
        wallpaper.remove(wallpaper.get(1));
        wallpaper.remove(wallpaper.get(2));
        landscapeWallpaperAdapter.setData(t1);
        landscapeWallpaperAdapter.setHeadData(handBean);
        landscapeWallpaperAdapter.notifyDataSetChanged();
        isLoading=false;
    }
}
