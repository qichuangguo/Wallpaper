package com.android.cgcxy.wallpaper.utils;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public class JsonUtils {

    public static <T> List<T> jsonToList(String json, Class<T[]> clazz)
    {
        Gson gson = new Gson();
        T[] array = gson.fromJson(json, clazz);
        return Arrays.asList(array);
    }
}
