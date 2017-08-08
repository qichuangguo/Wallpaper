package com.android.cgcxy.wallpaper;

import android.accessibilityservice.AccessibilityService;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.android.cgcxy.wallpaper.base.BaseActivity;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.TotalBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenter;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.ShowView;
import com.android.cgcxy.wallpaper.utils.Utils;

public class MainActivity extends BaseActivity implements ShowView{


    private static final String TAG = "MainActivity";

    @Override
    public void initView() {
        getPermissions("android.permission.READ_PHONE_STATE",100);
        getPermissions("android.permission.WRITE_EXTERNAL_STORAGE",101);
        getPermissions("android.permission.READ_EXTERNAL_STORAGE",102);
        MainPresenterImple mainPresenterImple = new MainPresenterImple(this,this);
        String url = String.format(Constants.TOTALURL,
                Utils.getUUid(this),
                Utils.getScreenDispaly(this)[0],
                Utils.getScreenDispaly(this)[1],
                Utils.getScreenDispaly(this)[0],
                Utils.getScreenDispaly(this)[1],
                android.os.Build.BRAND+"("+android.os.Build.MODEL+")",Utils.getDeviceId(this),Utils.GetNetworkType(this));
        mainPresenterImple.getTotalUrl(url);
        Log.i(TAG, "initView: "+url);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;

    }

    @Override
    public void findView() {


    }

    @Override
    public <T> void setData(T t) {
        totalBean= (TotalBean) t;
        Log.i(TAG, "setData: "+totalBean.getHome());
        commitFragment(R.id.fragmeLaout,new HomePage(),true);
    }

    @Override
    public <T> void setNextData(T t) {

    }

    public void getPermissions(String permission,int code){

        if (ContextCompat.checkSelfPermission(this,permission)== PackageManager.PERMISSION_GRANTED){

        }else {

            ActivityCompat.requestPermissions(this,new String[]{permission},code);

        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode==100){

            if (grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this,"请开启必要的权限",Toast.LENGTH_SHORT).show();
                finish();
            }

        }else if (requestCode==101){
            if (grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this,"请开启必要的权限",Toast.LENGTH_SHORT).show();
                finish();
            }
        }else if (requestCode==102){
            if (grantResults[0]!=PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this,"请开启必要的权限",Toast.LENGTH_SHORT).show();
                finish();
            }
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
