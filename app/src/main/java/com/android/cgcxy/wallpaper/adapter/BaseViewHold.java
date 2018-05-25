package com.android.cgcxy.wallpaper.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.android.cgcxy.wallpaper.R;

/**
 * Created by chuangguo.qi on 2018/5/25.
 */

public class BaseViewHold extends RecyclerView.ViewHolder {
    protected ImageView previewIv;
    public BaseViewHold(View itemView) {
        super(itemView);
        previewIv= (ImageView) itemView.findViewById(R.id.imageView);
    }
}
