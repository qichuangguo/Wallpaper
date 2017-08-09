package com.android.cgcxy.wallpaper.base;

import android.view.View;
import android.widget.ImageButton;

import com.android.cgcxy.wallpaper.bean.ImageBeanUrl;

/**
 * Created by chuangguo.qi on 2017/7/21.
 */

public interface OnClickListener {

  void clickListener(View view, int position, ImageBeanUrl imageBeanUrl);
}
