package com.android.cgcxy.wallpaper.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public class GriddingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private HompPagerBean hompPagerBean;
    private Context mContext;
    private static final int TYPE_HEADER = 1, TYPE_ITEM = 2;
private List<ImageView> imageViews;
    public GriddingAdapter(Context context) {

        mContext = context;

    }

    public void setData(HompPagerBean hompPagerBean){
        this.hompPagerBean = hompPagerBean;
    }

    public void setHandData(List<ImageView> imageViews){
        this.imageViews=imageViews;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType==TYPE_HEADER){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_adater_hand_item, parent, false);
            return new MyViewPager(inflate);
        }else if (viewType==TYPE_ITEM) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_adapter_item, parent, false);
            MyViewHole hole = new MyViewHole(inflate);
            return hole;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (hompPagerBean!=null){
            if (holder.getItemViewType()==TYPE_HEADER) {

                ViewPageAdapter viewPageAdapter = new ViewPageAdapter();
                ((MyViewPager)holder).viewPager.setAdapter(viewPageAdapter);

            }else if (holder.getItemViewType()==TYPE_ITEM) {
                HompPagerBean.DataBean dataBean = hompPagerBean.getData().get(position-1);
                String small = dataBean.getImage().getSmall();
                String[] url = small.split(",");
                small = url[0] + ",200,300." + url[url.length - 1].split("\\.")[1];
                Picasso.with(mContext).load(small).into(((MyViewHole)holder).imageView);
                ((MyViewHole)holder).tv_title.setText(dataBean.getTags().get(0).getName());
            }
        }
    }

    @Override
    public int getItemCount() {
        if (hompPagerBean!=null) {
            return hompPagerBean.getData().size()+1;
        }
        return 0;
    }

    public class MyViewHole extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private ImageView imageView;
        public MyViewHole(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            imageView= (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public class MyViewPager extends RecyclerView.ViewHolder{

        private ViewPager viewPager;

        public MyViewPager(View itemView) {
            super(itemView);
            viewPager= (ViewPager) itemView.findViewById(R.id.viewpager);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position = position == 0 ? TYPE_HEADER : TYPE_ITEM;
    }

    public class ViewPageAdapter extends PagerAdapter {


        @Override
        public int getCount() {

            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(imageViews.get(position));
            return imageViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));
        }
    }
}
