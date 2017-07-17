package com.android.cgcxy.wallpaper;

import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.android.cgcxy.wallpaper.base.BaseActivity;

public class HomePage extends BaseActivity {
    public static final String TAG ="HomePage" ;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigation_view;

    @Override
    public int getLayoutId() {
        return R.layout.activity_home_page;
    }


    @Override
    public void findView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.left_menu);
        navigation_view = (NavigationView) findViewById(R.id.navigation_view);
    }


    @Override
    public void initView() {
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        navigation_view.setItemIconTintList(null);
        setNavigationItemSelectedListener();
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar, R.string.open,R.string.close){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                Log.i(TAG, "onDrawerClosed: ");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                Log.i(TAG, "onDrawerOpened: ");

            }
        };
        actionBarDrawerToggle.syncState();
       drawerLayout.setDrawerListener(actionBarDrawerToggle);

    }

    public void setNavigationItemSelectedListener(){
        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.i(TAG, "onNavigationItemSelected: "+item.getItemId());
                return false;
            }
        });

    }

}
