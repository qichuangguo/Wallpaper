package com.android.cgcxy.wallpaper.adapter;

import android.content.Context;
import android.support.v4.text.util.LinkifyCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.bean.LuckGiveBean;
import com.squareup.picasso.Picasso;

/**
 * Created by chuangguo.qi on 2017/7/24.
 */

public class LuckGiveAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context mContext;
    public LuckGiveBean getLuckGiveBean() {
        return luckGiveBean;
    }

    private LuckGiveBean luckGiveBean;
    public void setData(LuckGiveBean luckGiveBean){
        this.luckGiveBean = luckGiveBean;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_adapter_item, parent, false);
        return new MyItemHold(inflate);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (luckGiveBean!=null){

            LuckGiveBean.DataBean dataBean = luckGiveBean.getData().get(position);
            Picasso.with(mContext).load(dataBean.getImage().getSmall()).placeholder(R.mipmap.image_load).error(R.mipmap.image_erry).into( ((MyItemHold)holder).imageView);

            ((MyItemHold) holder).textView.setText(dataBean.getTags().get(0).getName());
        }
    }

    @Override
    public int getItemCount() {
        if (luckGiveBean!=null && luckGiveBean.getData().size()>0){
            return luckGiveBean.getData().size();
        }
        return 0;
    }

    public class MyItemHold extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        public MyItemHold(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }
}
