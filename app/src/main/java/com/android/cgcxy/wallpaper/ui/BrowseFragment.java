package com.android.cgcxy.wallpaper.ui;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.ui.browseui.SpecialFragment;
import com.android.cgcxy.wallpaper.utils.Utils;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class BrowseFragment extends BaseFragment implements View.OnClickListener {


    private static final String TAG ="BrowseFragment" ;
    private LinearLayout linearLayout;
    private RelativeLayout relayout_special;
    private RelativeLayout relayout_gamepad;
    private RelativeLayout relayout_gesture;
    private RelativeLayout relayout_seniority;
    private RelativeLayout relayout_update;

    public BrowseFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_browse;
    }

    @Override
    public void initAttach() {

    }

    @Override
    public void findView() {

        linearLayout = findViewById(R.id.linearLayout);
        relayout_special = findViewById(R.id.relayout_special);
        relayout_gamepad = findViewById(R.id.relayout_gamepad);
        relayout_gesture = findViewById(R.id.relayout_gesture);
        relayout_seniority = findViewById(R.id.relayout_seniority);
        relayout_update = findViewById(R.id.relayout_update);

    }

    @Override
    public void initView() {

        relayout_special.setOnClickListener(this);
        relayout_gamepad.setOnClickListener(this);
        relayout_gesture.setOnClickListener(this);
        relayout_seniority.setOnClickListener(this);
        relayout_update.setOnClickListener(this);

        RequestQueue requestQueue = Utils.getUtils().getRequestQueue(getContext());
        ImageRequest imageRequest = new ImageRequest("http://s.qdcdn.com/c/14513596,1990,1280.webp", new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                Drawable drawable =new BitmapDrawable(bitmap);
                linearLayout.setBackground(drawable);
            }
        }, Utils.getScreenDispaly(getContext())[0], Utils.getScreenDispaly(getContext())[1], ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        requestQueue.add(imageRequest);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.relayout_seniority){
            //排行榜
        }else if (id==R.id.relayout_gamepad) {
            //游戏
        }else if (id==R.id.relayout_gesture){
            //试试手气
        }else if (id==R.id.relayout_update){
           // 每日更新
        }else if (id==R.id.relayout_special){
            Log.i(TAG, "onClick: ");
            SpecialFragment specialFragment = SpecialFragment.newInstance();
            getBaseActivity().commitFragment(R.id.fragmeLaout,specialFragment,true);
        }
    }
}
