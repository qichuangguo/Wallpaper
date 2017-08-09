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
import com.android.cgcxy.wallpaper.bean.EveryDaySubBean;
import com.android.cgcxy.wallpaper.bean.ImageBeanUrl;
import com.squareup.picasso.Picasso;

import javax.xml.validation.TypeInfoProvider;

/**
 * Created by chuangguo.qi on 2017/7/24.
 */

public class EveryDaySubAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{



    private EveryDaySubBean everyDaySubBean;
    private Context mContext;
    private final int TYPE_ITEM=0;
    private final int TYPE_FOOT=1;


    public void setData( EveryDaySubBean everyDaySubBean){
        this.everyDaySubBean = everyDaySubBean;
    }

    public EveryDaySubBean getEveryDaySubBean() {
        return everyDaySubBean;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        if (viewType==TYPE_FOOT){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_foot_item_view, parent, false);
            return  new MyFootViewHold(inflate);
        }else if (viewType== TYPE_ITEM){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_adapter_item, parent, false);
            return  new MyItemViewHold(inflate);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (everyDaySubBean!=null){

            if (getItemViewType(position)==TYPE_FOOT){


            }else if (getItemViewType(position)==TYPE_ITEM){

                final EveryDaySubBean.DataBean dataBean = everyDaySubBean.getData().get(position);
                Picasso.with(mContext).load(dataBean.getImage().getSmall()).placeholder(R.mipmap.image_load).error(R.mipmap.image_erry).into(((MyItemViewHold)holder).imageView);

                ((MyItemViewHold)holder).textView.setText(dataBean.getTags().get(0).getName());
                ((MyItemViewHold)holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        ImageBeanUrl imageBeanUrl = new ImageBeanUrl();
                        imageBeanUrl.setBig(dataBean.getImage().getBig());
                        imageBeanUrl.setDiy(dataBean.getImage().getDiy());
                        imageBeanUrl.setOriginal(dataBean.getImage().getOriginal());
                        imageBeanUrl.setVip_original(dataBean.getImage().getVip_original());
                        imageBeanUrl.setSmall(dataBean.getImage().getSmall());

                        onClickListener.clickListener(v,position,imageBeanUrl);
                    }
                });

            }
        }
    }

    @Override
    public int getItemCount() {
        if (everyDaySubBean!=null && everyDaySubBean.getData().size()>0){
            return everyDaySubBean.getData().size()+1;
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==getItemCount()-1){
            return TYPE_FOOT;
        }else {
            return TYPE_ITEM;
        }
    }

    public class MyItemViewHold extends RecyclerView.ViewHolder{

        private ImageView imageView;
        private TextView textView;
        public MyItemViewHold(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);
            textView = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

    public class MyFootViewHold extends RecyclerView.ViewHolder{

        public MyFootViewHold(View itemView) {
            super(itemView);
        }
    }

    public OnClickListener onClickListener;
    public void setOnClickListener(OnClickListener onClickListener){
        this.onClickListener=onClickListener;
    }
}
