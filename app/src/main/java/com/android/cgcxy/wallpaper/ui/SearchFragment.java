package com.android.cgcxy.wallpaper.ui;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.cgcxy.wallpaper.R;
import com.android.cgcxy.wallpaper.base.BaseFragment;
import com.android.cgcxy.wallpaper.bean.SearchBean;
import com.android.cgcxy.wallpaper.presenter.MainPresenterImple;
import com.android.cgcxy.wallpaper.ui.search.SearchInputFragment;
import com.android.cgcxy.wallpaper.ui.search.SearchLabelFragment;
import com.android.cgcxy.wallpaper.view.FlowLayout;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment implements  View.OnClickListener {


    private FlowLayout flowLayout;
    private LayoutInflater from;
    private String TAG="SearchFragment";
    private static final int SENSOR_SHAKE = 10;
    private SensorManager sensorManager;
    private Vibrator vibrator;
    private EditText edit_query;
    private TextView ib_search;
    private MainPresenterImple mainPresenterImple;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_ringtone;
    }

    @Override
    public void initAttach() {
        mainPresenterImple = new MainPresenterImple(this,getContext());
    }

    @Override
    protected void lazyLoad() {
        super.lazyLoad();
        mainPresenterImple.getSearchJsonData(true);
    }

    @Override
    public void findView() {

        from = LayoutInflater.from(getContext());
        flowLayout = findViewById(R.id.flowLayout);
        edit_query = findViewById(R.id.edit_query);
        ib_search = findViewById(R.id.ib_search);
        ib_search.setOnClickListener(this);
        edit_query.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
        edit_query.setLongClickable(false);


    }

    @Override
    public void initView() {



        sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        vibrator = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);

        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float[] values = event.values;
                float x = values[0]; // x轴方向的重力加速度，向右为正
                float y = values[1]; // y轴方向的重力加速度，向前为正
                float z = values[2]; // z轴方向的重力加速度，向上为正

                int medumValue = 19;// 三星 i9250怎么晃都不会超过20，没办法，只设置19了
                if (Math.abs(x) > medumValue || Math.abs(y) > medumValue || Math.abs(z) > medumValue) {
                    vibrator.vibrate(200);
                    mainPresenterImple.getSearchJsonData(false);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        edit_query.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (edit_query.getCompoundDrawables()[2] != null) {

                        boolean touchable = event.getX() > (edit_query.getWidth() - edit_query.getTotalPaddingRight())
                                && (event.getX() < ((edit_query.getWidth() - edit_query.getPaddingRight())));

                        if (touchable) {
                            edit_query.setText("");
                            return true;


                        }
                    }
                }
                return false;
            }
        });

    }

    @Override
    public <T> void setData(T t) {
        super.setData(t);
        List<SearchBean> searchBeanS = (List<SearchBean>) t;
        flowLayout.removeAllViews();
        for (int i = 0; i < searchBeanS.size(); i++) {

            TextView textView = (TextView) from.inflate(R.layout.search_label_tv,flowLayout,false);
            textView.setText(searchBeanS.get(i).getName());
            setOnLabelOnclick(textView,searchBeanS.get(i).getUrl());
            flowLayout.addView(textView);
        }
    }

    @Override
    public <T> void setNextData(T t) {

    }

    public void setOnLabelOnclick(final TextView tv, final String url){
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SearchLabelFragment searchFragment = SearchLabelFragment.newInstance(tv.getText().toString(),url);
                getBaseActivity().commitFragment(R.id.fragmeLaout,searchFragment,true);
            }
        });

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.ib_search){
            if (!edit_query.getText().toString().isEmpty()){
                SearchInputFragment searchInputFragment = SearchInputFragment.newInstance(edit_query.getText().toString());
                getBaseActivity().commitFragment(R.id.fragmeLaout,searchInputFragment,true);
            }else {

                Toast.makeText(getContext(),"请输入要查询的内容",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
