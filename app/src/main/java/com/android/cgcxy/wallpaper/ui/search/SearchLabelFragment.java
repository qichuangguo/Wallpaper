package com.android.cgcxy.wallpaper.ui.search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.EveryDaySubAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.EveryDaySubBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.ShowView;
import com.android.cgcxy.wallpaper.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchLabelFragment extends BaseFragment implements ShowView{


    private String name;
    private int tid;
    private String url;
    private MainPresenterImple mainPresenterImple;
    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private boolean isLoading=false;
    private EveryDaySubAdapter adapter;
    private GridLayoutManager gridLayoutManager;
    private String nextUrl;

    public SearchLabelFragment() {
        // Required empty public constructor
    }

    public static SearchLabelFragment newInstance(String name,int tid) {
        
        Bundle args = new Bundle();
        args.putString("name",name);
        args.putInt("tid",tid);
        SearchLabelFragment fragment = new SearchLabelFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_searchfragment;
    }

    @Override
    public void initAttach() {

        Bundle arguments = getArguments();
        name = arguments.getString("name");
        tid = arguments.getInt("tid");
        url = String.format(Constants.LABELSERACHJSONULR,tid,name, Utils.getScreenDispaly(getContext())[0],Utils.getScreenDispaly(getContext())[1]);
        mainPresenterImple = new MainPresenterImple(this,getContext());

    }

    @Override
    public void findView() {

        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycleView);

    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        mainPresenterImple.getLabelSearchJsonData(url);
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
                if (position== adapter.getItemCount()-1){
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
        EveryDaySubBean everyDaySubBean= (EveryDaySubBean) t;
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
