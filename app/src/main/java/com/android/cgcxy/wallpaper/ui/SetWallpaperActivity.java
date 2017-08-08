package com.android.cgcxy.wallpaper.ui;


import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.BaseActivity;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.utils.Utils;
import com.android.cgcxy.wallpaper.view.MyDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.IOException;
import java.lang.reflect.Method;

import static android.app.WallpaperManager.FLAG_LOCK;
import static android.content.pm.ApplicationInfo.FLAG_SYSTEM;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetWallpaperActivity extends BaseActivity implements View.OnClickListener {


    private static final String TAG ="SetWallpaperFragment" ;
    private String url="";
    private ImageView imageView;
    private WallpaperManager wallpaperManager;
    private Bitmap bitmap;
    private MyDialog dialog;
    WallpaperIntentReceiver mWallpaperReceiver;
    private ProgressBar progressBar;
    private Button set_wallpaper;
    private ImageButton ib_dewnlaod;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_set_wallpaper;
    }

    @Override
    public void findView() {
        setbarTintEnabled(android.R.color.transparent,false);
         url = getIntent().getStringExtra("url");
         imageView = (ImageView) findViewById(R.id.imageView);
         wallpaperManager = WallpaperManager.getInstance(this);
         wallpaperManager.forgetLoadedWallpaper();
         progressBar = (ProgressBar) findViewById(R.id.progressBar);
         set_wallpaper = (Button) findViewById(R.id.set_wallpaper);
         ib_dewnlaod = (ImageButton) findViewById(R.id.ib_dewnlaod);
        ib_dewnlaod.setOnClickListener(this);
        set_wallpaper.setOnClickListener(this);
         progressBar.setVisibility(View.GONE);
         dialog = new MyDialog(this);
         dialog.showDialog();
         registerIntentReceivers();

    }

    public void setting(View view){

        progressBar.setVisibility(View.VISIBLE);
        if(bitmap!=null){
            try {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            wallpaperManager.setBitmap(bitmap);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void initView() {
        if (url!=null) {
            String[] newUrl = url.split(",");
           url = newUrl[0] + ","+ (Utils.getScreenDispaly(this)[0])+","+ (Utils.getScreenDispaly(this)[1]/2)+"." + newUrl[newUrl.length - 1].split("\\.")[1];
            Log.i(TAG, "initView: "+url);
        }

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                SetWallpaperActivity.this.bitmap=bitmap;
         /*       Log.i(TAG, "onResponse:  bitmap.getWidth()"+ bitmap.getWidth()+"======"+ bitmap.getHeight());
                Matrix m = new Matrix();
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float newWidth = (float) (Utils.getScreenDispaly(SetWallpaperActivity.this)[0]/width);
                float newHeight =  (float) (Utils.getScreenDispaly(SetWallpaperActivity.this)[1]/height);
                Log.i(TAG, "onResponse: newWidth"+newWidth+"===="+newHeight);
                m.postScale(newWidth,newHeight);
                Bitmap newbm = Bitmap.createBitmap(bitmap, 0, 0, width, height, m, true);
                Log.i(TAG, "onResponse: newbm"+newbm.getWidth()+"======"+newbm.getHeight());
                Bitmap newBitmap=Bitmap.createScaledBitmap(bitmap, Utils.getScreenDispaly(SetWallpaperActivity.this)[0], Utils.getScreenDispaly(SetWallpaperActivity.this)[1], true);*/
                imageView.setImageBitmap(bitmap);
                dialog.dismiss();
            }
        },Utils.getScreenDispaly(this)[0], Utils.getScreenDispaly(this)[1], ImageView.ScaleType.CENTER_CROP, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i(TAG, "onErrorResponse: "+volleyError.getMessage());
            }
        });
        imageRequest.setShouldCache(false);
        Utils.getUtils().getRequestQueue(this).add(imageRequest);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.set_wallpaper){
            setting(v);
        }else if (id==R.id.ib_dewnlaod){

            if (bitmap!=null) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        boolean seave = Utils.seave(bitmap, System.currentTimeMillis() + ".jpg");
                        if (seave){
                            ib_dewnlaod.post(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(SetWallpaperActivity.this,"壁纸保存成功",Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }).start();

            }

        }
    }

    class WallpaperIntentReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(SetWallpaperActivity.this,"壁纸设置成功",Toast.LENGTH_SHORT).show();
        }
    }

    private void registerIntentReceivers(){
        if(mWallpaperReceiver == null){
            mWallpaperReceiver = new WallpaperIntentReceiver();
            /**
             * 注册的时候，指定IntentFilter，这样改BroadcastReciver就是接收壁纸更换的Broadcast的了
             */
           // IntentFilter filter = new IntentFilter();
           // filter.addAction("android.intent.action.LOCK_WALLPAPER_CHANGED");
            IntentFilter filter = new IntentFilter(Intent.ACTION_WALLPAPER_CHANGED);
            getApplication().registerReceiver(mWallpaperReceiver, filter);
        }
    }

}
