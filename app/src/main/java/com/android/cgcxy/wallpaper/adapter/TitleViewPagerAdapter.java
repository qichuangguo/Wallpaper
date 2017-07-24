package com.android.cgcxy.wallpaper.adapter;

import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/24.
 */

public class TitleViewPagerAdapter extends PagerAdapter {

    private List<String> titls;
    private List<View> views;
    public void setTitle(List<String> titls){
        this.titls=titls;
    }

    public void setDatas(List<View> views){

        this.views=views;
    }

    @Override
    public int getCount() {
        if (views!=null && views.size()>0){
            return views.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(views.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (views!=null && views.size()>0) {
            container.addView(views.get(position));
            return views.get(position);
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titls!=null && titls.size()>0){
            return titls.get(position);
        }
        return super.getPageTitle(position);
    }
}
