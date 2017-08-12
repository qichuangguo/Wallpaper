package com.android.cgcxy.wallpaper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.OnClickListener;
import com.android.cgcxy.wallpaper.bean.ClassifyBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/19.
 */

public class ClassifyAdapter extends RecyclerView.Adapter<ClassifyAdapter.MyViewHold> {

    private List<ClassifyBean> datas;
    private Context mContext;
    private OnClickListener onClickListener;

    public void setData(List<ClassifyBean> datas) {
        this.datas = datas;
    }

    @Override
    public MyViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.classify_adapter_item, parent, false);
        this.mContext = parent.getContext();
        return new MyViewHold(inflate);
    }

    @Override
    public void onBindViewHolder(MyViewHold holder, final int position) {
        if (datas != null && datas.size() > 0) {

            holder.tv_title.setText(datas.get(position).getName());
            Picasso.with(mContext).load(datas.get(position).getIcon()).placeholder(R.mipmap.image_load).into(holder.imageView);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.clickListener(v,position,null);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (datas != null && datas.size() > 0) {
            return datas.size();
        }
        return 0;
    }

    public class MyViewHold extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView tv_title;

        public MyViewHold(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);

        }
    }

    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

}
