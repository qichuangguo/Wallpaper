package com.android.cgcxy.wallpaper.bean;

import java.io.Serializable;

import cn.bmob.v3.BmobObject;

/**
 * Created by chuangguo.qi on 2017/8/10.
 */

public class UserBean extends BmobObject implements Serializable {

    private String phonNumber;
    private String name;
    private String password;

    public String getPhonNumber() {
        return phonNumber;
    }

    public void setPhonNumber(String phonNumber) {
        this.phonNumber = phonNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
