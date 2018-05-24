package com.android.cgcxy.wallpaper.adapter;

import android.content.Context;
import android.graphics.ImageFormat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.base.OnClickListener;
import com.android.cgcxy.wallpaper.bean.HomePageHeadBean;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.android.cgcxy.wallpaper.bean.ImageBeanUrl;
import com.android.cgcxy.wallpaper.bean.RankingBean;
import com.android.cgcxy.wallpaper.ui.homepageui.HomePageHeadFragment;
import com.android.cgcxy.wallpaper.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/20.
 */

public class HomePageHeadAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final int HEAD_VIEW = 0;
    private final int HEAD_ITEM = 1;
    private final int HEAD_FOOT = 2;
    private Context mContext;

    private HomePageHeadBean homePageHeadBean;

    public void setData(HomePageHeadBean homePageHeadBean) {
        this.homePageHeadBean = homePageHeadBean;
    }

    public HomePageHeadBean getHomePageHeadBean(){

        return homePageHeadBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        if (viewType == HEAD_ITEM) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_adapter_item, parent, false);
            return new MyViewHold(inflate);
        } else if (viewType == HEAD_VIEW) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_page_head_item, parent, false);
            return new MyHeadViewHold(inflate);
        }else if (viewType==HEAD_FOOT){

            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_foot_item_view, parent, false);
            return new MyFootViewHold(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        if (homePageHeadBean != null) {

            if (getItemViewType(position) == HEAD_VIEW) {

                String name = homePageHeadBean.getRes().getAlbum().getName();
                final String image = homePageHeadBean.getRes().getAlbum().getLcover();
                String description = homePageHeadBean.getRes().getAlbum().getDesc();

                Picasso.with(mContext).load(image).into(((MyHeadViewHold)holder).imageView);
                ((MyHeadViewHold)holder).textView.setText(description);


            } else if (getItemViewType(position) == HEAD_ITEM) {

                final HomePageHeadBean.ResBean.WallpaperBean wallpaperBean = homePageHeadBean.getRes().getWallpaper().get(position - 1);
                String small = wallpaperBean.getThumb();
                Picasso.with(mContext).load(small).placeholder(R.mipmap.image_load).error(R.mipmap.image_erry).into(((MyViewHold) holder).imageView);
                ((MyViewHold)holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ImageBeanUrl imageBeanUrl = new ImageBeanUrl();
                        imageBeanUrl.setBig(String.format(Constants.maxImageLoadUrl,wallpaperBean.getId(), Utils.getScreenDispaly(mContext)[0]*2+"x"+Utils.getScreenDispaly(mContext)[1]));
                        imageBeanUrl.setDiy(wallpaperBean.getPreview());
                        imageBeanUrl.setOriginal(wallpaperBean.getThumb());
                        imageBeanUrl.setVip_original(wallpaperBean.getWp());
                        onClickListener.clickListener(v,position,imageBeanUrl);
                    }
                });
            }else if (getItemViewType(position) == HEAD_FOOT){

            }
        }
    }

    @Override
    public int getItemCount() {
        if (homePageHeadBean != null && homePageHeadBean.getRes().getWallpaper().size() > 0) {
            return homePageHeadBean.getRes().getWallpaper().size() + 2;
        }
        return 0;
    }

    public class MyViewHold extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private ImageView imageView;

        public MyViewHold(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);

        }
    }

    public class MyHeadViewHold extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;

        public MyHeadViewHold(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    public class MyFootViewHold extends RecyclerView.ViewHolder{

        public MyFootViewHold(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD_VIEW;
        }else if (getItemCount()-1==position){
            return HEAD_FOOT;
        }
        return HEAD_ITEM;
    }

    public OnClickListener onClickListener;
    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }
}
