package com.android.cgcxy.wallpaper.ui.browseui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.RankingAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.RankingBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.ShowView;
import com.android.cgcxy.wallpaper.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankingLoveFragment extends BaseFragment implements ShowView {


    private RecyclerView recycler;
    private MainPresenterImple mainPresenterImple;
    private RankingAdapter rankingAdapter;
    private boolean isLoading=false;
    private String nextUrl;
    public static RankingLoveFragment newInstance() {

        Bundle args = new Bundle();

        RankingLoveFragment fragment = new RankingLoveFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_ranking_love;
    }

    @Override
    public void initAttach() {
        mainPresenterImple = new MainPresenterImple(this, getContext());
        String url = String.format(Constants.RANKINGLOVEURL, Utils.getScreenDispaly(getContext())[0],Utils.getScreenDispaly(getContext())[1]);
        mainPresenterImple.getRankingDownLoadJsonData(url);
    }

    @Override
    public void findView() {
        recycler = findViewById(R.id.recycleView);
    }

    @Override
    public void initView() {


        rankingAdapter = new RankingAdapter();
        recycler.setAdapter(rankingAdapter);

        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (rankingAdapter.getItemViewType(position)==rankingAdapter.TYPE_ITEM){
                    return 1;
                }else if (rankingAdapter.getItemViewType(position)==rankingAdapter.TYPE_FOOT) {
                    return 3;
                }
                return 3;
            }
        });
        recycler.setLayoutManager(gridLayoutManager);

        recycler.setOnScrollListener(new RecyclerView.OnScrollListener() {

            int lastVisibleItem = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == rankingAdapter.getItemCount() && !isLoading) {
                    mainPresenterImple.getRankingDownLoadJsonData(nextUrl);
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
        RankingBean rankingBean = (RankingBean) t;
        if (rankingAdapter.getRankingBean()==null){
            rankingAdapter.setData(rankingBean);
        }else {
            rankingAdapter.getRankingBean().getData().addAll(rankingBean.getData());
        }
        nextUrl = rankingBean.getLink().getNext();
        rankingAdapter.notifyDataSetChanged();
        isLoading=false;
    }

    @Override
    public <T> void setNextData(T t) {

    }
}
