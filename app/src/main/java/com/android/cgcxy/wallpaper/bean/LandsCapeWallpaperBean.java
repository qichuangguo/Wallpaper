package com.android.cgcxy.wallpaper.bean;

import java.util.List;

/**
 * Created by chuangguo.qi on 2018/5/25.
 */

public class LandsCapeWallpaperBean {



    private String msg;
    private ResBean res;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResBean getRes() {
        return res;
    }

    public void setRes(ResBean res) {
        this.res = res;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResBean {
        private List<WallpaperBean> wallpaper;

        public List<WallpaperBean> getWallpaper() {
            return wallpaper;
        }

        public void setWallpaper(List<WallpaperBean> wallpaper) {
            this.wallpaper = wallpaper;
        }

        public static class WallpaperBean {
            /**
             * preview : http://img.aibizhi.adesk.com/5ab83814e7bce7355224a6b3
             * thumb : http://img.aibizhi.adesk.com/5ab83814e7bce7355224a6b3
             * img : http://img.aibizhi.adesk.com/5ab83814e7bce7355224a6b3
             * views : 0
             * cid : ["4e4d610cdf714d2966000007"]
             * source_type : wallpaper
             * ncos : 96
             * rank : 241068
             * url : []
             * rule_new : ?imageMogr2/thumbnail/!$<Width>x$<Height>r/gravity/Center/crop/$<Width>x$<Height>
             * tag : []
             * rule : ?imageView2/3/h/$<Height>
             * wp : http://img.aibizhi.adesk.com/5ab83814e7bce7355224a6b3
             * xr : false
             * cr : false
             * favs : 5023
             * atime : 1.522159212E9
             * type : wallpaper
             * id : 5ab83814e7bce7355224a6b3
             * store : qiniu
             * desc :
             */

            private String preview;
            private String thumb;
            private String img;
            private int views;
            private String source_type;
            private int ncos;
            private int rank;
            private String rule_new;
            private String rule;
            private String wp;
            private boolean xr;
            private boolean cr;
            private int favs;
            private double atime;
            private String type;
            private String id;
            private String store;
            private String desc;
            private List<String> cid;
            private List<?> url;
            private List<?> tag;

            public String getPreview() {
                return preview;
            }

            public void setPreview(String preview) {
                this.preview = preview;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public String getSource_type() {
                return source_type;
            }

            public void setSource_type(String source_type) {
                this.source_type = source_type;
            }

            public int getNcos() {
                return ncos;
            }

            public void setNcos(int ncos) {
                this.ncos = ncos;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public String getRule_new() {
                return rule_new;
            }

            public void setRule_new(String rule_new) {
                this.rule_new = rule_new;
            }

            public String getRule() {
                return rule;
            }

            public void setRule(String rule) {
                this.rule = rule;
            }

            public String getWp() {
                return wp;
            }

            public void setWp(String wp) {
                this.wp = wp;
            }

            public boolean isXr() {
                return xr;
            }

            public void setXr(boolean xr) {
                this.xr = xr;
            }

            public boolean isCr() {
                return cr;
            }

            public void setCr(boolean cr) {
                this.cr = cr;
            }

            public int getFavs() {
                return favs;
            }

            public void setFavs(int favs) {
                this.favs = favs;
            }

            public double getAtime() {
                return atime;
            }

            public void setAtime(double atime) {
                this.atime = atime;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getStore() {
                return store;
            }

            public void setStore(String store) {
                this.store = store;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public List<String> getCid() {
                return cid;
            }

            public void setCid(List<String> cid) {
                this.cid = cid;
            }

            public List<?> getUrl() {
                return url;
            }

            public void setUrl(List<?> url) {
                this.url = url;
            }

            public List<?> getTag() {
                return tag;
            }

            public void setTag(List<?> tag) {
                this.tag = tag;
            }
        }
    }
}
