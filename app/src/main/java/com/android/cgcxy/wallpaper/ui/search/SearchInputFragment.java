package com.android.cgcxy.wallpaper.ui.search;


import android.os.Bundle;
import android.os.health.TimerStat;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.SearchInputAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.base.OnClickListener;
import com.android.cgcxy.wallpaper.bean.ImageBeanUrl;
import com.android.cgcxy.wallpaper.bean.SearchInoutBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.browseui.EverydaySubFragment;
import com.android.cgcxy.wallpaper.utils.Utils;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchInputFragment extends BaseFragment implements OnClickListener{

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    private static final String TAG = "SearchInputFragment";
    private String inputText;
    private String url;
    private MainPresenterImple mainPresenterImple;
    private SearchInputAdapter adapter;
    private SearchInoutBean searchInoutBean;

    public SearchInputFragment() {
        // Required empty public constructor
    }

    public static SearchInputFragment newInstance(String inputText) {

        Bundle args = new Bundle();
        args.putString("inputText",inputText);
        SearchInputFragment fragment = new SearchInputFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_search_input;
    }

    @Override
    public void initAttach() {
        Bundle arguments = getArguments();
        inputText = arguments.getString("inputText");
        //url = String.format(Constants.INPUTSERACHJSONURL,inputText, Utils.getScreenDispaly(getContext())[0],Utils.getScreenDispaly(getContext())[1]);
        url = getBaseActivity().getTotalBean().getTag().getImage2();
        url = url.replace("{kw}",inputText);
        mainPresenterImple = new MainPresenterImple(this,getContext());
    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        mainPresenterImple.getSearchInputJsonData(url);

    }

    @Override
    public void findView() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycleView);

    }

    @Override
    public void initView() {
        toolbar.setTitle(inputText);
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

        adapter = new SearchInputAdapter();
        adapter.setOnClickListener(this);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager mager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mager);
    }

    @Override
    public <T> void setData(T t) {
        super.setData(t);
        searchInoutBean = (SearchInoutBean) t;
        adapter.setData(searchInoutBean);
        adapter.notifyDataSetChanged();
    }

    @Override
    public <T> void setNextData(T t) {
        super.setNextData(t);
    }

    @Override
    public void clickListener(View view, int position, ImageBeanUrl imageBeanUrl) {
        EverydaySubFragment everydaySubFragment = EverydaySubFragment.newInstance(searchInoutBean.getTags().get(position).getUrl(),searchInoutBean.getTags().get(position).getName());
        getBaseActivity().commitFragment(R.id.fragmeLaout,everydaySubFragment,true);
    }
}
