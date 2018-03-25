package com.komorebi.pepper.bean;

import java.util.List;

public class ReExamBean {

    /**
     * code : 1
     * msg : success
     * data : {"term":"2016.2","bexam":[{"kcbh":"1509100013","kcmc":"大学英语Ⅲ","kcyq":"必修课","kszc":"3","kssj":"2017年03月12日(星期日)08:00-10:00","ksdd":"14-208"}]}
     */

    public int code;
    public String msg;
    public DataBean data;

    public static class DataBean {
        /**
         * term : 2016.2
         * bexam : [{"kcbh":"1509100013","kcmc":"大学英语Ⅲ","kcyq":"必修课","kszc":"3","kssj":"2017年03月12日(星期日)08:00-10:00","ksdd":"14-208"}]
         */
        public String term;
        public List<BexamBean> bexam;

        public static class BexamBean {
            /**
             * kcbh : 1509100013
             * kcmc : 大学英语Ⅲ
             * kcyq : 必修课
             * kszc : 3
             * kssj : 2017年03月12日(星期日)08:00-10:00
             * ksdd : 14-208
             */
            public String kcbh;
            public String kcmc;
            public String kcyq;
            public String kszc;
            public String kssj;
            public String ksdd;
        }
    }
}
