package com.android.cgcxy.wallpaper;

import android.app.Application;

import com.android.cgcxy.wallpaper.bean.UserBean;
import com.android.cgcxy.wallpaper.utils.Utils;

import cn.bmob.v3.Bmob;

/**
 * Created by chuangguo.qi on 2017/8/10.
 */

public class MyApplication extends Application{

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    private UserBean userBean;

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    private boolean isLogin=false;
    @Override
    public void onCreate() {
        super.onCreate();
        //第一：默认初始化
    }
}
