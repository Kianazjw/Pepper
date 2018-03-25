package com.komorebi.pepper.bean;

import java.util.List;

public class EcjtuNewsBean {

    /**
     * code : 1
     * msg : success
     * data : {"rxyl":[{"title":"当中式英语遇到西方教学","link":"http://ecjtu.net/html/news/rixinyanlun/20170418/35031.html"},{"title":"加强思想革命教育　深植红色家国情怀","link":"http://ecjtu.net/html/news/rixinyanlun/20170418/35030.html"},{"title":"《人民的名义》：行为官之义，以人民之","link":"http://ecjtu.net/html/news/rixinyanlun/20170413/35026.html"},{"title":"优质生活新态度 大学生版《向往的生活","link":"http://ecjtu.net/html/news/rixinyanlun/20170407/35022.html"},{"title":"电竞人生不虚拟 方寸之间有佳境","link":"http://ecjtu.net/html/news/rixinyanlun/20170405/35020.html"}],"rxft":[{"title":"走近学霸寝:协心努力齐奋进  共同进步","link":"http://ecjtu.net/html/news/rixinfangtan/20170419/35032.html"},{"title":"邹璐建：成就蜗牛的坚持 让世界为你转","link":"http://ecjtu.net/html/news/rixinfangtan/20170308/35003.html"},{"title":"唐跃峰：跃马扬鞭追梦者 勇攀高峰交大","link":"http://ecjtu.net/html/news/rixinfangtan/20161227/34976.html"},{"title":"华东交大武术队：为武而生拥习武之魂 ","link":"http://ecjtu.net/html/news/rixinfangtan/20161214/34965.html"},{"title":"薛姣：你若盛开 清风自来","link":"http://ecjtu.net/html/news/rixinfangtan/20161109/34923.html"}],"rxjj":[],"kmhjt":[{"title":"封长虹：细析国家环境 深剖军事未来","link":"http://ecjtu.net/html/news/kongmuhu/20170331/35019.html"},{"title":"舒曼：爱与远方 心理\u201c教练\u201d视野下的自助技巧","link":"http://ecjtu.net/html/news/kongmuhu/20170303/34996.html"},{"title":"杨雨:诗情歌意执手牵 梅魂傲骨应如是","link":"http://ecjtu.net/html/news/kongmuhu/20161115/34931.html"},{"title":"弄潮就业勤规划　科学观点成未来","link":"http://ecjtu.net/html/news/kongmuhu/20161102/34910.html"},{"title":"传播中国文化　打造文化盛世","link":"http://ecjtu.net/html/news/kongmuhu/20161018/34883.html"}],"zxtg":[{"title":"\u201c双基\u201d三维创新设计大赛安排新鲜出炉","link":"http://ecjtu.net/html/news/rixingonggao/20170425/35035.html"},{"title":"\u201c一七\u201d毕业在即 紧盯论文查重","link":"http://ecjtu.net/html/news/rixingonggao/20170419/35033.html"},{"title":"清明时节雨纷纷 假期遥指花椒村","link":"http://ecjtu.net/html/news/rixingonggao/20170322/35012.html"},{"title":"你关心的2017上半年大学英语四六级通知","link":"http://ecjtu.net/html/news/rixingonggao/20170308/35002.html"},{"title":"第十五届\u201c挑战杯\u201d决赛作品早知道","link":"http://ecjtu.net/html/news/rixingonggao/20170307/35000.html"}],"rdsd":[{"title":"江西省第十五届\u201c挑战杯\u201d竞赛要来啦！","link":"http://ecjtu.net/html/news/jinriyaowen/20170330/35018.html"},{"title":"获全省辅导员职业能力大赛冠军竟然是他","link":"http://ecjtu.net/html/news/jinriyaowen/20170330/35017.html"},{"title":"学校推进学生宿舍专项维护改造工作","link":"http://ecjtu.net/html/news/jinriyaowen/20170323/35013.html"},{"title":"汪立夏赴教育部、铁总汇报工作","link":"http://ecjtu.net/html/news/jinriyaowen/20170316/35009.html"},{"title":"提升学生质量 我校推进评估整改工作","link":"http://ecjtu.net/html/news/jinriyaowen/20170228/34990.html"}]}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<RxylBean> rxyl;
        private List<RxftBean> rxft;
        private List<?> rxjj;
        private List<KmhjtBean> kmhjt;
        private List<ZxtgBean> zxtg;
        private List<RdsdBean> rdsd;

        public List<RxylBean> getRxyl() {
            return rxyl;
        }

        public void setRxyl(List<RxylBean> rxyl) {
            this.rxyl = rxyl;
        }

        public List<RxftBean> getRxft() {
            return rxft;
        }

        public void setRxft(List<RxftBean> rxft) {
            this.rxft = rxft;
        }

        public List<?> getRxjj() {
            return rxjj;
        }

        public void setRxjj(List<?> rxjj) {
            this.rxjj = rxjj;
        }

        public List<KmhjtBean> getKmhjt() {
            return kmhjt;
        }

        public void setKmhjt(List<KmhjtBean> kmhjt) {
            this.kmhjt = kmhjt;
        }

        public List<ZxtgBean> getZxtg() {
            return zxtg;
        }

        public void setZxtg(List<ZxtgBean> zxtg) {
            this.zxtg = zxtg;
        }

        public List<RdsdBean> getRdsd() {
            return rdsd;
        }

        public void setRdsd(List<RdsdBean> rdsd) {
            this.rdsd = rdsd;
        }

        public static class RxylBean {
            /**
             * title : 当中式英语遇到西方教学
             * link : http://ecjtu.net/html/news/rixinyanlun/20170418/35031.html
             */

            private String title;
            private String link;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class RxftBean {
            /**
             * title : 走近学霸寝:协心努力齐奋进  共同进步
             * link : http://ecjtu.net/html/news/rixinfangtan/20170419/35032.html
             */

            private String title;
            private String link;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class KmhjtBean {
            /**
             * title : 封长虹：细析国家环境 深剖军事未来
             * link : http://ecjtu.net/html/news/kongmuhu/20170331/35019.html
             */

            private String title;
            private String link;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class ZxtgBean {
            /**
             * title : “双基”三维创新设计大赛安排新鲜出炉
             * link : http://ecjtu.net/html/news/rixingonggao/20170425/35035.html
             */

            private String title;
            private String link;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }

        public static class RdsdBean {
            /**
             * title : 江西省第十五届“挑战杯”竞赛要来啦！
             * link : http://ecjtu.net/html/news/jinriyaowen/20170330/35018.html
             */

            private String title;
            private String link;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }
    }
}
