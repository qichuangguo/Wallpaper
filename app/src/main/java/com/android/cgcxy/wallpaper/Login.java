package com.android.cgcxy.wallpaper;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.UserBean;
import com.android.cgcxy.wallpaper.utils.Utils;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class Login extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "Login";
    private LinearLayout ll_name;
    private EditText ed_name;
    private LinearLayout ll_paw;
    private EditText ed_paw;
    private Button bt_login;
    private TextView tv_paw;
    private TextView tv_login;

    public Login() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        Bmob.initialize(this, "43a99d36aa99a2d51a931213ce23a5ff");
        Object objectFromShare = Utils.getObjectFromShare(this, Constants.USERBEAN);
        Log.i(TAG, "onCreate: "+objectFromShare);
        if (objectFromShare!=null){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
        initView();
    }

    private void initView() {

        ll_name = (LinearLayout)findViewById(R.id.ll_name);
        ed_name = (EditText)findViewById(R.id.ed_name);
        ll_paw = (LinearLayout)findViewById(R.id.ll_paw);
        ed_paw = (EditText)findViewById(R.id.ed_paw);
        bt_login = (Button)findViewById(R.id.bt_login);
        tv_paw = (TextView)findViewById(R.id.tv_paw);
        tv_login = (TextView)findViewById(R.id.tv_login);

        tv_login.setOnClickListener(this);
        bt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.bt_login){
            login();
        }else if (id==R.id.tv_login){
            startActivity(new Intent(this,RegisterLoginActivity.class));
        }
    }

    private void login() {
        String name = ed_name.getText().toString().trim();
        final String paw = ed_paw.getText().toString().trim();

        if (name.isEmpty()){
            Toast.makeText(this,"账号不能为空",Toast.LENGTH_SHORT).show();
            return;
        }

        if (paw.isEmpty()){
            Toast.makeText(this,"账号不能为空",Toast.LENGTH_SHORT).show();
            return;
        }

        BmobQuery<UserBean> bmobQuery = new BmobQuery();
        bmobQuery.addWhereEqualTo("phonNumber", name);
        bmobQuery.setLimit(1);
        bmobQuery.findObjects(new FindListener<UserBean>() {
            @Override
            public void done(List<UserBean> list, BmobException e) {
                if (e!=null){
                    Log.i(TAG, "done: "+e.getMessage());
                    Toast.makeText(Login.this,"服务器异常",Toast.LENGTH_SHORT).show();
                }else {
                    if (list!=null && list.size()>0){
                        UserBean userBean = list.get(0);
                        if (userBean.getPassword().equals(paw)){
                            boolean b = Utils.setObjectToShare(Login.this, userBean, Constants.USERBEAN);
                            Log.i(TAG, "done: "+b+"+===="+userBean);
                            startActivity(new Intent(Login.this,MainActivity.class));
                            finish();
                        }else {
                            Toast.makeText(Login.this,"密码错误",Toast.LENGTH_SHORT).show();
                            ed_paw.setText("");
                        }
                    }else {
                        ed_name.setText("");
                        ed_paw.setText("");
                        Toast.makeText(Login.this,"密码或账号错误",Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
    }
}
