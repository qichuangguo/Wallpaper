package com.android.cgcxy.wallpaper.bean;

import android.preference.PreferenceFragment;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by chuangguo.qi on 2018/5/23.
 */

public class HeadBean {
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    private String title;
    private ImageView imageView;
}
