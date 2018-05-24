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
import com.android.cgcxy.wallpaper.base.Constants;
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


    private static final String TAG ="ClassifySubClass" ;
    private String url;
    private Toolbar toolbar;
    private String name;
    private TabLayout tabLayout;
    private String title[] = new String[]{"最新","热门"};
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private MainPresenterImple presenterImple;
    private ClassifySubBean classifySubBean;
    private TitleFragmentPagerAdapter adapter;
    private ClassifySubNewsFragment classifySubNewsFragment;
    private ClassifySubClassifyFragment classifySubClassifyFragment;
    private String id;

    public static ClassifySubClassFragment newInstance(String url,String name,String id) {

        Bundle args = new Bundle();
        args.putString("url",url);
        args.putString("name",name);
        args.putString("id",id);

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

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);
    }

    @Override
    public void initAttach() {

        Bundle arguments = getArguments();
        url = arguments.getString("url");
        name = arguments.getString("name");
        id = arguments.getString("id");

        presenterImple = new MainPresenterImple(this,getContext());

        classifySubNewsFragment = ClassifySubNewsFragment.newInstance();
        classifySubClassifyFragment = ClassifySubClassifyFragment.newInstance();

    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        presenterImple.getClassifySubJsonData(url);

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

                /*if (classifySubBean!=null) {
                    if (fragment instanceof ClassifySubClassifyFragment) {
                        ((ClassifySubClassifyFragment) fragment).getData(id);
                    }else if (fragment instanceof ClassifySubNewsFragment){
                        ((ClassifySubNewsFragment) fragment).getData(classifySubBean,url);
                    }
                }*/
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public <T> void setData(T t) {
        super.setData(t);
        classifySubBean = (ClassifySubBean) t;
        classifySubNewsFragment.getData(classifySubBean,url);
        classifySubClassifyFragment.getData(id);
        adapter.notifyDataSetChanged();
    }

    @Override
    public <T> void setNextData(T t) {

    }
}
