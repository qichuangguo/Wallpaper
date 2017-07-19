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
import com.android.cgcxy.wallpaper.bean.ClassifyBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends BaseFragment implements ShowView{


    private MainPresenterImple mainPresenterImple;
    private String TAG="ClassifyFragment";
    private RecyclerView recycle;
    private ClassifyAdapter classifyAdapter;

    public ClassifyFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_classify;
    }


    @Override
    public void findView() {

        recycle = findViewById(R.id.recycleView);
    }


    @Override
    public void initView() {
        mainPresenterImple = new MainPresenterImple(this,getContext());
        mainPresenterImple.getClassifyFragmnetDatajson();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        recycle.setLayoutManager(gridLayoutManager);

        classifyAdapter = new ClassifyAdapter();
        recycle.setAdapter(classifyAdapter);

    }


    @Override
    public <T> void setData(T t) {
        List<ClassifyBean> datas = (List<ClassifyBean>) t;
        classifyAdapter.setData(datas);
        classifyAdapter.notifyDataSetChanged();
        Log.i(TAG, "setData: "+datas.size());
    }

    @Override
    public <T> void setNextData(T t) {

    }
}
