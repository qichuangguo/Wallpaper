package com.android.cgcxy.wallpaper.ui;


import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.GriddingAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends BaseFragment implements ShowView{


    private MainPresenterImple mainPresenterImple;
    private RecyclerView recyclerView;
    private GriddingAdapter griddingAdapter;
    private List<ImageView> imageViews = new ArrayList<>();

    public HomePageFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_blank;
    }


    @Override
    public void initView() {
        mainPresenterImple = new MainPresenterImple(this,getContext());
        mainPresenterImple.getHomePageFragmnetDataJson();
        final GridLayoutManager gridLayoutManager = new  GridLayoutManager(getActivity(),3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                position = position == 0 ? gridLayoutManager.getSpanCount() : 1;
                return position;
            }
        });
        recyclerView.setLayoutManager(gridLayoutManager);
        griddingAdapter = new GriddingAdapter(getContext());
        recyclerView.setAdapter(griddingAdapter);


    }

    @Override
    public void findView() {
        recyclerView = findViewById(R.id.recycleView);

    }


    @Override
    public <T> void setData(T t) {
        griddingAdapter.setData((HompPagerBean) t);

        List<HompPagerBean.SliderBean> slider = ((HompPagerBean) t).getSlider();
        if (slider!=null && slider.size()>0) {
            for (int i = 0; i < slider.size(); i++) {
                ImageView imageView = new ImageView(getContext());
                Picasso.with(getContext()).load(slider.get(i).getImage()).into(imageView);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageViews.add(imageView);
            }
            griddingAdapter.setHandData(imageViews);
        }
        griddingAdapter.notifyDataSetChanged();
    }



}
