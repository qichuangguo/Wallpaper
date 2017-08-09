package com.android.cgcxy.wallpaper.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by chuangguo.qi on 2017/7/18.
 */

public class HompPagerBean implements Serializable {


    private LinkBean link;
    private List<Double> useTime;
    private List<SliderBean> slider;
    private List<DataBean> data;

    public LinkBean getLink() {
        return link;
    }



    public void setLink(LinkBean link) {
        this.link = link;
    }

    public List<Double> getUseTime() {
        return useTime;
    }

    public void setUseTime(List<Double> useTime) {
        this.useTime = useTime;
    }

    public List<SliderBean> getSlider() {
        return slider;
    }

    public void setSlider(List<SliderBean> slider) {
        this.slider = slider;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class LinkBean {

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

    public static class SliderBean {

        private String type;
        private String name;
        private String detail;
        private String analyze;
        private String image;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public String getAnalyze() {
            return analyze;
        }

        public void setAnalyze(String analyze) {
            this.analyze = analyze;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public static class DataBean {

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
        private ImageTextBean image_text;
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

        public ImageTextBean getImage_text() {
            return image_text;
        }

        public void setImage_text(ImageTextBean image_text) {
            this.image_text = image_text;
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
             * small : http://s.qdcdn.com/cl/14530584,360,231.webp
             * big : http://s.qdcdn.com/c/14530584,1080,694.webp
             * original : http://s.qdcdn.com/c/14530584,1080,694.webp
             * vip_original : http://s.qdcdn.com/c/14530584,1080,694.jpg
             * diy : http://s.qdcdn.com/d/14530584.jpg
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
             * puzzle : 0
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

        public static class ImageTextBean {


            private int group_id;
            private String start_date;
            private String info_text;
            private String image;
            private List<UrlsBean> urls;

            public int getGroup_id() {
                return group_id;
            }

            public void setGroup_id(int group_id) {
                this.group_id = group_id;
            }

            public String getStart_date() {
                return start_date;
            }

            public void setStart_date(String start_date) {
                this.start_date = start_date;
            }

            public String getInfo_text() {
                return info_text;
            }

            public void setInfo_text(String info_text) {
                this.info_text = info_text;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public List<UrlsBean> getUrls() {
                return urls;
            }

            public void setUrls(List<UrlsBean> urls) {
                this.urls = urls;
            }

            public static class UrlsBean {


                private String name;
                private String link;

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
            }
        }

        public static class TagsBean {


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

            private String analyze;
            private List<UrlsBeanX> urls;

            public String getAnalyze() {
                return analyze;
            }

            public void setAnalyze(String analyze) {
                this.analyze = analyze;
            }

            public List<UrlsBeanX> getUrls() {
                return urls;
            }

            public void setUrls(List<UrlsBeanX> urls) {
                this.urls = urls;
            }

            public static class UrlsBeanX {


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
