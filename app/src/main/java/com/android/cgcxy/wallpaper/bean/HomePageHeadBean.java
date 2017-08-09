package com.android.cgcxy.wallpaper.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/20.
 */

public class HomePageHeadBean implements Serializable {

    private TestBean test;
    private String name;
    private String image;
    private String description;
    private LinkBean link;
    private List<DataBean> data;

    public TestBean getTest() {
        return test;
    }

    public void setTest(TestBean test) {
        this.test = test;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LinkBean getLink() {
        return link;
    }

    public void setLink(LinkBean link) {
        this.link = link;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class TestBean {
        /**
         * s_size_id : 0
         */

        private int s_size_id;

        public int getS_size_id() {
            return s_size_id;
        }

        public void setS_size_id(int s_size_id) {
            this.s_size_id = s_size_id;
        }
    }

    public static class LinkBean {
        /**
         * prev :
         * self : http://api.lovebizhi.com/android_v3.php?a=special&special_id=803&spdy=1&slider=home&device=Meizum1+metal&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0
         * next : http://api.lovebizhi.com/android_v3.php?a=special&spdy=1&special_id=803&device=Meizum1+metal&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0&p=2
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
         * file_id : 14511331
         * size_id : 0
         * group_id : 354389
         * key : 354389-105
         * number : 1354389
         * dlview : http://api.lovebizhi.com/android_v3.php?a=dlview&group_id=354389&user_id=0&client_id=1001&model_id=105&size_id=0
         * detail : http://api.lovebizhi.com/android_v3.php?a=detail&group_id=354389&spdy=1&special_id=803&device=Meizum1+metal&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0
         * image : {"small":"http://s.qdcdn.com/cl/14511331,360,231.webp","big":"http://s.qdcdn.com/c/14511331,1080,694.webp","original":"http://s.qdcdn.com/c/14511331,1080,694.webp","vip_original":"http://s.qdcdn.com/c/14511331,1080,694.jpg","diy":"http://s.qdcdn.com/d/14511331.jpg"}
         * counts : {"loved":"0","share":"0","down":"0","puzzle":"4"}
         * share : {"api":"http://api.lovebizhi.com/user.php?a=share&group_id=354389&client_id=1001&version_code=87","url":"http://m.lovebizhi.com/share/1354389?from=client_1001","pic":"http://s.qdcdn.com/f/14511331.jpg"}
         * user : {"love":{"status":false,"create":"http://api.lovebizhi.com/user.php?a=love&op=create&client_id=1001&version_code=87","remove":"http://api.lovebizhi.com/user.php?a=love&op=remove&client_id=1001&version_code=87"},"addtag":"http://api.lovebizhi.com/user.php?a=addtag&group_id=354389&client_id=1001&version_code=87"}
         * tags : [{"tid":2424,"name":"动漫合集","url":"http://api.lovebizhi.com/android_v3.php?a=tag&id=2424&name=%E5%8A%A8%E6%BC%AB%E5%90%88%E9%9B%86&spdy=1&special_id=803&device=Meizum1+metal&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0"},{"tid":65968,"name":"日系动漫","url":"http://api.lovebizhi.com/android_v3.php?a=tag&id=65968&name=%E6%97%A5%E7%B3%BB%E5%8A%A8%E6%BC%AB&spdy=1&special_id=803&device=Meizum1+metal&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0"}]
         * allow_diy : true
         * clickto : [{"urls":[{"name":"了解一下『星空』","link":"http://baike.baidu.com/subview/146296/6683549.htm?from=lovebizhi.com","key":"baike","from":"百度百科"}],"analyze":"http://api.lovebizhi.com/android_v3.php?a=clicktoanalyze&baike_id=277&spdy=1&special_id=803&device=Meizum1+metal&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0"}]
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
             * small : http://s.qdcdn.com/cl/14511331,360,231.webp
             * big : http://s.qdcdn.com/c/14511331,1080,694.webp
             * original : http://s.qdcdn.com/c/14511331,1080,694.webp
             * vip_original : http://s.qdcdn.com/c/14511331,1080,694.jpg
             * diy : http://s.qdcdn.com/d/14511331.jpg
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
             * loved : 0
             * share : 0
             * down : 0
             * puzzle : 4
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
             * api : http://api.lovebizhi.com/user.php?a=share&group_id=354389&client_id=1001&version_code=87
             * url : http://m.lovebizhi.com/share/1354389?from=client_1001
             * pic : http://s.qdcdn.com/f/14511331.jpg
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
             * addtag : http://api.lovebizhi.com/user.php?a=addtag&group_id=354389&client_id=1001&version_code=87
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
             * tid : 2424
             * name : 动漫合集
             * url : http://api.lovebizhi.com/android_v3.php?a=tag&id=2424&name=%E5%8A%A8%E6%BC%AB%E5%90%88%E9%9B%86&spdy=1&special_id=803&device=Meizum1+metal&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0
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
             * analyze : http://api.lovebizhi.com/android_v3.php?a=clicktoanalyze&baike_id=277&spdy=1&special_id=803&device=Meizum1+metal&uuid=436c238c6262596acd5c08a25e176efe&mode=1&client_id=1001&device_id=73769687&model_id=105&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1990&bizhi_height=1280&version_code=87&language=zh-CN&mac=&original=0
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
}
