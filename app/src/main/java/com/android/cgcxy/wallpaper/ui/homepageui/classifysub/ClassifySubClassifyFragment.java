package com.android.cgcxy.wallpaper.ui.homepageui.classifysub;


import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.adapter.ClassifySubNewsAdapter;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.base.Constants;
import com.android.cgcxy.wallpaper.base.OnClickListener;
import com.android.cgcxy.wallpaper.bean.ClassifySubBean;
import com.android.cgcxy.wallpaper.bean.ImageBeanUrl;
import com.android.cgcxy.wallpaper.mode.RefreshListener;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifySubClassifyFragment extends BaseFragment  {


    private static final String TAG = "ClassifySubClassifyFragment";
    private ClassifySubBean classifySubBean;
    private RecyclerView recyclerView;
    private MainPresenterImple presenterImple;
    private ClassifySubNewsAdapter classifySubNewsAdapter;
    private boolean isLoading;
    private int index;
    private String id;

    public ClassifySubClassifyFragment() {

    }

    public static ClassifySubClassifyFragment newInstance() {

        ClassifySubClassifyFragment fragment = new ClassifySubClassifyFragment();
        return fragment;
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_classify_sub_classify;
    }

    @Override
    public void initAttach() {
        presenterImple = new MainPresenterImple(this,getContext());
    }

    @Override
    public void findView() {
        recyclerView = findViewById(R.id.recycleView);
    }

    @Override
    public void initView() {

        classifySubNewsAdapter = new ClassifySubNewsAdapter();
        classifySubNewsAdapter.setOnClickListener(this);
        final GridLayoutManager layoutManage = new GridLayoutManager(getContext(),3);
        layoutManage.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position== classifySubNewsAdapter.getItemCount()-1){
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
                    presenterImple.getClassifyNestSubJsonData(String.format(Constants.categoryDetailsHot,id)+"&skip="+index*30);
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

    public void getData(String id) {
        this.id=id;
        presenterImple.getClassifySubHotJsonData(String.format(Constants.categoryDetailsHot,id));

    }

    @Override
    public <T> void setData(T t) {
        super.setData(t);
        index++;
        classifySubNewsAdapter.setData((ClassifySubBean) t);
        classifySubNewsAdapter.notifyDataSetChanged();
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
