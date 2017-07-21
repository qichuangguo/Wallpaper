package com.android.cgcxy.wallpaper;

import com.android.cgcxy.wallpaper.base.BaseActivity;
public class MainActivity extends BaseActivity {


    @Override
    public void initView() {
        commitFragment(R.id.fragmeLaout,new HomePage(),true);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void findView() {

    }
}
