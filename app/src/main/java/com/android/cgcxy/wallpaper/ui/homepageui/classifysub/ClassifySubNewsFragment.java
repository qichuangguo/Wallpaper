package com.android.cgcxy.wallpaper.ui.homepageui.classifysub;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.ClassifySubNewsAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.bean.ClassifySubBean;
import com.android.cgcxy.wallpaper.mode.RefreshListener;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.ShowView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifySubNewsFragment extends BaseFragment  {


    private static final String TAG = "ClassifySubNewsFragment";
    private RecyclerView recyclerView;
    private ClassifySubNewsAdapter classifySubNewsAdapter;
    private boolean isLoading=false;
    private MainPresenterImple mainpresenterImple;
    private ClassifySubBean classifySubBeanS;
    private ClassifySubBean classifySubBean;
    private int index;
    private String url;



    public static ClassifySubNewsFragment newInstance() {

        ClassifySubNewsFragment fragment = new ClassifySubNewsFragment();
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_classify_sub_news;
    }

    @Override
    public void findView() {

        recyclerView = findViewById(R.id.recycleView);
    }

    @Override
    public void initAttach() {
        mainpresenterImple= new MainPresenterImple(this,getBaseActivity());
    }


    @Override
    public void initView() {
        classifySubNewsAdapter = new ClassifySubNewsAdapter();
        classifySubNewsAdapter.setOnClickListener(this);
        final GridLayoutManager layoutManage = new GridLayoutManager(getContext(),3);
        layoutManage.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position==classifySubNewsAdapter.getItemCount()-1){
                    return 3;
                }else {
                    return 1;
                }
            }
        });
        recyclerView.setLayoutManager(layoutManage);
        recyclerView.setAdapter(classifySubNewsAdapter);

        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            int lastVisibleItem = 0;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE && lastVisibleItem +1 == classifySubNewsAdapter.getItemCount() && !isLoading) {
                    mainpresenterImple.getClassifyNestSubJsonData(url+"&skip="+index*30);
                    isLoading = true;

                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = layoutManage.findLastVisibleItemPosition();
            }
        });


    }



    public void getData(ClassifySubBean classifySubBean,String url){
       this.classifySubBeanS = classifySubBean;
       this.url = url;
        if (classifySubNewsAdapter!=null) {
            classifySubNewsAdapter.setData(classifySubBean);
            classifySubNewsAdapter.notifyDataSetChanged();
            index++;
        }
    }

    @Override
    public <T> void setNextData(T t) {
        super.setNextData(t);
        classifySubBean = (ClassifySubBean) t;
        classifySubNewsAdapter.getClassifySubBean().getRes().getVertical().addAll(classifySubBean.getRes().getVertical());
        classifySubNewsAdapter.notifyDataSetChanged();
        index++;
        isLoading=false;
    }



}
