package com.android.cgcxy.wallpaper.ui.browseui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.TitleFragmentPagerAdapter;
import com.android.cgcxy.wallpaper.adapter.TitleViewPagerAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.bean.EveryDaybean;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.ShowView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class EverydayFragment extends BaseFragment implements ShowView{


    private static final String TAG ="EverydayFragment" ;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MainPresenterImple mainPresenterImple;
    private List<EveryDaybean> daybeen;
    private View viewPageItemView;
    private List<View> viewPageViews = new ArrayList<>();
    private List<String> titles = new ArrayList<>();
    private TitleViewPagerAdapter adapter;

    public static EverydayFragment newInstance() {

        Bundle args = new Bundle();

        EverydayFragment fragment = new EverydayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_everyday;
    }

    @Override
    public void initAttach() {
        mainPresenterImple = new MainPresenterImple(this,getContext());

    }

    @Override
    public void findView() {

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        /*if (daybeen!=null ) {
            outState.putParcelableArrayList("Data",daybeen);
        }*/
    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        mainPresenterImple.getEveryDayJosnData();
    }

    @Override
    public void initView() {
        viewPageViews.clear();
        titles.clear();


        toolbar.setTitle("每日更新");
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

        adapter = new TitleViewPagerAdapter();
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    @Override
    public <T> void setData(T t) {
        super.setData(t);
        daybeen = (List<EveryDaybean>) t;
        for (int i = 0; i <daybeen.size() ; i++) {
            viewPageItemView = LayoutInflater.from(getContext()).inflate(R.layout.every_day_viewpager_item,null);

            TextView tv_title= (TextView) viewPageItemView.findViewById(R.id.tv_name);
            tv_title.setText(daybeen.get(i).getDate());

            TextView tv_more= (TextView) viewPageItemView.findViewById(R.id.tv_more);
            tv_more.setText("查看更多"+daybeen.get(i).getTotal()+"张图片");

            ImageView imageViews = (ImageView) viewPageItemView.findViewById(R.id.imageView);
            Picasso.with(getContext()).load(daybeen.get(i).getImage()).into(imageViews);
            LinearLayout linearLayout = (LinearLayout) viewPageItemView.findViewById(R.id.linearLayout);
            setOnclick(imageViews,daybeen.get(i).getUrl(),daybeen.get(i).getName());

            for (int j = 0; j <linearLayout.getChildCount() ; j++) {
               ImageView imageView= (ImageView) linearLayout.getChildAt(j);
                Picasso.with(getContext()).load(daybeen.get(j).getData().get(j)).into(imageView);
            }
            viewPageViews.add(viewPageItemView);
            titles.add(daybeen.get(i).getName());
        }
        adapter.setDatas(viewPageViews);
        adapter.setTitle(titles);
        adapter.notifyDataSetChanged();

    }

    public void setOnclick(ImageView imageView, final String url, final String name){

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EverydaySubFragment everyDaySub = EverydaySubFragment.newInstance(url,name);
                getBaseActivity().commitFragment(R.id.fragmeLaout,everyDaySub,true);
            }
        });

    }

    @Override
    public <T> void setNextData(T t) {

    }
}
