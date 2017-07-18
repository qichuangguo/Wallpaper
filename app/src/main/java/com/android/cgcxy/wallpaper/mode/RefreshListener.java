package com.android.cgcxy.wallpaper.mode;

/**
 * Created by chuangguo.qi on 2017/7/13.
 */

public interface RefreshListener {
    <T>void  resultListener(T t);
    <E>void  onError(E e);
}
