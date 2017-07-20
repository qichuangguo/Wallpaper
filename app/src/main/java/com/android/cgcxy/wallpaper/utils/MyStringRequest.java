package com.android.cgcxy.wallpaper.utils;

/**
 * Created by chuangguo.qi on 2017/7/20.
 */
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import com.android.volley.Request;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;


public class MyStringRequest extends Request<String> {
    private Listener<String> mListener;

    public MyStringRequest(int method, String url, Listener<String> listener, ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mListener = listener;
    }

    public MyStringRequest(String url, Listener<String> listener, ErrorListener errorListener) {
        this(0, url, listener, errorListener);
    }

    protected void onFinish() {
        super.onFinish();
        this.mListener = null;
    }

    protected void deliverResponse(String response) {
        if(this.mListener != null) {
            this.mListener.onResponse(response);
        }

    }

    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String parsed;
        try {
            parsed = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
        } catch (UnsupportedEncodingException var4) {
            parsed = new String(response.data);
        }

        return Response.success(parsed, MyHttpHeaderParser.MyparseCacheHeaders(response,1000*60*60*24));
    }
}
