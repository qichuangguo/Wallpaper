package com.android.cgcxy.wallpaper.view;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import com.android.cgcxy.wallpaper.R;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.sprite.SpriteContainer;
import com.github.ybq.android.spinkit.style.ChasingDots;
import com.github.ybq.android.spinkit.style.Circle;
import com.github.ybq.android.spinkit.style.CubeGrid;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.FadingCircle;
import com.github.ybq.android.spinkit.style.FoldingCube;
import com.github.ybq.android.spinkit.style.Pulse;
import com.github.ybq.android.spinkit.style.RotatingCircle;
import com.github.ybq.android.spinkit.style.RotatingPlane;
import com.github.ybq.android.spinkit.style.ThreeBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.github.ybq.android.spinkit.style.Wave;

import java.util.Random;

/**
 * Created by chuangguo.qi on 2017/7/25.
 */

public class MyDialog extends Dialog {

    private View inflate;
    private ProgressBar progressBar;

    public MyDialog(@NonNull Context context) {
        this(context,0);
    }

    public MyDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, R.style.CustomDialog);
        inflate = LayoutInflater.from(context).inflate(R.layout.progress_loading, null);
        progressBar = (ProgressBar) inflate.findViewById(R.id.spin_kit);

        setContentView(inflate);
    }

    protected MyDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public void showDialog(){

        Random random = new Random();
        Sprite sprite = getSpriteContainer(random.nextInt(12));
        sprite.setColor(getContext().getResources().getColor(R.color.colorAccent));
        progressBar.setIndeterminateDrawable(sprite);
        this.show();
    }

    public Sprite getSpriteContainer(int index){

        switch (index){
            case 0:
                return new RotatingPlane();
            case 1:
                return new DoubleBounce();
            case 2:
                return new Wave();
            case 3:
                return new WanderingCubes();
            case 4:
                return new RotatingPlane();
            case 5:
                return new RotatingCircle();
            case 6:
                return new Pulse();
            case 7:
                return new ChasingDots();
            case 8:
                return new ThreeBounce();
            case 9:
                return new Circle();
            case 10:
                return new FadingCircle();
            case 11:
                return new FoldingCube();
        }
        return new Circle();
    }
}
