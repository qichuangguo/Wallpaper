package com.android.cgcxy.wallpaper.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import cn.bmob.v3.BmobObject;

/**
 * Created by chuangguo.qi on 2017/8/10.
 */

public class UserBean extends BmobObject implements Serializable {

    private String phonNumber;
    private String name;
    private String password;
    private String jObject;
    private List<CollectUser> collect;

    public List<CollectUser> getCollect() {
        return collect;
    }

    public void setCollect(List<CollectUser> collect) {
        this.collect = collect;
    }

    public String getjObject() {
        return jObject;
    }

    public void setjObject(String jObject) {
        this.jObject = jObject;
    }

    private UserBeanPersonal userBeanPersonal;

    public UserBeanPersonal getUserBeanPersonal() {
        return userBeanPersonal;
    }

    public void setUserBeanPersonal(UserBeanPersonal userBeanPersonal) {
        this.userBeanPersonal = userBeanPersonal;
    }

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


    public class UserBeanPersonal implements Serializable{

        private String headPortraitUrl;

        public String getHeadPortraitUrl() {
            return headPortraitUrl;
        }

        public void setHeadPortraitUrl(String headPortraitUrl) {
            this.headPortraitUrl = headPortraitUrl;
        }
    }

    public class CollectUser implements Serializable{

        private String collectUrl;

        public String getCollectUrl() {
            return collectUrl;
        }

        public void setCollectUrl(String collectUrl) {
            this.collectUrl = collectUrl;
        }
    }

}


