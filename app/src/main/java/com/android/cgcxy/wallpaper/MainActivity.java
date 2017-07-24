package com.android.cgcxy.wallpaper;

import android.app.ProgressDialog;
import android.view.LayoutInflater;
import android.view.View;

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

        ProgressDialog p = new ProgressDialog(this);
        p.setContentView(R.layout.progress_loading);
        p.show();
    }
}
