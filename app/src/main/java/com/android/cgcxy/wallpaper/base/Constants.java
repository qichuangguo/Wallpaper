package com.android.cgcxy.wallpaper.base;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public interface Constants {

     String mainUrl="http://service.aibizhi.adesk.com/";
     String HomePage = mainUrl+"v3/homepage";
     String HomePageParameter = "?limit=30&skip=%s&adult=false&did=%s&first=0&order=hot";

     String maxImageLoadUrl="http://img0.adesk.com/wallpaper?imgid=%s&reso=%s";
     String HomePageHead = mainUrl+"v1/wallpaper/album/%s/wallpaper?limit=30&adult=false&first=1&order=new";

     String categoryUrl = mainUrl+"v1/vertical/category";

     //http://service.aibizhi.adesk.com/v1/vertical/category/4e4d610cdf714d2966000000/vertical?limit=30&adult=false&first=1&order=new
     //limit=30&adult=false&first=1&order=new

     String categoryDetails=categoryUrl+"/%s"+"/vertical?limit=30&adult=false&first=0&order=new";
     String categoryDetailsHot=categoryUrl+"/%s"+"/vertical?limit=30&adult=false&first=0&order=hot";

     //String adult="?adult=false";
     boolean adult=false;

     String USERBEAN="userBean";
}
