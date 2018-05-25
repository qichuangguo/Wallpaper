package com.android.cgcxy.wallpaper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.bean.ImageBeanUrl;
import com.android.cgcxy.wallpaper.bean.LandsCapeWallpaperBean;
import com.android.cgcxy.wallpaper.utils.Utils;
import com.squareup.picasso.Picasso;

import java.net.URL;
import java.util.List;

/**
 * Created by chuangguo.qi on 2018/5/25.
 */

public class LandscapeWallpaperAdapter extends BaseRecyclerAdapter {


    private LandsCapeWallpaperBean landsCapeWallpaperBean;
    private List<LandsCapeWallpaperBean.ResBean.WallpaperBean> handLandsCapeWallpaperBean;

    public LandscapeWallpaperAdapter(Context context) {
        super(context);
    }

    public void setData(LandsCapeWallpaperBean landsCapeWallpaperBean){
        this.landsCapeWallpaperBean = landsCapeWallpaperBean;
    }

    public void setHeadData(List<LandsCapeWallpaperBean.ResBean.WallpaperBean> landsCapeWallpaperBean){
        this.handLandsCapeWallpaperBean = landsCapeWallpaperBean;
    }

    public LandsCapeWallpaperBean getDataBean(){
        return landsCapeWallpaperBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==HEAD_VIEW){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.landscape_wallpaper_hand, parent, false);
            return new MyViewHold(inflate,viewType);
        }else if (viewType==HEAD_ITEM){
            return super.onCreateViewHolder(parent,viewType);
        }else if (viewType==HEAD_FOOT){
            return super.onCreateViewHolder(parent,viewType);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position)==HEAD_ITEM) {
            super.onBindViewHolder(holder,position);
            BaseViewHold myViewHold = ((BaseViewHold) holder);
            LandsCapeWallpaperBean.ResBean.WallpaperBean wallpaperBean = landsCapeWallpaperBean.getRes().getWallpaper().get(position-1);
            String img = wallpaperBean.getImg();
            String rule = wallpaperBean.getRule();
            String url=Utils.bitMapUrlSplice(mContent,img,rule,350,540);
            Picasso.with(mContent).load(url).placeholder(R.mipmap.image_load).error(R.mipmap.image_erry).into(myViewHold.previewIv);
        }else if (getItemViewType(position)==HEAD_VIEW){
            MyViewHold myViewHold = ((MyViewHold) holder);
            LandsCapeWallpaperBean.ResBean.WallpaperBean wallpaperBean = handLandsCapeWallpaperBean.get(0);
            String img = wallpaperBean.getImg();
            String rule = wallpaperBean.getRule();
            String url=Utils.bitMapUrlSplice(mContent,img,rule,540,540);
            Picasso.with(mContent).load(url).placeholder(R.mipmap.image_load).error(R.mipmap.image_erry).into(myViewHold.classifyIv);

            LandsCapeWallpaperBean.ResBean.WallpaperBean wallpaperBean1 = handLandsCapeWallpaperBean.get(1);
            String img1 = wallpaperBean1.getImg();
            String rule1 = wallpaperBean1.getRule();
            String url1=Utils.bitMapUrlSplice(mContent,img1,rule1,540,540);
            Picasso.with(mContent).load(url1).placeholder(R.mipmap.image_load).error(R.mipmap.image_erry).into(myViewHold.newIv);
        }

    }

    @Override
    protected void setOnClick(View v, int position) {
        LandsCapeWallpaperBean.ResBean.WallpaperBean wallpaperBean = landsCapeWallpaperBean.getRes().getWallpaper().get(position);
        String img = wallpaperBean.getImg();
        String rule = wallpaperBean.getRule();
        String url=Utils.bitMapUrlSplice(mContent,img,rule);
        ImageBeanUrl imageBeanUrl = new ImageBeanUrl();
        imageBeanUrl.setBig(url);
        onClickListener.clickListener(v,position,imageBeanUrl);

    }

    @Override
    protected int getCount() {
        if (landsCapeWallpaperBean!=null && landsCapeWallpaperBean.getRes().getWallpaper().size()>0){
            return landsCapeWallpaperBean.getRes().getWallpaper().size()+2;

        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public class MyViewHold extends BaseViewHold{

        public ImageView classifyIv;
        public ImageView newIv;
        public MyViewHold(View itemView,int itemType) {
            super(itemView);
            if (itemType==HEAD_VIEW){
                classifyIv= (ImageView) itemView.findViewById(R.id.classifyIv);
                newIv= (ImageView) itemView.findViewById(R.id.newIv);
            }
        }
    }
}
