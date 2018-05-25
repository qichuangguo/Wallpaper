package com.android.cgcxy.wallpaper.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.OnClickListener;

/**
 * Created by chuangguo.qi on 2018/5/25.
 */

public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected final int HEAD_VIEW = 0;
    protected final int HEAD_ITEM = 1;
    protected final int HEAD_FOOT = 2;
    protected Context mContent;

    public  BaseRecyclerAdapter(Context context){
        this.mContent = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == HEAD_ITEM) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_adapter_item, parent, false);
            return new BaseViewHold(inflate);
        } else if (viewType == HEAD_VIEW) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_adapter_item, parent, false);
            return  new BaseViewHold(inflate);
        }else if (viewType==HEAD_FOOT){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_foot_item_view, parent, false);
            return  new BaseViewHold(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOnClick(v,position-1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getCount();
    }

    protected abstract int getCount();

    protected abstract void setOnClick(View v, int position);

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return HEAD_VIEW;
        }else if (getItemCount()-1==position){
            return HEAD_FOOT;
        }
        return HEAD_ITEM;
    }

    protected OnClickListener onClickListener;
    public void setItemOnclick(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
}
