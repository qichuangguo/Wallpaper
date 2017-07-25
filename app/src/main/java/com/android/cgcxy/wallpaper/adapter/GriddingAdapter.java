package com.android.cgcxy.wallpaper.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.OnClickListener;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.squareup.picasso.Picasso;

import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.logging.Handler;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public class GriddingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG ="GriddingAdapter" ;

    public HompPagerBean getHompPagerBean() {
        return hompPagerBean;
    }

    private HompPagerBean hompPagerBean;
    private Context mContext;
    private static final int TYPE_HEADER = 1, TYPE_ITEM = 2,TYPE_FOOT=3;
    private List<ImageView> imageViews;
    private List<ImageView> imageViewPoint;

    public GriddingAdapter(Context context) {

        mContext = context;

    }

    public void setData(HompPagerBean hompPagerBean){
        if (this.hompPagerBean==null) {
            this.hompPagerBean = hompPagerBean;
        }else {

            this.hompPagerBean.getData().addAll(hompPagerBean.getData());
        }
    }



    public void setHandData(List<ImageView> imageViews){
        this.imageViews=imageViews;
    }

    public void setHandPointImage(List<ImageView> imageViewPoint){

        this.imageViewPoint = imageViewPoint;
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
        }else if (viewType==TYPE_FOOT){
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.gridding_foot_item_view, parent, false);
            return new MyFootViewHold(inflate);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (hompPagerBean!=null){
            if (holder.getItemViewType()==TYPE_HEADER) {

            }else if (holder.getItemViewType()==TYPE_ITEM) {
                HompPagerBean.DataBean dataBean = hompPagerBean.getData().get(position-1);
                String small = dataBean.getImage().getSmall();
                String[] url = small.split(",");
               // small = url[0] + ",200,300." + url[url.length - 1].split("\\.")[1];
                Picasso.with(mContext).load(small).placeholder(R.mipmap.image_load).error(R.mipmap.image_erry).into(((MyViewHole)holder).imageView);
                ((MyViewHole)holder).tv_title.setText(dataBean.getTags().get(0).getName());
                ((MyViewHole)holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListener.clickListener(v,position);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        if (hompPagerBean!=null) {
            return hompPagerBean.getData().size()+2;
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
        private LinearLayout linerLayout;
        private final ViewPageAdapter viewPageAdapter;

        public MyViewPager(View itemView) {
            super(itemView);
            viewPager= (ViewPager) itemView.findViewById(R.id.viewpager);
            linerLayout = (LinearLayout) itemView.findViewById(R.id.linerLayout);
            viewPageAdapter = new ViewPageAdapter();
            viewPager.setAdapter(viewPageAdapter);
            if (imageViewPoint!=null && imageViewPoint.size()>0){

                for (int i = 0; i <imageViewPoint.size() ; i++) {
                    linerLayout.addView(imageViewPoint.get(i));
                }

            }
            setViewPagerChangLiner(viewPager);

        }
    }

    public class MyFootViewHold extends RecyclerView.ViewHolder{

        public MyFootViewHold(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TYPE_HEADER;
        }else if (position==getItemCount()-1){
            return TYPE_FOOT;
        }else {
            return TYPE_ITEM;
        }

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

    public void setViewPagerChangLiner(ViewPager viewPager){
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (imageViewPoint!=null && imageViewPoint.size()>0){
                    imageViewPoint.get(position).setImageResource(R.drawable.cricle_shape2);

                    for (int i = 0; i <imageViewPoint.size() ; i++) {
                        if (position!=i){
                            imageViewPoint.get(i).setImageResource(R.drawable.cricle_shape1);
                        }
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.i(TAG, "onPageScrollStateChanged: state:"+state);
            }
        });

    }

    private OnClickListener onClickListener;
    public void setOnclick(OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }


}
