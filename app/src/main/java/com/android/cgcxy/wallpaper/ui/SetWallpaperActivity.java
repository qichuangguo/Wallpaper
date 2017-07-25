package com.android.cgcxy.wallpaper.ui;


import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.BaseActivity;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.utils.Utils;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetWallpaperActivity extends BaseActivity {


    private static final String TAG ="SetWallpaperFragment" ;
    private String url="";
    private ImageView imageView;
    private WallpaperManager wallpaperManager;
    private ImageView scal_iv;


    @Override
    public int getLayoutId() {
        return R.layout.fragment_set_wallpaper;
    }

    @Override
    public void findView() {
        setbarTintEnabled(R.color.transparency,false);
         url = getIntent().getStringExtra("url");
         imageView = (ImageView) findViewById(R.id.imageView);
         wallpaperManager = WallpaperManager.getInstance(this);
        scal_iv = (ImageView) findViewById(R.id.scal_iv);

        scal_iv.setImageDrawable(wallpaperManager.getDrawable());

    }


    @Override
    public void initView() {
        if (url!=null) {
            String[] newUrl = url.split(",");
             url = newUrl[0] + ","+ Utils.getScreenDispaly(this)[0]+","+ (Utils.getScreenDispaly(this)[1])+"." + newUrl[newUrl.length - 1].split("\\.")[1];
            Log.i(TAG, "initView: "+url);
            Picasso.with(this).load(url).skipMemoryCache().into(imageView);
        }

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                imageView.setImageBitmap(bitmap);
                try {
                    wallpaperManager.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        },Utils.getScreenDispaly(this)[0], Utils.getScreenDispaly(this)[1], ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        imageRequest.setShouldCache(false);
        Utils.getUtils().getRequestQueue(this).add(imageRequest);
    }


}
