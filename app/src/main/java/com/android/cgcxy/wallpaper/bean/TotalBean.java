package com.android.cgcxy.wallpaper.bean;

import java.util.List;

/**
 * Created by qichuangguo on 2017/8/8.
 */

public class TotalBean {


    private boolean filter;
    private String home;
    private String tryluck;
    private TagBean tag;
    private GameBean game;
    private UserBeanX user;
    private MoreBean more;
    private FeedbackBean feedback;
    private ImagehelpBean imagehelp;
    private boolean filter_recommend;
    private LockScreenBean lock_screen;
    private MultiScreenBean multi_screen;
    private boolean wandoujia;
    private RingBean ring;
    private int app_recommend_list_sdk;
    private int app_recommend_detail_sdk;
    private int app_recommend_startup_sdk;
    private List<BrowseBean> browse;

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getTryluck() {
        return tryluck;
    }

    public void setTryluck(String tryluck) {
        this.tryluck = tryluck;
    }

    public TagBean getTag() {
        return tag;
    }

    public void setTag(TagBean tag) {
        this.tag = tag;
    }

    public GameBean getGame() {
        return game;
    }

    public void setGame(GameBean game) {
        this.game = game;
    }

    public UserBeanX getUser() {
        return user;
    }

    public void setUser(UserBeanX user) {
        this.user = user;
    }

    public MoreBean getMore() {
        return more;
    }

    public void setMore(MoreBean more) {
        this.more = more;
    }

    public FeedbackBean getFeedback() {
        return feedback;
    }

    public void setFeedback(FeedbackBean feedback) {
        this.feedback = feedback;
    }

    public ImagehelpBean getImagehelp() {
        return imagehelp;
    }

    public void setImagehelp(ImagehelpBean imagehelp) {
        this.imagehelp = imagehelp;
    }

    public boolean isFilter_recommend() {
        return filter_recommend;
    }

    public void setFilter_recommend(boolean filter_recommend) {
        this.filter_recommend = filter_recommend;
    }

    public LockScreenBean getLock_screen() {
        return lock_screen;
    }

    public void setLock_screen(LockScreenBean lock_screen) {
        this.lock_screen = lock_screen;
    }

    public MultiScreenBean getMulti_screen() {
        return multi_screen;
    }

    public void setMulti_screen(MultiScreenBean multi_screen) {
        this.multi_screen = multi_screen;
    }

    public boolean isWandoujia() {
        return wandoujia;
    }

    public void setWandoujia(boolean wandoujia) {
        this.wandoujia = wandoujia;
    }

    public RingBean getRing() {
        return ring;
    }

    public void setRing(RingBean ring) {
        this.ring = ring;
    }

    public int getApp_recommend_list_sdk() {
        return app_recommend_list_sdk;
    }

    public void setApp_recommend_list_sdk(int app_recommend_list_sdk) {
        this.app_recommend_list_sdk = app_recommend_list_sdk;
    }

    public int getApp_recommend_detail_sdk() {
        return app_recommend_detail_sdk;
    }

    public void setApp_recommend_detail_sdk(int app_recommend_detail_sdk) {
        this.app_recommend_detail_sdk = app_recommend_detail_sdk;
    }

    public int getApp_recommend_startup_sdk() {
        return app_recommend_startup_sdk;
    }

    public void setApp_recommend_startup_sdk(int app_recommend_startup_sdk) {
        this.app_recommend_startup_sdk = app_recommend_startup_sdk;
    }

    public List<BrowseBean> getBrowse() {
        return browse;
    }

    public void setBrowse(List<BrowseBean> browse) {
        this.browse = browse;
    }

    public static class TagBean {
        /**
         * image : http://api.lovebizhi.com/android_v3.php?a=search&kw={kw}&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * image2 : http://api.lovebizhi.com/android_v3.php?a=search2&kw={kw}&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * cloud : http://api.lovebizhi.com/android_v3.php?a=hotword&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * search : http://api.lovebizhi.com/android_v3.php?a=tagword&kw={kw}&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * ir_search : http://api.lovebizhi.com/android_v3.php?a=search3&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         */

        private String image;
        private String image2;
        private String cloud;
        private String search;
        private String ir_search;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImage2() {
            return image2;
        }

        public void setImage2(String image2) {
            this.image2 = image2;
        }

        public String getCloud() {
            return cloud;
        }

        public void setCloud(String cloud) {
            this.cloud = cloud;
        }

        public String getSearch() {
            return search;
        }

        public void setSearch(String search) {
            this.search = search;
        }

        public String getIr_search() {
            return ir_search;
        }

        public void setIr_search(String ir_search) {
            this.ir_search = ir_search;
        }
    }

    public static class GameBean {
        /**
         * puzzle : {"get_score":"http://api.lovebizhi.com/puzzle_game.php?a=score&op=get&client_id=1001&version_code=87&screen_width=1080","set_score":"http://api.lovebizhi.com/puzzle_game.php?a=score&op=set&client_id=1001&version_code=87&screen_width=1080","event":{"home":"http://api.lovebizhi.com/puzzle_event.php?a=home&client_id=1001&version_code=87&screen_width=1080","user":"http://api.lovebizhi.com/puzzle_event.php?a=prize&client_id=1001&version_code=87&screen_width=1080","hot":"http://api.lovebizhi.com/android_v3.php?a=puzzle&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","set_score":"http://api.lovebizhi.com/puzzle_event.php?a=score&op=set&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","get_score":"http://api.lovebizhi.com/puzzle_event.php?a=score&op=get&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0"}}
         * flipcard : {"images":"http://api.lovebizhi.com/flipcard_game.php?a=home&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","list":"http://api.lovebizhi.com/flipcard_game.php?a=list&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","ranking":"http://api.lovebizhi.com/flipcard_game.php?a=ranking&type={type}&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","set_score":"http://api.lovebizhi.com/flipcard_game.php?a=score&op=set&client_id=1001&version_code=87&screen_width=1080","get_score":"http://api.lovebizhi.com/flipcard_game.php?a=score&op=get&type={type}&client_id=1001&version_code=87&screen_width=1080"}
         */

        private PuzzleBean puzzle;
        private FlipcardBean flipcard;

        public PuzzleBean getPuzzle() {
            return puzzle;
        }

        public void setPuzzle(PuzzleBean puzzle) {
            this.puzzle = puzzle;
        }

        public FlipcardBean getFlipcard() {
            return flipcard;
        }

        public void setFlipcard(FlipcardBean flipcard) {
            this.flipcard = flipcard;
        }

        public static class PuzzleBean {
            /**
             * get_score : http://api.lovebizhi.com/puzzle_game.php?a=score&op=get&client_id=1001&version_code=87&screen_width=1080
             * set_score : http://api.lovebizhi.com/puzzle_game.php?a=score&op=set&client_id=1001&version_code=87&screen_width=1080
             * event : {"home":"http://api.lovebizhi.com/puzzle_event.php?a=home&client_id=1001&version_code=87&screen_width=1080","user":"http://api.lovebizhi.com/puzzle_event.php?a=prize&client_id=1001&version_code=87&screen_width=1080","hot":"http://api.lovebizhi.com/android_v3.php?a=puzzle&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","set_score":"http://api.lovebizhi.com/puzzle_event.php?a=score&op=set&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","get_score":"http://api.lovebizhi.com/puzzle_event.php?a=score&op=get&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0"}
             */

            private String get_score;
            private String set_score;
            private EventBean event;

            public String getGet_score() {
                return get_score;
            }

            public void setGet_score(String get_score) {
                this.get_score = get_score;
            }

            public String getSet_score() {
                return set_score;
            }

            public void setSet_score(String set_score) {
                this.set_score = set_score;
            }

            public EventBean getEvent() {
                return event;
            }

            public void setEvent(EventBean event) {
                this.event = event;
            }

            public static class EventBean {
                /**
                 * home : http://api.lovebizhi.com/puzzle_event.php?a=home&client_id=1001&version_code=87&screen_width=1080
                 * user : http://api.lovebizhi.com/puzzle_event.php?a=prize&client_id=1001&version_code=87&screen_width=1080
                 * hot : http://api.lovebizhi.com/android_v3.php?a=puzzle&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
                 * set_score : http://api.lovebizhi.com/puzzle_event.php?a=score&op=set&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
                 * get_score : http://api.lovebizhi.com/puzzle_event.php?a=score&op=get&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
                 */

                private String home;
                private String user;
                private String hot;
                private String set_score;
                private String get_score;

                public String getHome() {
                    return home;
                }

                public void setHome(String home) {
                    this.home = home;
                }

                public String getUser() {
                    return user;
                }

                public void setUser(String user) {
                    this.user = user;
                }

                public String getHot() {
                    return hot;
                }

                public void setHot(String hot) {
                    this.hot = hot;
                }

                public String getSet_score() {
                    return set_score;
                }

                public void setSet_score(String set_score) {
                    this.set_score = set_score;
                }

                public String getGet_score() {
                    return get_score;
                }

                public void setGet_score(String get_score) {
                    this.get_score = get_score;
                }
            }
        }

        public static class FlipcardBean {
            /**
             * images : http://api.lovebizhi.com/flipcard_game.php?a=home&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
             * list : http://api.lovebizhi.com/flipcard_game.php?a=list&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
             * ranking : http://api.lovebizhi.com/flipcard_game.php?a=ranking&type={type}&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
             * set_score : http://api.lovebizhi.com/flipcard_game.php?a=score&op=set&client_id=1001&version_code=87&screen_width=1080
             * get_score : http://api.lovebizhi.com/flipcard_game.php?a=score&op=get&type={type}&client_id=1001&version_code=87&screen_width=1080
             */

            private String images;
            private String list;
            private String ranking;
            private String set_score;
            private String get_score;

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getList() {
                return list;
            }

            public void setList(String list) {
                this.list = list;
            }

            public String getRanking() {
                return ranking;
            }

            public void setRanking(String ranking) {
                this.ranking = ranking;
            }

            public String getSet_score() {
                return set_score;
            }

            public void setSet_score(String set_score) {
                this.set_score = set_score;
            }

            public String getGet_score() {
                return get_score;
            }

            public void setGet_score(String get_score) {
                this.get_score = get_score;
            }
        }
    }

    public static class UserBeanX {
        /**
         * bgimage : http://s.qdcdn.com/cl/14547569,1080,1080.webp
         * init : http://api.lovebizhi.com/user.php?a=init&client_id=1001&version_code=87&language=zh-CN&channel_id=1
         * sdk_oauth : http://api.lovebizhi.com/sdk_oauth.php?client_id=1001&version_code=87&language=zh-CN&channel_id=1
         * login : http://api.lovebizhi.com/login.php?client_id=1001&version_code=87&language=zh-CN&channel_id=1
         * register : http://api.lovebizhi.com/register.php?client_id=1001&version_code=87&language=zh-CN&channel_id=1
         * account : http://api.lovebizhi.com/account.php?client_id=1001&version_code=87&language=zh-CN&channel_id=1
         * smart : http://api.lovebizhi.com/android_v3.php?a=user&browse=smart&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * counter : http://api.lovebizhi.com/android_v3.php?a=user&browse=counter&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * favorites : http://api.lovebizhi.com/android_v3.php?a=user&browse=favorites&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * share : http://api.lovebizhi.com/android_v3.php?a=user&browse=share&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * download : http://api.lovebizhi.com/android_v3.php?a=user&browse=download&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * remove_download : http://api.lovebizhi.com/user.php?a=removeDownload&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * puzzle : http://api.lovebizhi.com/android_v3.php?a=user&browse=puzzle&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * tag_image : http://api.lovebizhi.com/android_v3.php?a=user&browse=tag_image&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * sync : http://api.lovebizhi.com/android_v3.php?a=sync&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * sync_state : http://api.lovebizhi.com/user.php?a=sync_state&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * auto_wallpaper_options : http://api.lovebizhi.com/user.php?a=autoWallpaper&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * payment : {"iap":"http://api.lovebizhi.com/user.php?a=purchase&client_id=1001&version_code=87&language=zh-CN&channel_id=1","apple":"http://api.lovebizhi.com/user.php?a=apple&client_id=1001&version_code=87&language=zh-CN&channel_id=1"}
         * follow : {"fans":"http://api.lovebizhi.com/android_v3.php?a=follow&type=fans&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","user":{"list":"http://api.lovebizhi.com/android_v3.php?a=follow&type=user&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","create":"http://api.lovebizhi.com/user.php?a=followUser&client_id=1001&version_code=87&language=zh-CN&channel_id=1","remove":"http://api.lovebizhi.com/user.php?a=followUser&op=remove&client_id=1001&version_code=87&language=zh-CN&channel_id=1"},"tag":{"list":"http://api.lovebizhi.com/android_v3.php?a=follow&type=tag&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","create":"http://api.lovebizhi.com/user.php?a=followTag&client_id=1001&version_code=87&language=zh-CN&channel_id=1","remove":"http://api.lovebizhi.com/user.php?a=followTag&op=remove&client_id=1001&version_code=87&language=zh-CN&channel_id=1"}}
         * goods : http://m.lovebizhi.com/goods.php?a=list&client_id=1001&version_code=87&language=zh-CN&channel_id=1
         * activity : {"donate_vip":"http://api.lovebizhi.com/android_v3.php?a=donateVip&client_id=1001&version_code=87&language=zh-CN&channel_id=1"}
         * face : {"upload":"http://api.lovebizhi.com/user.php?a=face&client_id=1001&version_code=87&language=zh-CN&channel_id=1"}
         * album : {"list":"http://api.lovebizhi.com/android_v3.php?a=user&browse=album_list&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","create":"http://api.lovebizhi.com/user.php?a=album&op=create&client_id=1001&version_code=87&language=zh-CN&channel_id=1","remove":"http://api.lovebizhi.com/user.php?a=album&op=remove&client_id=1001&version_code=87&language=zh-CN&channel_id=1","upload":{"image":"http://api.lovebizhi.com/user.php?a=upload&op=image&client_id=1001&version_code=87&language=zh-CN&channel_id=1","verify":"http://api.lovebizhi.com/user.php?a=upload&op=verify&client_id=1001&version_code=87&language=zh-CN&channel_id=1","remove":"http://api.lovebizhi.com/user.php?a=album&op=remove_image"},"allow_list":[{"width":1080,"height":1920},{"width":2160,"height":1920}]}
         * cloud : {"album":{"list":"http://api.lovebizhi.com/android_v3.php?a=user&browse=cloud_list&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","create":"http://api.lovebizhi.com/cloud.php?a=album&op=create&client_id=1001&version_code=87&language=zh-CN&channel_id=1","remove":"http://api.lovebizhi.com/cloud.php?a=album&op=remove&client_id=1001&version_code=87&language=zh-CN&channel_id=1","upload":{"image":"http://api.lovebizhi.com/cloud.php?a=upload&op=image&client_id=1001&version_code=87&language=zh-CN&channel_id=1","verify":"http://api.lovebizhi.com/cloud.php?a=upload&op=verify&client_id=1001&version_code=87&language=zh-CN&channel_id=1","remove":"http://api.lovebizhi.com/cloud.php?a=image"},"allow_list":[{"width":1080,"height":1920},{"width":2160,"height":1920}]}}
         */

        private String bgimage;
        private String init;
        private String sdk_oauth;
        private String login;
        private String register;
        private String account;
        private String smart;
        private String counter;
        private String favorites;
        private String share;
        private String download;
        private String remove_download;
        private String puzzle;
        private String tag_image;
        private String sync;
        private String sync_state;
        private String auto_wallpaper_options;
        private PaymentBean payment;
        private FollowBean follow;
        private String goods;
        private ActivityBean activity;
        private FaceBean face;
        private AlbumBean album;
        private CloudBean cloud;

        public String getBgimage() {
            return bgimage;
        }

        public void setBgimage(String bgimage) {
            this.bgimage = bgimage;
        }

        public String getInit() {
            return init;
        }

        public void setInit(String init) {
            this.init = init;
        }

        public String getSdk_oauth() {
            return sdk_oauth;
        }

        public void setSdk_oauth(String sdk_oauth) {
            this.sdk_oauth = sdk_oauth;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getRegister() {
            return register;
        }

        public void setRegister(String register) {
            this.register = register;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getSmart() {
            return smart;
        }

        public void setSmart(String smart) {
            this.smart = smart;
        }

        public String getCounter() {
            return counter;
        }

        public void setCounter(String counter) {
            this.counter = counter;
        }

        public String getFavorites() {
            return favorites;
        }

        public void setFavorites(String favorites) {
            this.favorites = favorites;
        }

        public String getShare() {
            return share;
        }

        public void setShare(String share) {
            this.share = share;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public String getRemove_download() {
            return remove_download;
        }

        public void setRemove_download(String remove_download) {
            this.remove_download = remove_download;
        }

        public String getPuzzle() {
            return puzzle;
        }

        public void setPuzzle(String puzzle) {
            this.puzzle = puzzle;
        }

        public String getTag_image() {
            return tag_image;
        }

        public void setTag_image(String tag_image) {
            this.tag_image = tag_image;
        }

        public String getSync() {
            return sync;
        }

        public void setSync(String sync) {
            this.sync = sync;
        }

        public String getSync_state() {
            return sync_state;
        }

        public void setSync_state(String sync_state) {
            this.sync_state = sync_state;
        }

        public String getAuto_wallpaper_options() {
            return auto_wallpaper_options;
        }

        public void setAuto_wallpaper_options(String auto_wallpaper_options) {
            this.auto_wallpaper_options = auto_wallpaper_options;
        }

        public PaymentBean getPayment() {
            return payment;
        }

        public void setPayment(PaymentBean payment) {
            this.payment = payment;
        }

        public FollowBean getFollow() {
            return follow;
        }

        public void setFollow(FollowBean follow) {
            this.follow = follow;
        }

        public String getGoods() {
            return goods;
        }

        public void setGoods(String goods) {
            this.goods = goods;
        }

        public ActivityBean getActivity() {
            return activity;
        }

        public void setActivity(ActivityBean activity) {
            this.activity = activity;
        }

        public FaceBean getFace() {
            return face;
        }

        public void setFace(FaceBean face) {
            this.face = face;
        }

        public AlbumBean getAlbum() {
            return album;
        }

        public void setAlbum(AlbumBean album) {
            this.album = album;
        }

        public CloudBean getCloud() {
            return cloud;
        }

        public void setCloud(CloudBean cloud) {
            this.cloud = cloud;
        }

        public static class PaymentBean {
            /**
             * iap : http://api.lovebizhi.com/user.php?a=purchase&client_id=1001&version_code=87&language=zh-CN&channel_id=1
             * apple : http://api.lovebizhi.com/user.php?a=apple&client_id=1001&version_code=87&language=zh-CN&channel_id=1
             */

            private String iap;
            private String apple;

            public String getIap() {
                return iap;
            }

            public void setIap(String iap) {
                this.iap = iap;
            }

            public String getApple() {
                return apple;
            }

            public void setApple(String apple) {
                this.apple = apple;
            }
        }

        public static class FollowBean {
            /**
             * fans : http://api.lovebizhi.com/android_v3.php?a=follow&type=fans&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
             * user : {"list":"http://api.lovebizhi.com/android_v3.php?a=follow&type=user&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","create":"http://api.lovebizhi.com/user.php?a=followUser&client_id=1001&version_code=87&language=zh-CN&channel_id=1","remove":"http://api.lovebizhi.com/user.php?a=followUser&op=remove&client_id=1001&version_code=87&language=zh-CN&channel_id=1"}
             * tag : {"list":"http://api.lovebizhi.com/android_v3.php?a=follow&type=tag&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","create":"http://api.lovebizhi.com/user.php?a=followTag&client_id=1001&version_code=87&language=zh-CN&channel_id=1","remove":"http://api.lovebizhi.com/user.php?a=followTag&op=remove&client_id=1001&version_code=87&language=zh-CN&channel_id=1"}
             */

            private String fans;
            private UserBean user;
            private TagBeanX tag;

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public TagBeanX getTag() {
                return tag;
            }

            public void setTag(TagBeanX tag) {
                this.tag = tag;
            }

            public static class UserBean {
                /**
                 * list : http://api.lovebizhi.com/android_v3.php?a=follow&type=user&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
                 * create : http://api.lovebizhi.com/user.php?a=followUser&client_id=1001&version_code=87&language=zh-CN&channel_id=1
                 * remove : http://api.lovebizhi.com/user.php?a=followUser&op=remove&client_id=1001&version_code=87&language=zh-CN&channel_id=1
                 */

                private String list;
                private String create;
                private String remove;

                public String getList() {
                    return list;
                }

                public void setList(String list) {
                    this.list = list;
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

            public static class TagBeanX {
                /**
                 * list : http://api.lovebizhi.com/android_v3.php?a=follow&type=tag&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
                 * create : http://api.lovebizhi.com/user.php?a=followTag&client_id=1001&version_code=87&language=zh-CN&channel_id=1
                 * remove : http://api.lovebizhi.com/user.php?a=followTag&op=remove&client_id=1001&version_code=87&language=zh-CN&channel_id=1
                 */

                private String list;
                private String create;
                private String remove;

                public String getList() {
                    return list;
                }

                public void setList(String list) {
                    this.list = list;
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

        public static class ActivityBean {
            /**
             * donate_vip : http://api.lovebizhi.com/android_v3.php?a=donateVip&client_id=1001&version_code=87&language=zh-CN&channel_id=1
             */

            private String donate_vip;

            public String getDonate_vip() {
                return donate_vip;
            }

            public void setDonate_vip(String donate_vip) {
                this.donate_vip = donate_vip;
            }
        }

        public static class FaceBean {
            /**
             * upload : http://api.lovebizhi.com/user.php?a=face&client_id=1001&version_code=87&language=zh-CN&channel_id=1
             */

            private String upload;

            public String getUpload() {
                return upload;
            }

            public void setUpload(String upload) {
                this.upload = upload;
            }
        }

        public static class AlbumBean {
            /**
             * list : http://api.lovebizhi.com/android_v3.php?a=user&browse=album_list&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
             * create : http://api.lovebizhi.com/user.php?a=album&op=create&client_id=1001&version_code=87&language=zh-CN&channel_id=1
             * remove : http://api.lovebizhi.com/user.php?a=album&op=remove&client_id=1001&version_code=87&language=zh-CN&channel_id=1
             * upload : {"image":"http://api.lovebizhi.com/user.php?a=upload&op=image&client_id=1001&version_code=87&language=zh-CN&channel_id=1","verify":"http://api.lovebizhi.com/user.php?a=upload&op=verify&client_id=1001&version_code=87&language=zh-CN&channel_id=1","remove":"http://api.lovebizhi.com/user.php?a=album&op=remove_image"}
             * allow_list : [{"width":1080,"height":1920},{"width":2160,"height":1920}]
             */

            private String list;
            private String create;
            private String remove;
            private UploadBean upload;
            private List<AllowListBean> allow_list;

            public String getList() {
                return list;
            }

            public void setList(String list) {
                this.list = list;
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

            public UploadBean getUpload() {
                return upload;
            }

            public void setUpload(UploadBean upload) {
                this.upload = upload;
            }

            public List<AllowListBean> getAllow_list() {
                return allow_list;
            }

            public void setAllow_list(List<AllowListBean> allow_list) {
                this.allow_list = allow_list;
            }

            public static class UploadBean {
                /**
                 * image : http://api.lovebizhi.com/user.php?a=upload&op=image&client_id=1001&version_code=87&language=zh-CN&channel_id=1
                 * verify : http://api.lovebizhi.com/user.php?a=upload&op=verify&client_id=1001&version_code=87&language=zh-CN&channel_id=1
                 * remove : http://api.lovebizhi.com/user.php?a=album&op=remove_image
                 */

                private String image;
                private String verify;
                private String remove;

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }

                public String getVerify() {
                    return verify;
                }

                public void setVerify(String verify) {
                    this.verify = verify;
                }

                public String getRemove() {
                    return remove;
                }

                public void setRemove(String remove) {
                    this.remove = remove;
                }
            }

            public static class AllowListBean {
                /**
                 * width : 1080
                 * height : 1920
                 */

                private int width;
                private int height;

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }
            }
        }

        public static class CloudBean {
            /**
             * album : {"list":"http://api.lovebizhi.com/android_v3.php?a=user&browse=cloud_list&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0","create":"http://api.lovebizhi.com/cloud.php?a=album&op=create&client_id=1001&version_code=87&language=zh-CN&channel_id=1","remove":"http://api.lovebizhi.com/cloud.php?a=album&op=remove&client_id=1001&version_code=87&language=zh-CN&channel_id=1","upload":{"image":"http://api.lovebizhi.com/cloud.php?a=upload&op=image&client_id=1001&version_code=87&language=zh-CN&channel_id=1","verify":"http://api.lovebizhi.com/cloud.php?a=upload&op=verify&client_id=1001&version_code=87&language=zh-CN&channel_id=1","remove":"http://api.lovebizhi.com/cloud.php?a=image"},"allow_list":[{"width":1080,"height":1920},{"width":2160,"height":1920}]}
             */

            private AlbumBeanX album;

            public AlbumBeanX getAlbum() {
                return album;
            }

            public void setAlbum(AlbumBeanX album) {
                this.album = album;
            }

            public static class AlbumBeanX {
                /**
                 * list : http://api.lovebizhi.com/android_v3.php?a=user&browse=cloud_list&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
                 * create : http://api.lovebizhi.com/cloud.php?a=album&op=create&client_id=1001&version_code=87&language=zh-CN&channel_id=1
                 * remove : http://api.lovebizhi.com/cloud.php?a=album&op=remove&client_id=1001&version_code=87&language=zh-CN&channel_id=1
                 * upload : {"image":"http://api.lovebizhi.com/cloud.php?a=upload&op=image&client_id=1001&version_code=87&language=zh-CN&channel_id=1","verify":"http://api.lovebizhi.com/cloud.php?a=upload&op=verify&client_id=1001&version_code=87&language=zh-CN&channel_id=1","remove":"http://api.lovebizhi.com/cloud.php?a=image"}
                 * allow_list : [{"width":1080,"height":1920},{"width":2160,"height":1920}]
                 */

                private String list;
                private String create;
                private String remove;
                private UploadBeanX upload;
                private List<AllowListBeanX> allow_list;

                public String getList() {
                    return list;
                }

                public void setList(String list) {
                    this.list = list;
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

                public UploadBeanX getUpload() {
                    return upload;
                }

                public void setUpload(UploadBeanX upload) {
                    this.upload = upload;
                }

                public List<AllowListBeanX> getAllow_list() {
                    return allow_list;
                }

                public void setAllow_list(List<AllowListBeanX> allow_list) {
                    this.allow_list = allow_list;
                }

                public static class UploadBeanX {
                    /**
                     * image : http://api.lovebizhi.com/cloud.php?a=upload&op=image&client_id=1001&version_code=87&language=zh-CN&channel_id=1
                     * verify : http://api.lovebizhi.com/cloud.php?a=upload&op=verify&client_id=1001&version_code=87&language=zh-CN&channel_id=1
                     * remove : http://api.lovebizhi.com/cloud.php?a=image
                     */

                    private String image;
                    private String verify;
                    private String remove;

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public String getVerify() {
                        return verify;
                    }

                    public void setVerify(String verify) {
                        this.verify = verify;
                    }

                    public String getRemove() {
                        return remove;
                    }

                    public void setRemove(String remove) {
                        this.remove = remove;
                    }
                }

                public static class AllowListBeanX {
                    /**
                     * width : 1080
                     * height : 1920
                     */

                    private int width;
                    private int height;

                    public int getWidth() {
                        return width;
                    }

                    public void setWidth(int width) {
                        this.width = width;
                    }

                    public int getHeight() {
                        return height;
                    }

                    public void setHeight(int height) {
                        this.height = height;
                    }
                }
            }
        }
    }

    public static class MoreBean {
        /**
         * showinfo : http://api.lovebizhi.com/android_v3.php?a=showinfo&key={key}&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * loadimage : http://api.lovebizhi.com/android_v3.php?a=loadimage&device_id=73829564&client_id=1001&channel_id=1&version_code=87&uuid=d6aebf36c7b94cf6895b65c994a70217&model_id=100&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920
         * advert_welcome : http://api.lovebizhi.com/android_v3.php?a=advertWelcome&device_id=73829564&client_id=1001&channel_id=1&version_code=87&uuid=d6aebf36c7b94cf6895b65c994a70217&model_id=100&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&user_id=0&mac=
         * feedback : http://clientapi.lovebizhi.com/feedback.php?user_id=0
         * feedback_close : http://clientapi.lovebizhi.com/feedback.php?a=status
         * imagehelp : http://clientapi.lovebizhi.com/imagehelp.php?a=post&client_id=1001&device_id=73829564
         * exception : http://clientapi.lovebizhi.com/feedback.php?a=error&client_id=1001
         * version : http://api.lovebizhi.com/android_v3.php?a=version&device_id=73829564&client_id=1001&channel_id=1&version_code=87&uuid=d6aebf36c7b94cf6895b65c994a70217
         * recommend : http://api.lovebizhi.com/android_v3.php?a=recommend&device_id=73829564&client_id=1001&channel_id=1&version_code=87&uuid=d6aebf36c7b94cf6895b65c994a70217
         * exchange_apps : http://api.lovebizhi.com/android_v3.php?a=apps&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * auto_wallpaper : http://api.lovebizhi.com/android_v3.php?a=autoWallpaper&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * number_download : http://api.lovebizhi.com/android_v3.php?a=number&id={id}&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * message : http://api.lovebizhi.com/android_v3.php?a=message&device_id=73829564&client_id=1001&channel_id=1&version_code=87&uuid=d6aebf36c7b94cf6895b65c994a70217
         * image_text : http://api.lovebizhi.com/android_v3.php?a=imageTextHistory&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * phone_studio : http://api.lovebizhi.com/android_v3.php?a=phoneStudio&device_id=73829564&client_id=1001&channel_id=1&version_code=87&uuid=d6aebf36c7b94cf6895b65c994a70217
         * diy_info : http://api.lovebizhi.com/android_v3.php?a=diyInfo&device_id=73829564&client_id=1001&channel_id=1&version_code=87&uuid=d6aebf36c7b94cf6895b65c994a70217
         * report : http://api.lovebizhi.com/android_v3.php?a=report&device_id=73829564&client_id=1001&channel_id=1&version_code=87&uuid=d6aebf36c7b94cf6895b65c994a70217
         * notification : http://api.lovebizhi.com/android_v3.php?a=notification&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         */

        private String showinfo;
        private String loadimage;
        private String advert_welcome;
        private String feedback;
        private String feedback_close;
        private String imagehelp;
        private String exception;
        private String version;
        private String recommend;
        private String exchange_apps;
        private String auto_wallpaper;
        private String number_download;
        private String message;
        private String image_text;
        private String phone_studio;
        private String diy_info;
        private String report;
        private String notification;

        public String getShowinfo() {
            return showinfo;
        }

        public void setShowinfo(String showinfo) {
            this.showinfo = showinfo;
        }

        public String getLoadimage() {
            return loadimage;
        }

        public void setLoadimage(String loadimage) {
            this.loadimage = loadimage;
        }

        public String getAdvert_welcome() {
            return advert_welcome;
        }

        public void setAdvert_welcome(String advert_welcome) {
            this.advert_welcome = advert_welcome;
        }

        public String getFeedback() {
            return feedback;
        }

        public void setFeedback(String feedback) {
            this.feedback = feedback;
        }

        public String getFeedback_close() {
            return feedback_close;
        }

        public void setFeedback_close(String feedback_close) {
            this.feedback_close = feedback_close;
        }

        public String getImagehelp() {
            return imagehelp;
        }

        public void setImagehelp(String imagehelp) {
            this.imagehelp = imagehelp;
        }

        public String getException() {
            return exception;
        }

        public void setException(String exception) {
            this.exception = exception;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getRecommend() {
            return recommend;
        }

        public void setRecommend(String recommend) {
            this.recommend = recommend;
        }

        public String getExchange_apps() {
            return exchange_apps;
        }

        public void setExchange_apps(String exchange_apps) {
            this.exchange_apps = exchange_apps;
        }

        public String getAuto_wallpaper() {
            return auto_wallpaper;
        }

        public void setAuto_wallpaper(String auto_wallpaper) {
            this.auto_wallpaper = auto_wallpaper;
        }

        public String getNumber_download() {
            return number_download;
        }

        public void setNumber_download(String number_download) {
            this.number_download = number_download;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getImage_text() {
            return image_text;
        }

        public void setImage_text(String image_text) {
            this.image_text = image_text;
        }

        public String getPhone_studio() {
            return phone_studio;
        }

        public void setPhone_studio(String phone_studio) {
            this.phone_studio = phone_studio;
        }

        public String getDiy_info() {
            return diy_info;
        }

        public void setDiy_info(String diy_info) {
            this.diy_info = diy_info;
        }

        public String getReport() {
            return report;
        }

        public void setReport(String report) {
            this.report = report;
        }

        public String getNotification() {
            return notification;
        }

        public void setNotification(String notification) {
            this.notification = notification;
        }
    }

    public static class FeedbackBean {
        /**
         * new_reply : false
         * api : http://api.lovebizhi.com/android_v3.php?a=feedback&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * count : 0
         */

        private boolean new_reply;
        private String api;
        private int count;

        public boolean isNew_reply() {
            return new_reply;
        }

        public void setNew_reply(boolean new_reply) {
            this.new_reply = new_reply;
        }

        public String getApi() {
            return api;
        }

        public void setApi(String api) {
            this.api = api;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    public static class ImagehelpBean {
        /**
         * api : http://api.lovebizhi.com/android_v3.php?a=imagehelp&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         */

        private String api;

        public String getApi() {
            return api;
        }

        public void setApi(String api) {
            this.api = api;
        }
    }

    public static class LockScreenBean {
        /**
         * download : http://s.qdcdn.com/lovebizhi/LockScreen.apk
         * version_code : 2
         * version : http://api.lovebizhi.com/lock_screen.php?a=version&version_code={code}
         * analyze : http://clientapi.lovebizhi.com/analyze.php
         */

        private String download;
        private int version_code;
        private String version;
        private String analyze;

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public int getVersion_code() {
            return version_code;
        }

        public void setVersion_code(int version_code) {
            this.version_code = version_code;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getAnalyze() {
            return analyze;
        }

        public void setAnalyze(String analyze) {
            this.analyze = analyze;
        }
    }

    public static class MultiScreenBean {
        /**
         * download : http://s.qdcdn.com/lovebizhi/MultiScreen.apk
         * version_code : 1
         * version : http://api.lovebizhi.com/multi_screen.php?a=version&version_code={code}
         * analyze : http://clientapi.lovebizhi.com/analyze.php
         */

        private String download;
        private int version_code;
        private String version;
        private String analyze;

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public int getVersion_code() {
            return version_code;
        }

        public void setVersion_code(int version_code) {
            this.version_code = version_code;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getAnalyze() {
            return analyze;
        }

        public void setAnalyze(String analyze) {
            this.analyze = analyze;
        }
    }

    public static class RingBean {
        /**
         * name : 彩铃
         * is_open : true
         * site : http://lovebizhiapp.kuyinxiu.com/LovebizhiPhoneApp
         */

        private String name;
        private boolean is_open;
        private String site;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isIs_open() {
            return is_open;
        }

        public void setIs_open(boolean is_open) {
            this.is_open = is_open;
        }

        public String getSite() {
            return site;
        }

        public void setSite(String site) {
            this.site = site;
        }
    }

    public static class BrowseBean {
        /**
         * id : special
         * name : 热门专题
         * image : http://s.qdcdn.com/cc/14540556.webp
         * api : http://api.lovebizhi.com/android_v3.php?a=browse&id=special&spdy=1&device=Meizu%28MX5%29&uuid=d6aebf36c7b94cf6895b65c994a70217&mode=2&client_id=1001&device_id=73829564&model_id=100&size_id=0&channel_id=1&screen_width=1080&screen_height=1920&bizhi_width=1080&bizhi_height=1920&version_code=87&language=zh-CN&mac=&original=0
         * description : 专题大展览
         */

        private String id;
        private String name;
        private String image;
        private String api;
        private String description;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getApi() {
            return api;
        }

        public void setApi(String api) {
            this.api = api;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
