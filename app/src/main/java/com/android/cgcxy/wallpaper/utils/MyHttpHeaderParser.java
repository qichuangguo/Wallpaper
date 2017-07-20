package com.android.cgcxy.wallpaper.utils;

import android.text.format.DateUtils;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.toolbox.HttpHeaderParser;

import java.util.Map;

/**
 * Created by chuangguo.qi on 2017/7/20.
 */

public class MyHttpHeaderParser extends  HttpHeaderParser{

    public MyHttpHeaderParser() {
    }

    public static Cache.Entry MyparseCacheHeaders(NetworkResponse response,long cacheTime) {
        Cache.Entry entry=parseCacheHeaders(response);
        long now = System.currentTimeMillis();
        long softExpire=now+cacheTime;
        entry.softTtl = softExpire;
        entry.ttl = entry.softTtl;
        return entry;
    }


    public static Cache.Entry parseCacheHeaders(NetworkResponse response) {
        long now = System.currentTimeMillis();
        Map headers = response.headers;
        long serverDate = 0L;
        long lastModified = 0L;
        long serverExpires = 0L;
        long softExpire = 0L;
        long finalExpire = 0L;
        long maxAge = 0L;
        long staleWhileRevalidate = 0L;
        boolean hasCacheControl = false;
        boolean mustRevalidate = false;
        String serverEtag = null;
        String headerValue = (String)headers.get("Date");
        if(headerValue != null) {
            serverDate = parseDateAsEpoch(headerValue);
        }

        headerValue = (String)headers.get("Cache-Control");
        if(headerValue != null) {
            hasCacheControl = true;
            String[] entry = headerValue.split(",");

            for(int i = 0; i < entry.length; ++i) {
                String token = entry[i].trim();
                if(token.equals("no-cache") || token.equals("no-store")) {
                    //return null;
                }

                if(token.startsWith("max-age=")) {
                    try {
                        maxAge = Long.parseLong(token.substring(8));
                    } catch (Exception var27) {
                        ;
                    }
                } else if(token.startsWith("stale-while-revalidate=")) {
                    try {
                        staleWhileRevalidate = Long.parseLong(token.substring(23));
                    } catch (Exception var26) {
                        ;
                    }
                } else if(token.equals("must-revalidate") || token.equals("proxy-revalidate")) {
                    mustRevalidate = true;
                }
            }
        }

        headerValue = (String)headers.get("Expires");
        if(headerValue != null) {
            serverExpires = parseDateAsEpoch(headerValue);
        }

        headerValue = (String)headers.get("Last-Modified");
        if(headerValue != null) {
            lastModified = parseDateAsEpoch(headerValue);
        }

        serverEtag = (String)headers.get("ETag");
        if(hasCacheControl) {
            softExpire = now + maxAge * 1000L;
            finalExpire = mustRevalidate?softExpire:softExpire + staleWhileRevalidate * 1000L;
        } else if(serverDate > 0L && serverExpires >= serverDate) {
            softExpire = now + (serverExpires - serverDate);
            finalExpire = softExpire;
        }

        Cache.Entry var28 = new Cache.Entry();
        var28.data = response.data;
        var28.etag = serverEtag;
        var28.softTtl = softExpire;
        var28.ttl = finalExpire;
        var28.serverDate = serverDate;
        var28.lastModified = lastModified;
        var28.responseHeaders = headers;
        return var28;
    }


}
