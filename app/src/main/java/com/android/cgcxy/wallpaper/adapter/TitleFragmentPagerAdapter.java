package com.android.cgcxy.wallpaper.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public class TitleFragmentPagerAdapter extends FragmentPagerAdapter {

   private List<Fragment> listFragment;
    private String title[];

    public void setTitle(String title[]){

        this.title = title;
    }

    public TitleFragmentPagerAdapter(FragmentManager fm, List<Fragment> listFragment) {
        super(fm);
        this.listFragment = listFragment;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
