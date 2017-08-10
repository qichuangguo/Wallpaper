package com.android.cgcxy.wallpaper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.nsd.NsdManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.cgcxy.wallpaper.base.BaseActivity;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.UserBean;
import com.android.cgcxy.wallpaper.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.sms.BmobSMS;
import cn.bmob.sms.listener.QuerySMSStateListener;
import cn.bmob.sms.listener.RequestSMSCodeListener;
import cn.bmob.sms.listener.VerifySMSCodeListener;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class RegisterLoginActivity extends BaseActivity implements OnClickListener {

    private Toolbar toolbar;
    private EditText ed_name;
    private EditText ed_paw;
    private EditText ed_verify;
    private Button send_verify;
    private Button bt_register;
    private int smsId;
    int count=60;
    private Timer timer;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register_login;
    }

    @Override
    public void findView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        ed_name = (EditText)findViewById(R.id.ed_name);
        ed_paw = (EditText)findViewById(R.id.ed_paw);
        ed_verify = (EditText)findViewById(R.id.ed_verify);
        send_verify = (Button)findViewById(R.id.send_verify);
        bt_register = (Button) findViewById(R.id.bt_register);

        bt_register.setOnClickListener(this);
        send_verify.setOnClickListener(this);
        setbarTintEnabled(R.color.toolBar_bg, false);
        toolbar.setTitle("注册");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void initView() {
        BmobSMS.initialize(this,"43a99d36aa99a2d51a931213ce23a5ff");
    }


    @Override
    public void onClick(View v) {
        int id =v.getId();
        if (id==R.id.send_verify){
            sendVerify();
        }else if (id==R.id.bt_register){
            register();
        }
    }

    private void register() {
        final String phonNumber = ed_name.getText().toString().trim();
        final String paw = ed_paw.getText().toString().trim();
        String verify = ed_verify.getText().toString().trim();
        if (phonNumber.isEmpty()){
            Toast.makeText(this,"请输入手机号",Toast.LENGTH_SHORT).show();
            return;
        }

        if (paw.isEmpty()){
            Utils.Toast(this,"密码不能为空");
            return;
        }

        if (verify.isEmpty()){
            Utils.Toast(this,"验证码不能为空");
            return;
        }

        BmobSMS.verifySmsCode(this,phonNumber,verify, new VerifySMSCodeListener() {
            @Override
            public void done(cn.bmob.sms.exception.BmobException e) {
                if(e==null){//短信验证码已验证成功
                    final UserBean userBean = new UserBean();
                    userBean.setPassword(paw);
                    userBean.setPhonNumber(phonNumber);
                    userBean.save(new SaveListener<String>() {
                        @Override
                        public void done(String s, BmobException e) {
                            if (e!=null){
                                Utils.Toast(RegisterLoginActivity.this,"注册失败");
                            }else {
                                Utils.setObjectToShare(RegisterLoginActivity.this,userBean, Constants.USERBEAN);
                                startActivity(new Intent(RegisterLoginActivity.this,MainActivity.class));
                                Utils.Toast(RegisterLoginActivity.this,"注册成功");
                                finish();
                            }
                        }
                    });
                    Log.i("bmob", "验证通过");
                }else{
                    Utils.Toast(RegisterLoginActivity.this,"验证码错误");
                    Log.i("bmob", "验证失败：code ="+e.getErrorCode()+",msg = "+e.getLocalizedMessage());
                }
            }

        });
    }

    private void sendVerify() {
        count=60;
        final String phonNumber = ed_name.getText().toString().trim();
        if (phonNumber.isEmpty()){
            Toast.makeText(this,"请输入手机号",Toast.LENGTH_SHORT).show();
            return;
        }

        boolean matches = phonNumber.matches("^1[0-9]{10,10}");
        if (!matches){
            Toast.makeText(this,"请输入正确的手机号",Toast.LENGTH_SHORT).show();
            return;
        }
        send_verify.setEnabled(false);
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                send_verify.post(new Runnable() {
                    @Override
                    public void run() {
                        count--;
                        if (count==0){
                            timer.cancel();
                        }
                        send_verify.setText(count+"s 可以重试");
                    }
                });
            }
        },0,1000);

        BmobQuery<UserBean> bmobQuery = new BmobQuery();
        bmobQuery.addWhereEqualTo("phonNumber", phonNumber);
        bmobQuery.setLimit(1);
        bmobQuery.findObjects(new FindListener<UserBean>() {
            @Override
            public void done(List<UserBean> list, BmobException e) {
                if (e!=null){
                    Log.i("bmob", "done: "+e.getMessage());
                    timer.cancel();
                    send_verify.setEnabled(true);
                    send_verify.setText("获取验证码");
                    Utils.Toast(RegisterLoginActivity.this,"服务器异常,请稍后重试");
                }else {
                    if (list!=null && list.size()==0){

                        BmobSMS.requestSMSCode(RegisterLoginActivity.this, phonNumber, "酷爱注册",new RequestSMSCodeListener() {

                            @Override
                            public void done(Integer integer, cn.bmob.sms.exception.BmobException e) {
                                if(e==null){//验证码发送成功

                                    Utils.Toast(RegisterLoginActivity.this,"验证码发送成功");
                                    Log.i("bmob", "短信id："+integer);//用于查询本次短信发送详情
                                }else {
                                    Utils.Toast(RegisterLoginActivity.this,"验证码发送失败");
                                    send_verify.setEnabled(true);
                                    send_verify.setText("获取验证码");
                                    Log.i("bmob", ""+e.getMessage());//用于查询本次短信发送详情
                                }
                            }

                        });

                    }else {
                        Log.i("bmob", "done: 此手机号已经注册过了");
                        timer.cancel();
                        send_verify.setEnabled(true);
                        send_verify.setText("获取验证码");
                        Utils.Toast(RegisterLoginActivity.this,"此手机号已经注册过了");
                    }
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer!=null){
            timer.cancel();
        }
    }
}

