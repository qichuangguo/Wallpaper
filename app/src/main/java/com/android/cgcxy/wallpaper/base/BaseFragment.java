package com.android.cgcxy.wallpaper.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.R;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public abstract class BaseFragment extends Fragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(getLayoutId(), container, false);
        findView();
        initView();
        return mView;
    }

    public abstract int getLayoutId();
    public abstract void findView();
    public abstract void initView();

    public <T extends View> T findViewById(int id){

        if (mView!=null){
          return   (T)mView.findViewById(id);
        }
        return null;
    }
}
