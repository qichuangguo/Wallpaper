package com.android.cgcxy.wallpaper.adapter;

import android.graphics.ImageFormat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.bean.HomePageHeadBean;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.android.cgcxy.wallpaper.ui.homepageui.HomePageHeadFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/20.
 */

public class HomePageHeadAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final int HEAD_VIEW=0;
    private final int HEAD_ITEM=1;

    private HomePageHeadBean homePageHeadBean;
    public void setData(HomePageHeadBean homePageHeadBean){
        this.homePageHeadBean = homePageHeadBean;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==HEAD_ITEM){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_adapter_item, parent, false);
            return new MyViewHold(inflate);
        }else if (viewType==HEAD_VIEW){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_page_head_item, parent, false);
            return new MyHeadViewHold(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (homePageHeadBean!=null) {

            if (getItemViewType(position)==HEAD_VIEW){


            }else if (getItemViewType(position)==HEAD_ITEM){


            }
        }
    }

    @Override
    public int getItemCount() {
        if (homePageHeadBean!=null && homePageHeadBean.getData().size()>0){
            return homePageHeadBean.getData().size()+1;
        }
        return 0;
    }

    public class MyViewHold extends RecyclerView.ViewHolder{

        private TextView tv_title;
        private ImageView imageView;
        public MyViewHold(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);

        }
    }

    public class MyHeadViewHold extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        public MyHeadViewHold(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);
            textView= (TextView) itemView.findViewById(R.id.textView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return HEAD_VIEW;
        }
        return HEAD_ITEM;
    }
}
