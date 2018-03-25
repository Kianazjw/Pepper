package com.komorebi.pepper.bean;

import java.util.List;

public class CourseBean {


    /**
     * code : 1
     * msg : success
     * data : {"term":"2016.2","week":"1","schedule":{"Mon":[{"kcmc":"汇编语言与计算机组成原理","js":"王辉","skdd":"@31-424","jxbmc":"汇编语言与计算机组成原理(20162-3)","lx":"上课","sksj":"1-2"},{"kcmc":"体育Ⅳ","js":"梁日尉","skdd":"@","jxbmc":"排球Ⅳ(20162-1)","lx":"上课","sksj":"3-4"},{"kcmc":"毛泽东思想和中国特色社会主义理论体系概论(一)","js":"刘佳","skdd":"@31-305","jxbmc":"毛泽东思想和中国特色社会主义理论体系概论(一)(20162-29)","lx":"上课","sksj":"5-6"}],"Tues":[{"kcmc":"软件测试技术","js":"吕敬钦","skdd":"@31-310","jxbmc":"软件测试技术(20162-1)","lx":"上课","sksj":"3-4"}],"Wed":[{"kcmc":"计算机网络（A）","js":"周会祥","skdd":"@31-306","jxbmc":"计算机网络（A）(20162-3)","lx":"上课","sksj":"1-2"},{"kcmc":"汇编语言与计算机组成原理","js":"王辉","skdd":"@31-424","jxbmc":"汇编语言与计算机组成原理(20162-3)","lx":"上课","sksj":"3-4"},{"kcmc":"毛泽东思想和中国特色社会主义理论体系概论(一)","js":"刘佳","skdd":"@31-305","jxbmc":"毛泽东思想和中国特色社会主义理论体系概论(一)(20162-29)","lx":"上课","sksj":"5-6"}],"Fri":[{"kcmc":"计算机网络（A）","js":"周会祥","skdd":"@31-305","jxbmc":"计算机网络（A）(20162-3)","lx":"上课","sksj":"5-6"}]}}
     */

    public int code;
    public String msg;
    public DataBean data;


    public static class DataBean {

        public String week;
        public ScheduleBean schedule;


        public static class ScheduleBean {
            public List<MonBean> Mon;
            public List<TuesBean> Tues;
            public List<WedBean> Wed;
            public List<ThurBean> Thur;
            public List<SunBean> Sun;
            public List<SatBean> Sat;
            public List<FriBean> Fri;

//            public List<MonBean> getMon() {
//                return Mon;
//            }


            public static class MonBean {
                public String kcmc;
                public String js;
                public String skdd;
                public String jxbmc;
                public String lx;
                public String sksj;
            }

            public static class TuesBean {
                public String kcmc;
                public String js;
                public String skdd;
                public String jxbmc;
                public String lx;
                public String sksj;
            }

            public static class WedBean {
                public String kcmc;
                public String js;
                public String skdd;
                public String jxbmc;
                public String lx;
                public String sksj;
            }

            public static class ThurBean {
                public String kcmc;
                public String js;
                public String skdd;
                public String jxbmc;
                public String lx;
                public String sksj;
            }

            public static class FriBean {
                public String kcmc;
                public String js;
                public String skdd;
                public String jxbmc;
                public String lx;
                public String sksj;
            }

            public static class SatBean {
                public String kcmc;
                public String js;
                public String skdd;
                public String jxbmc;
                public String lx;
                public String sksj;
            }

            public static class SunBean {
                public String kcmc;
                public String js;
                public String skdd;
                public String jxbmc;
                public String lx;
                public String sksj;
            }
        }
    }
}