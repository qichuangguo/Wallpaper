package com.android.cgcxy.wallpaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.cgcxy.wallpaper.base.BaseActivity;
import com.android.cgcxy.wallpaper.ui.HomePageFragment;

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
