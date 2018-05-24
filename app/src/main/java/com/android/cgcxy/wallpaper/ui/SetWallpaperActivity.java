package com.android.cgcxy.wallpaper.ui;


import android.app.WallpaperManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.cgcxy.wallpaper.MyApplication;
import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.BaseActivity;
import com.android.cgcxy.wallpaper.bean.UserBean;
import com.android.cgcxy.wallpaper.utils.BlurBitmapUtil;
import com.android.cgcxy.wallpaper.utils.Utils;
import com.android.cgcxy.wallpaper.view.MyDialog;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

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
    private ImageButton ib_grammaticalization;
    private LinearLayout ll_bootom;
    private LinearLayout ll_bootom02;
    private ImageButton ib_seave;
    private Button bt_dim;
    private ImageButton bi_restore;
    private Bitmap tagBitmap;
    private ImageButton collections;

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
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int desiredMinimumWidth = dm.widthPixels;
        int desiredMinimumHeight = dm.heightPixels;
         wallpaperManager.suggestDesiredDimensions(desiredMinimumWidth*2, desiredMinimumHeight);
         progressBar = (ProgressBar) findViewById(R.id.progressBar);
         set_wallpaper = (Button) findViewById(R.id.set_wallpaper);
         ib_dewnlaod = (ImageButton) findViewById(R.id.ib_dewnlaod);
         ib_grammaticalization = (ImageButton) findViewById(R.id.ib_grammaticalization);
         ll_bootom = (LinearLayout) findViewById(R.id.ll_bootom);
         ll_bootom02 = (LinearLayout) findViewById(R.id.ll_bootom02);
         ib_seave = (ImageButton)findViewById(R.id.ib_seave);
         bt_dim = (Button)findViewById(R.id.bt_dim);
         bi_restore = (ImageButton)findViewById(R.id.bi_restore);
        collections = (ImageButton) findViewById(R.id.collections);
         ib_seave.setOnClickListener(this);
        collections.setOnClickListener(this);
         bt_dim.setOnClickListener(this);
         bi_restore.setOnClickListener(this);
         ib_grammaticalization.setOnClickListener(this);
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
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                SetWallpaperActivity.this.bitmap=bitmap;
                imageView.setImageBitmap(bitmap);
                dialog.dismiss();
            }
        },
                0,
               0,
                ImageView.ScaleType.FIT_XY,
                Bitmap.Config.ARGB_8888, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.i(TAG, "onErrorResponse: "+volleyError.getMessage());
            }
        });
        imageRequest.setShouldCache(false);
        Utils.getUtils().getRequestQueue(this).add(imageRequest);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.set_wallpaper){
            setting(v);
        }else if (id==R.id.ib_dewnlaod){
            setWallpaper();
        } else if (id == R.id.ib_grammaticalization) {

            Matrix m = new Matrix();
            m.postScale(1.1f,1.1f);
            tagBitmap= Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),m,false);

            ll_bootom02.setVisibility(View.VISIBLE);
            ll_bootom.setVisibility(View.GONE);

        }else if (id==R.id.ib_seave){
            ll_bootom.setVisibility(View.VISIBLE);
            ll_bootom02.setVisibility(View.GONE);
            bitmap = tagBitmap;
            imageView.setImageBitmap(bitmap);

        }else if (id==R.id.bt_dim){

            tagBitmap = BlurBitmapUtil.blurBitmap(SetWallpaperActivity.this, SetWallpaperActivity.this.tagBitmap,10);
            imageView.setImageBitmap(tagBitmap);

        }else if (id==R.id.bi_restore){
            tagBitmap=null;
            Matrix m = new Matrix();
            m.postScale(1.1f,1.1f);
            tagBitmap= Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),m,false);
            imageView.setImageBitmap(bitmap);
        }else if (id==R.id.collections){

            List<UserBean.CollectUser> data;
            UserBean userBean1 = ((MyApplication) getApplication()).getUserBean();
            if (userBean1.getCollect()==null){
                data = new ArrayList<>();
            }else {
                data=userBean1.getCollect();
            }
            if (data.size()>0){
                for (int i = 0; i < data.size(); i++) {
                    UserBean.CollectUser collectUser = data.get(i);
                    String collectUrl = collectUser.getCollectUrl();
                    if (url.equals(collectUrl)){
                        Utils.Toast(this,"文件已经收藏过了");
                        return;
                    }

                }

            }
            UserBean userBean = new UserBean();
            UserBean.CollectUser collectUser = userBean.new CollectUser();
            collectUser.setCollectUrl(url);
            data.add(collectUser);
            userBean1.setCollect(data);
            userBean.setCollect(data);

            userBean.setObjectId(userBean1.getjObject());
            userBean.update(userBean1.getjObject(), new UpdateListener() {
                @Override
                public void done(BmobException e) {
                    if (e!=null){
                        Utils.Toast(SetWallpaperActivity.this,"收藏失败");
                        Log.i(TAG, "done: "+e.getMessage());
                    }else {
                        Utils.Toast(SetWallpaperActivity.this,"收藏成功");
                    }
                }
            });

        }
    }


    public void setWallpaper (){
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


    class WallpaperIntentReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(SetWallpaperActivity.this,"壁纸设置成功",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mWallpaperReceiver!=null) {
            getApplication().unregisterReceiver(mWallpaperReceiver);
        }
    }

    private void registerIntentReceivers(){
        if(mWallpaperReceiver == null){
            mWallpaperReceiver = new WallpaperIntentReceiver();
            IntentFilter filter = new IntentFilter(Intent.ACTION_WALLPAPER_CHANGED);
            getApplication().registerReceiver(mWallpaperReceiver, filter);
        }
    }

}
