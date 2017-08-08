package com.android.cgcxy.wallpaper.ui;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.GriddingAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.base.OnClickListener;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.browseui.SpecialFragment;
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
    private List<ImageView> imageViews = new ArrayList<>();
    boolean isLoading = false;
    private List<ImageView> imageViewPoint = new ArrayList<>();
    private String TAG = "HomePageFragment";

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

        recyclerView.setAdapter(griddingAdapter);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            int lastVisibleItem = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.i(TAG, "onScrollStateChanged: lastVisibleItem:" + lastVisibleItem + "::" + griddingAdapter.getItemCount() + "::" + isLoading);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem + 1 == griddingAdapter.getItemCount() && !isLoading) {
                    mainPresenterImple.getHomePageFragmentNextDatajson();
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

        griddingAdapter.setOnclick(new OnClickListener() {
            @Override
            public void clickListener(View view, int position) {

                Intent intent = new Intent(getBaseActivity(),SetWallpaperActivity.class);
                intent.putExtra("url",griddingAdapter.getHompPagerBean().getData().get(position-1).getImage().getBig());
                startActivity(intent);

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
        griddingAdapter.setData((HompPagerBean) t);

        List<HompPagerBean.SliderBean> slider = ((HompPagerBean) t).getSlider();
        if (slider!=null && slider.size()>0) {
            imageViewPoint.clear();
            imageViews.clear();
            for (int i = 0; i < slider.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                setHeadOnclick(imageView,slider.get(i).getDetail(),slider.get(i).getName());
                Picasso.with(getContext()).load(slider.get(i).getImage()).into(imageView);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageViews.add(imageView);

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
        griddingAdapter.notifyDataSetChanged();
    }

    @Override
    public <T> void setNextData(T t) {

        isLoading = false;
        griddingAdapter.setData((HompPagerBean) t);
        griddingAdapter.notifyDataSetChanged();
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
