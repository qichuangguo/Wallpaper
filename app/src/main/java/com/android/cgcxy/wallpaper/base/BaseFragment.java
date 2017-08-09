package com.android.cgcxy.wallpaper.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.android.cgcxy.wallpaper.HomePage;
import com.android.cgcxy.wallpaper.MainActivity;
import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.bean.ImageBeanUrl;
import com.android.cgcxy.wallpaper.ui.BrowseFragment;

import com.android.cgcxy.wallpaper.ui.SetWallpaperActivity;
import com.android.cgcxy.wallpaper.ui.ShowView;
import com.android.cgcxy.wallpaper.ui.browseui.RankingFragment;
import com.android.cgcxy.wallpaper.ui.homepageui.classifysub.ClassifySubClassifyFragment;
import com.android.cgcxy.wallpaper.ui.homepageui.classifysub.ClassifySubNewsFragment;
import com.android.cgcxy.wallpaper.view.MyDialog;
import com.github.ybq.android.spinkit.style.DoubleBounce;

import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public abstract class BaseFragment extends Fragment implements ShowView,OnClickListener{

    private View mView;
    private BaseActivity baseActivity;
    private String TAG="BaseFragment";
    private ViewGroup container;
    private MyDialog dialog;
    private boolean isInit=false;
    private boolean isLoad=false;
    private List data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayoutId(), container, false);
        this.container=container;
        isInit=true;
        isCanLoadData();
        findView();
        initView();
        return mView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initAttach();

    }
    private void isCanLoadData(){
        if (!isInit){
            return;
        }
        if (this instanceof HomePage ||
                this instanceof BrowseFragment ||
                this instanceof ClassifySubNewsFragment ||
                this instanceof ClassifySubClassifyFragment ||
                this instanceof RankingFragment){
            return;
        }

        if (getUserVisibleHint() && !isLoad){
            Log.i(TAG, "isCanLoadData: "+this);
            lazyLoad();
            isLoad=true;
        }else {
            if (isLoad){
                stopLoad();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isInit = false;
        isLoad = false;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isCanLoadData();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    protected void lazyLoad(){
        Log.i(TAG, "lazyLoad: 加载数据");
        dialog = new MyDialog(getContext());
        dialog.showDialog();
    }

    public abstract int getLayoutId();
    public  abstract void initAttach();
    public abstract void findView();
    public abstract void initView();
    protected void stopLoad() {
    }



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

    @Override
    public <T> void setData(T t) {
        Log.i(TAG, "setData: "+dialog.isShowing());
        if (dialog!=null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public <T> void setNextData(T t) {

    }

    @Override
    public void clickListener(View view, int position,ImageBeanUrl imageBeanUrl) {
        Intent intent = new Intent(getBaseActivity(),SetWallpaperActivity.class);
        intent.putExtra("url",imageBeanUrl.getBig());
        startActivity(intent);
    }
}
