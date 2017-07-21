package com.android.cgcxy.wallpaper.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.HomePage;
import com.android.cgcxy.wallpaper.R;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public abstract class BaseFragment extends Fragment {

    private View mView;
    private BaseActivity baseActivity;
    private String TAG="BaseFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        mView = inflater.inflate(getLayoutId(), container, false);
        findView();
        initView();
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: ");
        initAttach();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: ");

    }

    public abstract int getLayoutId();
    public  abstract void initAttach();
    public abstract void findView();
    public abstract void initView();


    public <T extends View> T findViewById(int id){

        if (mView!=null){
          return   (T)mView.findViewById(id);
        }
        return null;
    }

    protected BaseActivity getBaseActivity(){
        if(baseActivity == null){
            baseActivity = (BaseActivity)getActivity();
        }
        return baseActivity;
    }

    public void commitFragment(int id, Fragment fragment,boolean keep){
        commitFragment(id,fragment,null,keep);
    }

    public void commitFragment(int id, Fragment fragment, String tag,
                               boolean keep) {
        FragmentTransaction transaction =  getChildFragmentManager().beginTransaction();
        transaction.replace(id, fragment);
        if (keep) {
            transaction.addToBackStack(tag);
        } else {
            transaction.disallowAddToBackStack();
        }
        transaction.commitAllowingStateLoss();
    }


}
