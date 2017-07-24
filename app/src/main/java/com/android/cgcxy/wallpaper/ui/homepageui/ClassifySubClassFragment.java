package com.android.cgcxy.wallpaper.ui.homepageui;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.TitleFragmentPagerAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.bean.ClassifySubBean;
import com.android.cgcxy.wallpaper.mode.RefreshListener;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.ShowView;
import com.android.cgcxy.wallpaper.ui.homepageui.classifysub.ClassifySubClassifyFragment;
import com.android.cgcxy.wallpaper.ui.homepageui.classifysub.ClassifySubNewsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifySubClassFragment extends BaseFragment implements ShowView {


    private static final String TAG ="ClassifySubClassFragment" ;
    private String url;
    private Toolbar toolbar;
    private String name;
    private TabLayout tabLayout;
    private String title[] = new String[]{"最新","子分类"};
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private MainPresenterImple presenterImple;
    private ClassifySubBean classifySubBean;
    private TitleFragmentPagerAdapter adapter;
    private ClassifySubNewsFragment classifySubNewsFragment;
    private ClassifySubClassifyFragment classifySubClassifyFragment;

    public static ClassifySubClassFragment newInstance(String url,String name) {

        Bundle args = new Bundle();
        args.putString("url",url);
        args.putString("name",name);

        ClassifySubClassFragment fragment = new ClassifySubClassFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public int getLayoutId() {
        return R.layout.fragment_classify_sub_class;
    }

    @Override
    public void findView() {


        Log.i(TAG, "findView: "+url);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);
    }

    @Override
    public void initAttach() {

        Bundle arguments = getArguments();
        url = arguments.getString("url");
        name = arguments.getString("name");

        Log.i(TAG, "initAttach: ");
        presenterImple = new MainPresenterImple(this,getContext());
        presenterImple.getClassifySubJsonData(url);

        classifySubNewsFragment = ClassifySubNewsFragment.newInstance(presenterImple);
        classifySubClassifyFragment = ClassifySubClassifyFragment.newInstance(presenterImple);

    }

    @Override
    public void initView() {

        Log.i(TAG, "initView: "+classifySubBean);



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

        fragments.clear();
        fragments.add(classifySubNewsFragment);
        fragments.add(classifySubClassifyFragment);

        adapter = new TitleFragmentPagerAdapter(getChildFragmentManager(), fragments);
        adapter.setTitle(title);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Fragment fragment = fragments.get(position);
                Log.i(TAG, "onPageSelected: ========"+classifySubBean);
                if (classifySubBean!=null) {
                    if (fragment instanceof ClassifySubClassifyFragment) {
                        ((ClassifySubClassifyFragment) fragment).getData(classifySubBean);
                    }else if (fragment instanceof ClassifySubNewsFragment){
                        ((ClassifySubNewsFragment) fragment).getData(classifySubBean);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public <T> void setData(T t) {
        Log.i(TAG, "setData: ");
        classifySubBean = (ClassifySubBean) t;
        classifySubNewsFragment.getData(classifySubBean);
        classifySubClassifyFragment.getData(classifySubBean);
        adapter.notifyDataSetChanged();
    }

    @Override
    public <T> void setNextData(T t) {
        classifySubNewsFragment.resultListener(t);
    }
}