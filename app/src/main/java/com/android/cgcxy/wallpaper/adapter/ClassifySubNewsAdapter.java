package com.android.cgcxy.wallpaper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.OnClickListener;
import com.android.cgcxy.wallpaper.bean.ClassifySubBean;
import com.android.cgcxy.wallpaper.bean.ImageBeanUrl;
import com.squareup.picasso.Picasso;

/**
 * Created by chuangguo.qi on 2017/7/21.
 */

public class ClassifySubNewsAdapter extends RecyclerView.Adapter{

    private static final String TAG ="ClassifySubNewsAdapter" ;
    private ClassifySubBean classifySubBean;

    private final int TYPE_FOOT=1;
    private final int TYPE_ITEM=2;
    private Context mContext;
    public void setData(ClassifySubBean classifySubBean){
        Log.i(TAG, "setData: ");
        this.classifySubBean = classifySubBean;
    }
    public ClassifySubBean getClassifySubBean(){
        return classifySubBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        if (viewType==TYPE_FOOT){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_foot_item_view, parent, false);
            return new MyFootViewHold(inflate);
        }else if (viewType==TYPE_ITEM){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_adapter_item, parent, false);
            return new MyItemViewHold(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (classifySubBean!=null && classifySubBean.getData().size()>0){
            if (getItemViewType(position)==TYPE_ITEM){

                String small = classifySubBean.getData().get(position).getImage().getSmall();
                String[] url = small.split(",");
               // small = url[0] + ",200,300." + url[url.length - 1].split("\\.")[1];
                Picasso.with(mContext).load(small).placeholder(R.mipmap.image_load).error(R.mipmap.image_erry).into(((MyItemViewHold)holder).imageView);
                ((MyItemViewHold)holder).tv_title.setText(classifySubBean.getName());
                ((MyItemViewHold)holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageBeanUrl imageBeanUrl = new ImageBeanUrl();
                        imageBeanUrl.setBig(classifySubBean.getData().get(position).getImage().getBig());
                        imageBeanUrl.setDiy(classifySubBean.getData().get(position).getImage().getDiy());
                        imageBeanUrl.setOriginal(classifySubBean.getData().get(position).getImage().getOriginal());
                        imageBeanUrl.setVip_original(classifySubBean.getData().get(position).getImage().getVip_original());
                        imageBeanUrl.setSmall(classifySubBean.getData().get(position).getImage().getSmall());
                        onClickListener.clickListener(v,position,imageBeanUrl);
                    }
                });

            }else if (getItemViewType(position)==TYPE_FOOT){

            }
        }
    }

    @Override
    public int getItemCount() {
        if (classifySubBean!=null && classifySubBean.getData().size()>0) {
            return classifySubBean.getData().size() + 1;
        }else {
            return 0;
        }
    }

    public class MyItemViewHold extends RecyclerView.ViewHolder{
        private TextView tv_title;
        private ImageView imageView;
        public MyItemViewHold(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public class MyFootViewHold extends RecyclerView.ViewHolder{

        public MyFootViewHold(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==getItemCount()-1){
            return TYPE_FOOT;
        }else {
            return TYPE_ITEM;
        }

    }

    public OnClickListener onClickListener;
    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }
}
