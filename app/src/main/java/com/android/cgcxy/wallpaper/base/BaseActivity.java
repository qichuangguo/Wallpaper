package com.android.cgcxy.wallpaper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by chuangguo.qi on 2017/7/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        findView();
        initView();
    }

    public abstract void initView();
    public abstract int getLayoutId();
    public abstract void findView();
}
