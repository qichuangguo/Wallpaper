package com.android.cgcxy.wallpaper.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import com.android.cgcxy.wallpaper.utils.Utils;

/**
 * Created by chuangguo.qi on 2017/7/25.
 */

public class MyImageView extends android.support.v7.widget.AppCompatImageView {

    // 控件默认长、宽
    private int defaultWidth = 0;
    private int defaultHeight = 0;
    private String TAG="MyImageView";


    // 比例
    private float scale = 0;
    private Paint mPaint;


    public MyImageView(Context context) {
        this(context,null);
    }


    public MyImageView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }


    public MyImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        this.measure(0, 0);
        if (drawable.getClass() == NinePatchDrawable.class)
            return;
        Bitmap b = ((BitmapDrawable) drawable).getBitmap();
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);
        if (bitmap.getWidth() == 0 || bitmap.getHeight() == 0) {
            return;
        }
        if (defaultWidth == 0) {
            defaultWidth = getWidth();


        }
        if (defaultHeight == 0) {
            defaultHeight = getHeight();
        }

        Matrix matrix = new Matrix();
        float i = (float)(Utils.getScreenDispaly(getContext())[0]) / bitmap.getWidth();
        float i1 = (float)(Utils.getScreenDispaly(getContext())[1]) / bitmap.getHeight();
        matrix.postScale(i,i1);
        bitmap= Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
        canvas.drawBitmap(bitmap, 0,0,mPaint);

    }
}
