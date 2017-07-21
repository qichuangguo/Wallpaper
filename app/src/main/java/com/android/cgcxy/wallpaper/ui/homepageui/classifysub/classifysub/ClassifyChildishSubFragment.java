package com.android.cgcxy.wallpaper.ui.homepageui.classifysub.classifysub;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.ClassifySubNewsAdapter;
import com.android.cgcxy.wallpaper.adapter.HomePageHeadAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.bean.ClassifyChildiSubBean;
import com.android.cgcxy.wallpaper.bean.ClassifySubBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenter;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.ShowView;

/**
 * Use the {@link ClassifyChildishSubFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClassifyChildishSubFragment extends BaseFragment implements ShowView{

    private static final String TAG = "ClassifyChildishSubFragment";
    private MainPresenterImple mainPresenterImple;
    private Toolbar toolbar;
    private RecyclerView recycle;
    private boolean isLoading=false;
    private String name;
    private GridLayoutManager gridLayoutManager;
    private ClassifySubNewsAdapter adapter;
    private String nextUrl = "";

    public ClassifyChildishSubFragment() {
        // Required empty public constructor
    }
    public static ClassifyChildishSubFragment newInstance(String url,String name) {
        ClassifyChildishSubFragment fragment = new ClassifyChildishSubFragment();
        Bundle args = new Bundle();
        args.putString("url",url);
        args.putString("name",name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_classify_childish_sub;
    }

    @Override
    public void initAttach() {
        String url = getArguments().getString("url");
        name = getArguments().getString("name");
        mainPresenterImple = new MainPresenterImple(this,getContext());
        mainPresenterImple.getClassifyChildishSubJsonData(url);
        Log.i(TAG, "initAttach: "+url);
    }

    @Override
    public void findView() {

        toolbar = findViewById(R.id.toolbar);
        recycle = findViewById(R.id.recycleView);
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

        gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recycle.setLayoutManager(gridLayoutManager);



        adapter = new ClassifySubNewsAdapter();
        recycle.setAdapter(adapter);

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

        recycle.setOnScrollListener(new RecyclerView.OnScrollListener() {

            int lastVisibleItem = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == adapter.getItemCount() && !isLoading) {
                    isLoading = true;
                    if (nextUrl!=null && !nextUrl.isEmpty()){
                        mainPresenterImple.getClassifyChildishSubNextJsonData(nextUrl);
                    }
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
        ClassifySubBean bean = (ClassifySubBean) t;
        nextUrl=bean.getLink().getNext();
        adapter.setData(bean);
        adapter.notifyDataSetChanged();

    }

    @Override
    public <T> void setNextData(T t) {
        ClassifySubBean bean = (ClassifySubBean) t;
        adapter.getClassifySubBean().getData().addAll(bean.getData());
        adapter.notifyDataSetChanged();
        nextUrl=bean.getLink().getNext();
        isLoading=false;
    }
}
