package com.android.cgcxy.wallpaper.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.HomePage;
import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.OnClickListener;
import com.android.cgcxy.wallpaper.bean.HeadBean;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.android.cgcxy.wallpaper.bean.ImageBeanUrl;
import com.android.cgcxy.wallpaper.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;

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
    private List<HeadBean> imageViews;
    private List<ImageView> imageViewPoint;
    private List<String> headerString;
    TextView titleView;

    public void setHeaderString(List<String> headerString) {
        this.headerString = headerString;
    }


    public GriddingAdapter(Context context) {

        mContext = context;

    }

    public void setData(HompPagerBean hompPagerBean){
        if (this.hompPagerBean==null) {
            this.hompPagerBean = hompPagerBean;
        }else {

            this.hompPagerBean.getRes().getVertical().addAll(hompPagerBean.getRes().getVertical());
        }
    }



    public void setHandData(List<HeadBean> imageViews){
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
                final HompPagerBean.ResBean.VerticalBean verticalBean = hompPagerBean.getRes().getVertical().get(position - 1);
                String small = verticalBean.getThumb();
                Picasso.with(mContext).load(small).placeholder(R.mipmap.image_load).error(R.mipmap.image_erry).into(((MyViewHole)holder).imageView);
                ((MyViewHole)holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageBeanUrl imageBeanUrl = new ImageBeanUrl();
                        String rule = verticalBean.getRule();
                        if (!TextUtils.isEmpty(rule)){
                            String  url  = verticalBean.getPreview()+rule.replaceAll("\\$<Width>", Utils.getScreenDispaly(mContext)[0]+"").replaceAll("\\$<Height>",Utils.getScreenDispaly(mContext)[1]+"");
                            imageBeanUrl.setBig(url);
                        }else {
                            imageBeanUrl.setBig(verticalBean.getImg());
                        }
                        imageBeanUrl.setDiy(verticalBean.getPreview());
                        imageBeanUrl.setOriginal(verticalBean.getThumb());
                        imageBeanUrl.setVip_original(verticalBean.getWp());
                        onClickListener.clickListener(v,position,imageBeanUrl);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        if (hompPagerBean!=null) {
            return hompPagerBean.getRes().getVertical().size() + 2;
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
            titleView = (TextView) itemView.findViewById(R.id.titleView);
            viewPageAdapter = new ViewPageAdapter();
            viewPager.setAdapter(viewPageAdapter);
            if (imageViewPoint!=null && imageViewPoint.size()>0){

                for (int i = 0; i <imageViewPoint.size() ; i++) {
                    linerLayout.addView(imageViewPoint.get(i));
                }

            }
            titleView.setText(imageViews.get(0).getTitle());
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
            HeadBean headBean = imageViews.get(position);
            container.addView(headBean.getImageView());
            return imageViews.get(position).getImageView();
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            HeadBean headBean = imageViews.get(position);
            container.removeView(headBean.getImageView());
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

                    if (titleView!=null){
                        titleView.setText(imageViews.get(position).getTitle());
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
