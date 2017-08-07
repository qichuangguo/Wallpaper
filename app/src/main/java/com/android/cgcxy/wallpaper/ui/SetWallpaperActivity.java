package com.android.cgcxy.wallpaper.ui;


import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
public class SetWallpaperActivity extends BaseActivity {


    private static final String TAG ="SetWallpaperFragment" ;
    private String url="";
    private ImageView imageView;
    private WallpaperManager wallpaperManager;
    private ImageView scal_iv;
    private Bitmap bitmap;
    private Button button;
    private MyDialog dialog;
    WallpaperIntentReceiver mWallpaperReceiver;
    private ProgressBar progressBar;

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
         button = (Button) findViewById(R.id.button);
         progressBar = (ProgressBar) findViewById(R.id.progressBar);
         progressBar.setVisibility(View.GONE);
         button.setVisibility(View.GONE);
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
                           // wallpaperManager.setBitmap(bitmap);
                            //SetLockWallPaper(bitmap);
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
          /*  String[] newUrl = url.split(",");
             url = newUrl[0] + ","+ Utils.getScreenDispaly(this)[0]+","+ (Utils.getScreenDispaly(this)[1])+"." + newUrl[newUrl.length - 1].split("\\.")[1];
            Log.i(TAG, "initView: "+url);*/
            Picasso.with(this).load(url).skipMemoryCache().into(imageView);
        }

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                SetWallpaperActivity.this.bitmap=bitmap;
                imageView.setImageBitmap(bitmap);
                button.setVisibility(View.VISIBLE);
                dialog.dismiss();
            }
        },Utils.getScreenDispaly(this)[0], Utils.getScreenDispaly(this)[1], ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i(TAG, "onErrorResponse: "+volleyError.getMessage());
            }
        });
        imageRequest.setShouldCache(false);
        Utils.getUtils().getRequestQueue(this).add(imageRequest);
    }

    class WallpaperIntentReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(SetWallpaperActivity.this,"壁纸设置成功",Toast.LENGTH_SHORT).show();
            Log.i(TAG, "onReceive: 更换了壁纸");
        }
    }

    private void registerIntentReceivers(){
        if(mWallpaperReceiver == null){
            mWallpaperReceiver = new WallpaperIntentReceiver();
            /**
             * 注册的时候，指定IntentFilter，这样改BroadcastReciver就是接收壁纸更换的Broadcast的了
             */
            IntentFilter filter = new IntentFilter(Intent.ACTION_WALLPAPER_CHANGED);
            getApplication().registerReceiver(mWallpaperReceiver, filter);
        }
    }

    private void SetLockWallPaper(Bitmap bitmap) {
        // TODO Auto-generated method stub
        try {
            WallpaperManager mWallManager = WallpaperManager.getInstance(this);
            Class class1 = mWallManager.getClass();//获取类名
            Method setWallPaperMethod = class1.getMethod("setBitmapToLockWallpaper",Bitmap.class);
            Log.i(TAG, "SetLockWallPaper: "+setWallPaperMethod);
            setWallPaperMethod.invoke(mWallManager,bitmap);


        } catch (Throwable e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


}
