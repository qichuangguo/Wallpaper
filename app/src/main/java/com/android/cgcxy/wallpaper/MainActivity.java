package com.android.cgcxy.wallpaper;

import android.accessibilityservice.AccessibilityService;
import android.app.ProgressDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

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
