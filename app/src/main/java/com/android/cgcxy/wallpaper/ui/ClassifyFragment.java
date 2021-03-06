package com.android.cgcxy.wallpaper.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.ClassifyAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.base.OnClickListener;
import com.android.cgcxy.wallpaper.bean.ClassifyBean;
import com.android.cgcxy.wallpaper.bean.ImageBeanUrl;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.homepageui.ClassifySubClassFragment;

import java.util.Collections;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends BaseFragment implements OnClickListener{


    private MainPresenterImple mainPresenterImple;
    private String TAG="ClassifyFragment";
    private RecyclerView recycle;
    private ClassifyAdapter classifyAdapter;
    private ClassifyBean datas;

    public ClassifyFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_classify;
    }

    @Override
    public void initAttach() {
        mainPresenterImple = new MainPresenterImple(this,getContext());
    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        mainPresenterImple.getClassifyFragmnetDatajson();
    }


    @Override
    public void findView() {


        recycle = findViewById(R.id.recycleView);
    }


    @Override
    public void initView() {


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        recycle.setLayoutManager(gridLayoutManager);

        classifyAdapter = new ClassifyAdapter();
        classifyAdapter.setOnClickListener(this);
        recycle.setAdapter(classifyAdapter);
    }


    @Override
    public <T> void setData(T t) {
        super.setData(t);
        classifyAdapter.setData((ClassifyBean) t);
        classifyAdapter.notifyDataSetChanged();
        datas = (ClassifyBean) t;
    }



    @Override
    public <T> void setNextData(T t) {

    }

    /**
     * Item 点击事件
     * @param view
     * @param position
     */
    @Override
    public void clickListener(View view, int position, ImageBeanUrl imageBeanUrl) {
        ClassifySubClassFragment classFragment = ClassifySubClassFragment.newInstance(String.format(Constants.categoryDetails,datas.getRes().getCategory().get(position).getId()),datas.getRes().getCategory().get(position).getName(),datas.getRes().getCategory().get(position).getId());
        getBaseActivity().commitFragment(R.id.fragmeLaout,classFragment,true);
    }
}
