package com.android.cgcxy.wallpaper;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.cgcxy.wallpaper.adapter.TitleFragmentPagerAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.bean.HompPagerBean;
import com.android.cgcxy.wallpaper.bean.UserBean;
import com.android.cgcxy.wallpaper.ui.BrowseFragment;
import com.android.cgcxy.wallpaper.ui.ClassifyFragment;
import com.android.cgcxy.wallpaper.ui.HomePageFragment;
import com.android.cgcxy.wallpaper.ui.SearchFragment;
import com.android.cgcxy.wallpaper.utils.Utils;
import com.android.cgcxy.wallpaper.view.CircleImageView;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;

import static android.app.Activity.RESULT_OK;

public class HomePage extends BaseFragment {
    public static final String TAG ="HomePage" ;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigation_view;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private String[] title = new String[]{"首页","分类","专题","搜索"};
    private TextView tv_name;
    private CircleImageView circleImageView;
    private int REQUEST_IMAGE_GET = 1001;
    private int REQUEST_IMAGE_CAPTURE = 1002;
    private PopupWindow mPopupWindow;
    private String mCurrentPhotoPath;


    @Override
    public int getLayoutId() {
        return R.layout.activity_home_page;
    }

    @Override
    public void initAttach() {

    }

    @Override
    public void findView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.left_menu);
        navigation_view = (NavigationView) findViewById(R.id.navigation_view);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

    }


    @Override
    public void initView() {

        ((MainActivity) getActivity()).setbarTintEnabled(R.color.toolBar_bg, false);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        navigation_view.setItemIconTintList(null);
        getBaseActivity().setSupportActionBar(toolbar);
        getBaseActivity().getSupportActionBar().setHomeButtonEnabled(true);
        getBaseActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle = new ActionBarDrawerToggle(getBaseActivity(), drawerLayout, toolbar, R.string.open, R.string.close) {
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

        //---------------------------------侧滑处理----------------------------------//
        View headerView = navigation_view.getHeaderView(0);
        tv_name = (TextView) headerView.findViewById(R.id.tv_name);
        circleImageView = (CircleImageView) headerView.findViewById(R.id.circleImageView);
        View popupView = LayoutInflater.from(getContext()).inflate(R.layout.home_page_popu_view, null);
        mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.getContentView().setFocusableInTouchMode(true);
        mPopupWindow.getContentView().setFocusable(true);
        PopupWindowOnclick onclick = new PopupWindowOnclick();
        popupView.findViewById(R.id.libraryPictour).setOnClickListener(onclick);
        popupView.findViewById(R.id.photograph).setOnClickListener(onclick);
        popupView.findViewById(R.id.cancel).setOnClickListener(onclick);
        if (getBaseActivity().isLogin()){
            UserBean userBean = getBaseActivity().getUserBean();
            if (userBean.getUserBeanPersonal()!=null && userBean.getUserBeanPersonal().getHeadPortraitUrl()!=null) {
                String headPortraitUrl = userBean.getUserBeanPersonal().getHeadPortraitUrl();
                Picasso.with(getContext()).load(headPortraitUrl).placeholder(R.mipmap.hand).error(R.mipmap.hand).into(circleImageView);
            }
        }
        //头像
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.showAtLocation(drawerLayout,
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        });

        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                return false;
            }
        });

        //-------------------------------------------------------------------//
        initData();
    }



    private void initData() {
        if (getBaseActivity().getUserBean()!=null){
            UserBean userBean = getBaseActivity().getUserBean();
            Log.i(TAG, "initData: "+userBean.getPhonNumber());
            String name = userBean.getName();
            if (name!=null&& !name.isEmpty()){
                tv_name.setText(name);
            }else {
                tv_name.setText(userBean.getPhonNumber());
            }
        }

        fragments.clear();
        fragments.add(new HomePageFragment());
        fragments.add(new ClassifyFragment());
        fragments.add(new BrowseFragment());
        fragments.add(new SearchFragment());
        viewPager.setOffscreenPageLimit(4);

        TitleFragmentPagerAdapter adapter = new TitleFragmentPagerAdapter(getChildFragmentManager(), fragments);
        adapter.setTitle(title);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager,false);
        adapter.notifyDataSetChanged();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(),false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        //判断系统中是否有处理该Intent的Activity
        if (intent.resolveActivity(getBaseActivity().getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET);
        } else {
            Utils.Toast(getBaseActivity(), "未找到图片查看器");
        }
    }


    private void dispatchTakePictureIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // 判断系统中是否有处理该Intent的Activity
        if (intent.resolveActivity(getBaseActivity().getPackageManager()) != null) {
            // 创建文件来保存拍的照片
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // 异常处理
            }
            if (photoFile != null) {
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
                startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            }
        } else {
            Utils.Toast(getBaseActivity(), "无法启动相机");
        }
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory
                (Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* 文件名 */
                ".jpg",         /* 后缀 */
                storageDir      /* 路径 */
        );
        mCurrentPhotoPath = image.getAbsolutePath();
        return image;
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // 回调成功
        if (resultCode == RESULT_OK) {
            String filePath = null;
            //判断是哪一个的回调
            if (requestCode == REQUEST_IMAGE_GET) {
                //返回的是content://的样式
                filePath = Utils.getFilePathFromContentUri(data.getData(), getBaseActivity());

            } else if (requestCode == REQUEST_IMAGE_CAPTURE) {
                if (mCurrentPhotoPath != null) {
                    filePath = mCurrentPhotoPath;
                }
            }

            if (mPopupWindow != null && mPopupWindow.isShowing()) {
                mPopupWindow.dismiss();
            }
            if (!TextUtils.isEmpty(filePath)) {
                // 自定义大小，防止OOM
                Bitmap bitmap = BitmapFactory.decodeFile(filePath);
                Matrix m  = new Matrix();
                m.postScale(0.8f,0.8f);
                bitmap=Bitmap.createScaledBitmap(bitmap,200,200,false);
                circleImageView.setImageBitmap(bitmap);
                Utils.seave(bitmap,"头像.jpg");
                String path = Environment.getExternalStorageDirectory().getPath()+File.separator+"酷爱"+File.separator+"头像.jpg";
                File file = new File(path);
                if (!file.exists()) {
                    return;
                }
                final BmobFile uploadingFile = new BmobFile(file);
                uploadingFile.uploadblock(new UploadFileListener() {
                    @Override
                    public void done(BmobException e) {
                        if (e != null) {
                            Log.i(TAG, "done: " + e.getMessage());
                            circleImageView.setProgress(false);
                            circleImageView.invalidate();
                        }else {
                            circleImageView.setProgress(false);
                            circleImageView.invalidate();
                            UserBean userBean = new UserBean();
                            UserBean.UserBeanPersonal personal = userBean.new UserBeanPersonal();
                            personal.setHeadPortraitUrl(uploadingFile.getFileUrl());
                            userBean.setUserBeanPersonal(personal);
                            getBaseActivity().getUserBean().setUserBeanPersonal(personal);
                            boolean b = Utils.setObjectToShare(getBaseActivity(), getBaseActivity().getUserBean(), Constants.USERBEAN);
                            String jObjeck = getBaseActivity().getUserBean().getjObject();
                            userBean.update(jObjeck, new UpdateListener() {
                                @Override
                                public void done(BmobException e) {
                                    if (e != null) {
                                        Log.i(TAG, "done: " + e.getMessage());
                                        e.getMessage();
                                    } else {
                                        Utils.Toast(getBaseActivity(), "头像上传成功");
                                        Log.i(TAG, "done: 更新成功");
                                    }
                                }
                            });
                        }
                    }

                    @Override
                    public void onProgress(Integer value) {
                        super.onProgress(value);
                        circleImageView.setProgressSchedule(value);
                        circleImageView.invalidate();
                        Log.i(TAG, "onProgress: "+value);
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        Log.i(TAG, "onFinish: " + uploadingFile.getFileUrl());
                        circleImageView.setProgress(false);
                        circleImageView.invalidate();
                    }

                    @Override
                    public void onStart() {
                        super.onStart();
                        circleImageView.setProgress(true);
                        circleImageView.invalidate();
                    }
                });

                circleImageView.setProgress(false);
            }
        }
    }

    public class PopupWindowOnclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int id = v.getId();
            if (id == R.id.libraryPictour) {
                selectImage();
            } else if (id == R.id.photograph) {
                dispatchTakePictureIntent();
            } else if (id == R.id.cancel) {
                mPopupWindow.dismiss();
            }
        }
    }


}
