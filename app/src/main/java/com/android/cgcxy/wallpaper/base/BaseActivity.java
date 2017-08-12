package com.android.cgcxy.wallpaper.base;

import android.app.Dialog;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.android.cgcxy.wallpaper.HomePage;
import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.bean.TotalBean;
import com.android.cgcxy.wallpaper.bean.UserBean;
import com.android.cgcxy.wallpaper.utils.SystemBarTintManager;
import com.android.cgcxy.wallpaper.view.MyDialog;

import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private String TAG="BaseActivity";

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public UserBean  userBean;

    public TotalBean getTotalBean() {
        return totalBean;
    }

    public TotalBean totalBean;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public boolean isLogin=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        findView();
        initView();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Fragment fragmentById = getSupportFragmentManager().findFragmentById(R.id.fragmeLaout);
        if (fragmentById instanceof HomePage){
            finish();
        }
        Log.i(TAG, "onBackPressed: "+fragmentById);
    }

    public abstract void initView();
    public abstract int getLayoutId();
    public abstract void findView();



    public void commitFragment(int id, Fragment fragment, boolean keep){
        commitFragment(id,fragment,null,keep);
    }

    public void commitFragment(int id, Fragment fragment, String tag,
                               boolean keep) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        if (keep) {
            transaction.addToBackStack(tag);
        } else {
            transaction.disallowAddToBackStack();
        }
        transaction.commitAllowingStateLoss();
    }

    public void setbarTintEnabled(int color1,boolean isFontColor) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            // 激活状态栏
            tintManager.setStatusBarTintEnabled(true);
            if (color1==R.color.transparency){
                tintManager.setStatusBarAlpha(0);
                tintManager.setStatusBarTintEnabled(false);
            }else {
                tintManager.setStatusBarAlpha(255);
                tintManager.setStatusBarTintEnabled(true);
            }
            if (tintManager.FlymeSetStatusBarLightMode(getWindow(), isFontColor) || tintManager.MIUISetStatusBarLightMode(getWindow(), isFontColor)) {
                tintManager.setStatusBarTintResource(color1);
            } else {
                if (isFontColor) {
                    //tintManager.setStatusBarTintResource(R.color.none_color);
                } else {
                    tintManager.setStatusBarTintResource(color1);

                }
            }


        }
    }
}
