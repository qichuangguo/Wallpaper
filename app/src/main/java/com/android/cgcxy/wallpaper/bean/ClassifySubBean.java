package com.android.cgcxy.wallpaper.bean;

import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/21.
 */

public class ClassifySubBean {

    private int tid;
    private String name;
    private String type;
    private int color_id;
    private UrlBean url;
    private LinkBean link;
    private String color;
    private List<Double> useTime;
    private List<DataBean> data;
    private List<ColorlistBean> colorlist;
    private List<TagsBeanX> tags;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public UrlBean getUrl() {
        return url;
    }

    public void setUrl(UrlBean url) {
        this.url = url;
    }

    public LinkBean getLink() {
        return link;
    }

    public void setLink(LinkBean link) {
        this.link = link;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Double> getUseTime() {
        return useTime;
    }

    public void setUseTime(List<Double> useTime) {
        this.useTime = useTime;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public List<ColorlistBean> getColorlist() {
        return colorlist;
    }

    public void setColorlist(List<ColorlistBean> colorlist) {
        this.colorlist = colorlist;
    }

    public List<TagsBeanX> getTags() {
        return tags;
    }

    public void setTags(List<TagsBeanX> tags) {
        this.tags = tags;
    }

    public static class UrlBean {
        /**
         * hot : http://api.lovebizhi.com/android_v3.php?a=category&tid=2&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&retina=0&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&jailbreak=0&mac=&original=0&order=hot&color_id=3
         * newest : http://api.lovebizhi.com/android_v3.php?a=category&tid=2&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&retina=0&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&jailbreak=0&mac=&original=0&order=newest&color_id=3
         */

        private String hot;
        private String newest;

        public String getHot() {
            return hot;
        }

        public void setHot(String hot) {
            this.hot = hot;
        }

        public String getNewest() {
            return newest;
        }

        public void setNewest(String newest) {
            this.newest = newest;
        }
    }

    public static class LinkBean {
        /**
         * prev :
         * self : http://api.lovebizhi.com/android_v3.php?a=category&spdy=1&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0&tid=2
         * next : http://api.lovebizhi.com/android_v3.php?a=category&spdy=1&tid=2&order=hot&color_id=3&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0&p=2
         */

        private String prev;
        private String self;
        private String next;

        public String getPrev() {
            return prev;
        }

        public void setPrev(String prev) {
            this.prev = prev;
        }

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }
    }

    public static class DataBean {
        /**
         * enterable : true
         * file_id : 12433582
         * size_id : 0
         * group_id : 197178
         * key : 197178-105
         * number : 1197178
         * dlview : http://api.lovebizhi.com/android_v3.php?a=dlview&group_id=197178&user_id=0&client_id=1001&model_id=105&size_id=0
         * detail : http://api.lovebizhi.com/android_v3.php?a=detail&group_id=197178&spdy=1&tid=2&order=hot&color_id=3&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0
         * image : {"small":"http://s.qdcdn.com/cl/12433582,240,154.webp","big":"http://s.qdcdn.com/cl/12433582,480,308.webp","original":"http://s.qdcdn.com/c/12433582,1990,1280.webp","vip_original":"http://s.qdcdn.com/c/12433582,1990,1280.jpg","diy":"http://s.qdcdn.com/d/12433582.jpg"}
         * counts : {"loved":"3008","share":"2","down":"9.1万","puzzle":"7"}
         * share : {"api":"http://api.lovebizhi.com/user.php?a=share&group_id=197178&client_id=1001&version_code=87","url":"http://m.lovebizhi.com/share/1197178?from=client_1001","pic":"http://s.qdcdn.com/f/12433582.jpg"}
         * user : {"love":{"status":false,"create":"http://api.lovebizhi.com/user.php?a=love&op=create&client_id=1001&version_code=87","remove":"http://api.lovebizhi.com/user.php?a=love&op=remove&client_id=1001&version_code=87"},"addtag":"http://api.lovebizhi.com/user.php?a=addtag&group_id=197178&client_id=1001&version_code=87"}
         * tags : [{"tid":239,"name":"欧美风光","url":"http://api.lovebizhi.com/android_v3.php?a=tag&id=239&name=%E6%AC%A7%E7%BE%8E%E9%A3%8E%E5%85%89&spdy=1&tid=2&order=hot&color_id=3&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0"},{"tid":509,"name":"晚霞","url":"http://api.lovebizhi.com/android_v3.php?a=tag&id=509&name=%E6%99%9A%E9%9C%9E&spdy=1&tid=2&order=hot&color_id=3&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0"},{"tid":13568,"name":"美国风光","url":"http://api.lovebizhi.com/android_v3.php?a=tag&id=13568&name=%E7%BE%8E%E5%9B%BD%E9%A3%8E%E5%85%89&spdy=1&tid=2&order=hot&color_id=3&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0"}]
         * allow_diy : true
         * clickto : [{"urls":[{"name":"了解一下『星空』","link":"http://baike.baidu.com/subview/146296/6683549.htm?from=lovebizhi.com","key":"baike","from":"百度百科"}],"analyze":"http://api.lovebizhi.com/android_v3.php?a=clicktoanalyze&baike_id=277&spdy=1&tid=2&order=hot&color_id=3&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0"},{"urls":[{"name":"了解一下『中秋节』","link":"http://baike.baidu.com/view/2568.htm?from=lovebizhi.com","key":"baike","from":"百度百科"}],"analyze":"http://api.lovebizhi.com/android_v3.php?a=clicktoanalyze&baike_id=2360&spdy=1&tid=2&order=hot&color_id=3&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0"}]
         */

        private boolean enterable;
        private int file_id;
        private int size_id;
        private int group_id;
        private String key;
        private String number;
        private String dlview;
        private String detail;
        private ImageBean image;
        private CountsBean counts;
        private ShareBean share;
        private UserBean user;
        private boolean allow_diy;
        private List<TagsBean> tags;
        private List<ClicktoBean> clickto;

        public boolean isEnterable() {
            return enterable;
        }

        public void setEnterable(boolean enterable) {
            this.enterable = enterable;
        }

        public int getFile_id() {
            return file_id;
        }

        public void setFile_id(int file_id) {
            this.file_id = file_id;
        }

        public int getSize_id() {
            return size_id;
        }

        public void setSize_id(int size_id) {
            this.size_id = size_id;
        }

        public int getGroup_id() {
            return group_id;
        }

        public void setGroup_id(int group_id) {
            this.group_id = group_id;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getDlview() {
            return dlview;
        }

        public void setDlview(String dlview) {
            this.dlview = dlview;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public ImageBean getImage() {
            return image;
        }

        public void setImage(ImageBean image) {
            this.image = image;
        }

        public CountsBean getCounts() {
            return counts;
        }

        public void setCounts(CountsBean counts) {
            this.counts = counts;
        }

        public ShareBean getShare() {
            return share;
        }

        public void setShare(ShareBean share) {
            this.share = share;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public boolean isAllow_diy() {
            return allow_diy;
        }

        public void setAllow_diy(boolean allow_diy) {
            this.allow_diy = allow_diy;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public List<ClicktoBean> getClickto() {
            return clickto;
        }

        public void setClickto(List<ClicktoBean> clickto) {
            this.clickto = clickto;
        }

        public static class ImageBean {
            /**
             * small : http://s.qdcdn.com/cl/12433582,240,154.webp
             * big : http://s.qdcdn.com/cl/12433582,480,308.webp
             * original : http://s.qdcdn.com/c/12433582,1990,1280.webp
             * vip_original : http://s.qdcdn.com/c/12433582,1990,1280.jpg
             * diy : http://s.qdcdn.com/d/12433582.jpg
             */

            private String small;
            private String big;
            private String original;
            private String vip_original;
            private String diy;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getBig() {
                return big;
            }

            public void setBig(String big) {
                this.big = big;
            }

            public String getOriginal() {
                return original;
            }

            public void setOriginal(String original) {
                this.original = original;
            }

            public String getVip_original() {
                return vip_original;
            }

            public void setVip_original(String vip_original) {
                this.vip_original = vip_original;
            }

            public String getDiy() {
                return diy;
            }

            public void setDiy(String diy) {
                this.diy = diy;
            }
        }

        public static class CountsBean {
            /**
             * loved : 3008
             * share : 2
             * down : 9.1万
             * puzzle : 7
             */

            private String loved;
            private String share;
            private String down;
            private String puzzle;

            public String getLoved() {
                return loved;
            }

            public void setLoved(String loved) {
                this.loved = loved;
            }

            public String getShare() {
                return share;
            }

            public void setShare(String share) {
                this.share = share;
            }

            public String getDown() {
                return down;
            }

            public void setDown(String down) {
                this.down = down;
            }

            public String getPuzzle() {
                return puzzle;
            }

            public void setPuzzle(String puzzle) {
                this.puzzle = puzzle;
            }
        }

        public static class ShareBean {
            /**
             * api : http://api.lovebizhi.com/user.php?a=share&group_id=197178&client_id=1001&version_code=87
             * url : http://m.lovebizhi.com/share/1197178?from=client_1001
             * pic : http://s.qdcdn.com/f/12433582.jpg
             */

            private String api;
            private String url;
            private String pic;

            public String getApi() {
                return api;
            }

            public void setApi(String api) {
                this.api = api;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }
        }

        public static class UserBean {
            /**
             * love : {"status":false,"create":"http://api.lovebizhi.com/user.php?a=love&op=create&client_id=1001&version_code=87","remove":"http://api.lovebizhi.com/user.php?a=love&op=remove&client_id=1001&version_code=87"}
             * addtag : http://api.lovebizhi.com/user.php?a=addtag&group_id=197178&client_id=1001&version_code=87
             */

            private LoveBean love;
            private String addtag;

            public LoveBean getLove() {
                return love;
            }

            public void setLove(LoveBean love) {
                this.love = love;
            }

            public String getAddtag() {
                return addtag;
            }

            public void setAddtag(String addtag) {
                this.addtag = addtag;
            }

            public static class LoveBean {
                /**
                 * status : false
                 * create : http://api.lovebizhi.com/user.php?a=love&op=create&client_id=1001&version_code=87
                 * remove : http://api.lovebizhi.com/user.php?a=love&op=remove&client_id=1001&version_code=87
                 */

                private boolean status;
                private String create;
                private String remove;

                public boolean isStatus() {
                    return status;
                }

                public void setStatus(boolean status) {
                    this.status = status;
                }

                public String getCreate() {
                    return create;
                }

                public void setCreate(String create) {
                    this.create = create;
                }

                public String getRemove() {
                    return remove;
                }

                public void setRemove(String remove) {
                    this.remove = remove;
                }
            }
        }

        public static class TagsBean {
            /**
             * tid : 239
             * name : 欧美风光
             * url : http://api.lovebizhi.com/android_v3.php?a=tag&id=239&name=%E6%AC%A7%E7%BE%8E%E9%A3%8E%E5%85%89&spdy=1&tid=2&order=hot&color_id=3&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0
             */

            private int tid;
            private String name;
            private String url;

            public int getTid() {
                return tid;
            }

            public void setTid(int tid) {
                this.tid = tid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ClicktoBean {
            /**
             * urls : [{"name":"了解一下『星空』","link":"http://baike.baidu.com/subview/146296/6683549.htm?from=lovebizhi.com","key":"baike","from":"百度百科"}]
             * analyze : http://api.lovebizhi.com/android_v3.php?a=clicktoanalyze&baike_id=277&spdy=1&tid=2&order=hot&color_id=3&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0
             */

            private String analyze;
            private List<UrlsBean> urls;

            public String getAnalyze() {
                return analyze;
            }

            public void setAnalyze(String analyze) {
                this.analyze = analyze;
            }

            public List<UrlsBean> getUrls() {
                return urls;
            }

            public void setUrls(List<UrlsBean> urls) {
                this.urls = urls;
            }

            public static class UrlsBean {
                /**
                 * name : 了解一下『星空』
                 * link : http://baike.baidu.com/subview/146296/6683549.htm?from=lovebizhi.com
                 * key : baike
                 * from : 百度百科
                 */

                private String name;
                private String link;
                private String key;
                private String from;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getLink() {
                    return link;
                }

                public void setLink(String link) {
                    this.link = link;
                }

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public String getFrom() {
                    return from;
                }

                public void setFrom(String from) {
                    this.from = from;
                }
            }
        }
    }

    public static class ColorlistBean {
        /**
         * id : 3
         * name : quanse
         * url : http://api.lovebizhi.com/android_v3.php?a=category&color_id=3&spdy=1&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0&tid=2
         */

        private int id;
        private String name;
        private String url;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class TagsBeanX {
        /**
         * tid : 2631
         * image : http://s.qdcdn.com/cl/14506578,256,256.webp
         * name : 城市随景
         * url : http://api.lovebizhi.com/android_v3.php?a=category&tid=2631&spdy=1&device=Xiaomi%284655165%29&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=480&screen_height=800&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0
         */

        private int tid;
        private String image;
        private String name;
        private String url;

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
