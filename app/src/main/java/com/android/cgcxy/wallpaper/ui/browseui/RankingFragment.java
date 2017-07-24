package com.android.cgcxy.wallpaper.ui.browseui;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.TitleFragmentPagerAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankingFragment extends BaseFragment {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String title[] = new String[]{"下载排行","收藏排行"};
    private List<Fragment> fragments = new ArrayList<>();

    public static RankingFragment newInstance() {

        Bundle args = new Bundle();

        RankingFragment fragment = new RankingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_ranking;
    }

    @Override
    public void initAttach() {

        RankingDownLoadFragment rankingFragment = RankingDownLoadFragment.newInstance();
        RankingLoveFragment rankingLoveFragment = RankingLoveFragment.newInstance();

        fragments.add(rankingFragment);
        fragments.add(rankingLoveFragment);


    }

    @Override
    public void findView() {
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);
    }

    @Override
    public void initView() {

        toolbar.setTitle("排行榜");
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

        TitleFragmentPagerAdapter titleFragmentPagerAdapter = new TitleFragmentPagerAdapter(getChildFragmentManager(),fragments);
        titleFragmentPagerAdapter.setTitle(title);
        viewPager.setAdapter(titleFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
