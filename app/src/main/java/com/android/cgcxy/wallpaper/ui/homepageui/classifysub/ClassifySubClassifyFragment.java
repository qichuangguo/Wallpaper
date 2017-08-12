package com.android.cgcxy.wallpaper.ui.homepageui.classifysub;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.ClassifySubAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.base.OnClickListener;
import com.android.cgcxy.wallpaper.bean.ClassifySubBean;
import com.android.cgcxy.wallpaper.bean.ImageBeanUrl;
import com.android.cgcxy.wallpaper.mode.RefreshListener;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.homepageui.classifysub.classifysub.ClassifyChildishSubFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifySubClassifyFragment extends BaseFragment implements RefreshListener, OnClickListener {


    private static final String TAG = "ClassifySubClassifyFragment";
    private ClassifySubBean classifySubBean;
    private RecyclerView recycle;
    private ClassifySubAdapter classifyAdapter;

    public ClassifySubClassifyFragment() {
        // Required empty public constructor
    }

    public static ClassifySubClassifyFragment newInstance() {

        Bundle args = new Bundle();
        ClassifySubClassifyFragment fragment = new ClassifySubClassifyFragment();
        return fragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_classify_sub_classify;
    }

    @Override
    public void initAttach() {

    }

    @Override
    public void findView() {


        recycle = findViewById(R.id.recycleView);
    }

    @Override
    public void initView() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        recycle.setLayoutManager(gridLayoutManager);

        classifyAdapter = new ClassifySubAdapter();
        classifyAdapter.setOnClickListener(this);
        recycle.setAdapter(classifyAdapter);
    }

    public void getData(ClassifySubBean classifySubBean) {
        this.classifySubBean = classifySubBean;
        if (classifyAdapter!=null) {
            classifyAdapter.setData(classifySubBean.getTags());
            classifyAdapter.notifyDataSetChanged();
        }

    }


    @Override
    public <T> void resultListener(T t) {

    }

    @Override
    public <E> void onError(E e) {

    }

    @Override
    public void clickListener(View view, int position, ImageBeanUrl imageBeanUrl) {
        ClassifyChildishSubFragment classifyChildishSubFragment = ClassifyChildishSubFragment.newInstance(classifySubBean.getTags().get(position).getUrl(),classifySubBean.getTags().get(position).getName());
        getBaseActivity().commitFragment(R.id.fragmeLaout, classifyChildishSubFragment, true);
    }
}
