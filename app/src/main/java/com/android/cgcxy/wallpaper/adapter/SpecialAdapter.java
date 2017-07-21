package com.android.cgcxy.wallpaper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.bean.SpeCialBean;
import com.squareup.picasso.Picasso;

/**
 * Created by chuangguo.qi on 2017/7/21.
 */

public class SpecialAdapter extends RecyclerView.Adapter {

    private final int TYPE_ITEM = 0;
    private final int TYPE_FOOT = 1;
    private SpeCialBean speCialBean;
    private Context mContext;
    public void setData(SpeCialBean speCialBean) {
        this.speCialBean = speCialBean;
    }

    public SpeCialBean getSpeCialBean() {

        return speCialBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        if (viewType == TYPE_FOOT) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_foot_item_view, parent, false);
            return new MyFootViewHold(inflate);
        } else if (viewType == TYPE_ITEM) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_adapter_item, parent, false);
            return new MyItemHold(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (speCialBean!=null){
            if (getItemViewType(position)==TYPE_FOOT){

            }else if (getItemViewType(position)==TYPE_ITEM){
                String image = speCialBean.getData().get(position).getImage();
                Picasso.with(mContext).load(image).placeholder(R.mipmap.image_load).error(R.mipmap.image_erry).into(((MyItemHold)holder).imageView);
                ((MyItemHold)holder).textView.setText(speCialBean.getData().get(position).getDescription());
            }
        }

    }

    @Override
    public int getItemCount() {
        if (speCialBean != null && speCialBean.getData().size() > 0) {
            return speCialBean.getData().size()+1;
        } else {
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == getItemCount() - 1) {
            return TYPE_FOOT;
        } else {
            return TYPE_ITEM;
        }

    }

    public class MyItemHold extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;
        public MyItemHold(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

    public class MyFootViewHold extends RecyclerView.ViewHolder {


        public MyFootViewHold(View itemView) {
            super(itemView);
        }
    }

}
