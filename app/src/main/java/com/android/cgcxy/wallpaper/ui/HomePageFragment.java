package com.android.cgcxy.wallpaper.ui;


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.GriddingAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.HeadBean;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.android.cgcxy.wallpaper.bean.ImageBeanUrl;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.homepageui.HomePageHeadFragment;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends BaseFragment {


    private MainPresenterImple mainPresenterImple;
    private RecyclerView recyclerView;
    private GriddingAdapter griddingAdapter;
    private List<HeadBean> imageViews = new ArrayList<>();
    boolean isLoading = false;
    private List<ImageView> imageViewPoint = new ArrayList<>();
    private String TAG = "HomePageFragment";
    private List<ImageBeanUrl> datas;
    private int index=0;

    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    public void initAttach() {
        mainPresenterImple = new MainPresenterImple(this,getContext());
    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        mainPresenterImple.getHomePageFragmnetDataJson();
    }


    @Override
    public void initView() {
        datas = new ArrayList<ImageBeanUrl>();
        final GridLayoutManager gridLayoutManager = new  GridLayoutManager(getActivity(),3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return gridLayoutManager.getSpanCount();
                } else if (position == griddingAdapter.getItemCount() - 1) {
                    return gridLayoutManager.getSpanCount();
                } else {

                    return 1;
                }

            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        griddingAdapter = new GriddingAdapter(getContext());
        griddingAdapter.setOnclick(this);
        recyclerView.setAdapter(griddingAdapter);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            int lastVisibleItem = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.i(TAG, "onScrollStateChanged: lastVisibleItem:" + lastVisibleItem + "::" + griddingAdapter.getItemCount() + "::" + isLoading);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == griddingAdapter.getItemCount() && !isLoading) {
                    mainPresenterImple.getHomePageFragmentNextDatajson(index);
                    isLoading = true;
                    Log.i(TAG, "onScrollStateChanged: ");
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = gridLayoutManager.findLastVisibleItemPosition();
            }
        });

    }

    @Override
    public void findView() {
        recyclerView = findViewById(R.id.recycleView);

    }


    @Override
    public <T> void setData(T t) {
        super.setData(t);
        index++;
        griddingAdapter.setData((HompPagerBean) t);
        List<HompPagerBean.ResBean.HomepageBean> homepage = ((HompPagerBean) t).getRes().getHomepage();
        if (homepage != null && homepage.size() > 0) {
            HompPagerBean.ResBean.HomepageBean homepageBean = homepage.get(0);
            List<HompPagerBean.ResBean.HomepageBean.ItemsBean> items = homepageBean.getItems();
            if (items!=null && items.size()>0) {
                imageViewPoint.clear();
                imageViews.clear();
                for (int i = 0; i < items.size(); i++) {
                    int sn = items.get(i).getValue().getSn();
                    if (sn!=999){
                        continue;
                    }
                    HeadBean headBean = new HeadBean();
                    ImageView imageView = new ImageView(getContext());
                    setHeadOnclick(imageView,String.format(Constants.HomePageHead,items.get(i).getTarget()),items.get(i).getValue().getName());
                    Picasso.with(getContext()).load(items.get(i).getThumb()).into(imageView);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    headBean.setTitle(items.get(i).getValue().getName());
                    headBean.setImageView(imageView);
                    imageViews.add(headBean);

                    ImageView imageView1 = new ImageView(getContext());
                    if (i == 0) {
                        imageView1.setImageResource(R.drawable.cricle_shape2);
                    } else {
                        imageView1.setImageResource(R.drawable.cricle_shape1);
                    }
                    imageView1.setPadding(10, 10, 10, 10);
                    imageViewPoint.add(imageView1);

                }
                griddingAdapter.setHandData(imageViews);
                griddingAdapter.setHandPointImage(imageViewPoint);
            }
        }
        griddingAdapter.notifyDataSetChanged();
    }

    @Override
    public <T> void setNextData(T t) {

        isLoading = false;
        griddingAdapter.setData((HompPagerBean) t);
        griddingAdapter.notifyDataSetChanged();
        index++;
    }

    public void setHeadOnclick(ImageView iv, final String url, final String title){

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getBaseActivity().commitFragment(R.id.fragmeLaout,HomePageHeadFragment.newInstance(url,title),true);

            }
        });

    }


}
