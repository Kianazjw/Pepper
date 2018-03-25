package com.komorebi.pepper.bean;

import java.util.List;

public class ExamArrangeBean {

    /**
     * code : 1
     * msg : success
     * data : {"term":"2016.1","exam":[{"kcmc":"大学英语Ⅲ","kcxz":"必修课","bjmc":"VB级(2015-6)【小1班】","xsrs":"34","kszc":"20","kssj":"2017年01月10日(星期二)08:00-10:00","ksdd":"31-307","xbbh":"27"},{"kcmc":"软件工程（A）","kcxz":"必修课","bjmc":"软件工程（A）(20161-3)【小3班】","xsrs":"32","kszc":"18","kssj":"2016年12月30日(星期五)14:00-16:00","ksdd":"31-206","xbbh":"28"},{"kcmc":"概率论与数理统计","kcxz":"必修课","bjmc":"概率论与数理统计(20161-4)【小3班】","xsrs":"32","kszc":"17","kssj":"2016年12月21日(星期三)14:00-16:00","ksdd":"14-104","xbbh":"2"},{"kcmc":"数据库系统原理 （A）","kcxz":"必修课","bjmc":"数据库系统原理 （A）(20161-2)【小2班】","xsrs":"25","kszc":"17","kssj":"2016年12月20日(星期二)10:15-12:15","ksdd":"31-215","xbbh":"17"}]}
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
        /**
         * term : 2016.1
         * exam : [{"kcmc":"大学英语Ⅲ","kcxz":"必修课","bjmc":"VB级(2015-6)【小1班】","xsrs":"34","kszc":"20","kssj":"2017年01月10日(星期二)08:00-10:00","ksdd":"31-307","xbbh":"27"},{"kcmc":"软件工程（A）","kcxz":"必修课","bjmc":"软件工程（A）(20161-3)【小3班】","xsrs":"32","kszc":"18","kssj":"2016年12月30日(星期五)14:00-16:00","ksdd":"31-206","xbbh":"28"},{"kcmc":"概率论与数理统计","kcxz":"必修课","bjmc":"概率论与数理统计(20161-4)【小3班】","xsrs":"32","kszc":"17","kssj":"2016年12月21日(星期三)14:00-16:00","ksdd":"14-104","xbbh":"2"},{"kcmc":"数据库系统原理 （A）","kcxz":"必修课","bjmc":"数据库系统原理 （A）(20161-2)【小2班】","xsrs":"25","kszc":"17","kssj":"2016年12月20日(星期二)10:15-12:15","ksdd":"31-215","xbbh":"17"}]
         */

        private String term;
        private List<ExamBean> exam;

        public String getTerm() {
            return term;
        }

        public void setTerm(String term) {
            this.term = term;
        }

        public List<ExamBean> getExam() {
            return exam;
        }

        public void setExam(List<ExamBean> exam) {
            this.exam = exam;
        }

        public static class ExamBean {
            /**
             * kcmc : 大学英语Ⅲ
             * kcxz : 必修课
             * bjmc : VB级(2015-6)【小1班】
             * xsrs : 34
             * kszc : 20
             * kssj : 2017年01月10日(星期二)08:00-10:00
             * ksdd : 31-307
             * xbbh : 27
             */

            private String kcmc;
            private String kcxz;
            private String bjmc;
            private String xsrs;
            private String kszc;
            private String kssj;
            private String ksdd;
            private String xbbh;

            public String getKcmc() {
                return kcmc;
            }

            public void setKcmc(String kcmc) {
                this.kcmc = kcmc;
            }

            public String getKcxz() {
                return kcxz;
            }

            public void setKcxz(String kcxz) {
                this.kcxz = kcxz;
            }

            public String getBjmc() {
                return bjmc;
            }

            public void setBjmc(String bjmc) {
                this.bjmc = bjmc;
            }

            public String getXsrs() {
                return xsrs;
            }

            public void setXsrs(String xsrs) {
                this.xsrs = xsrs;
            }

            public String getKszc() {
                return kszc;
            }

            public void setKszc(String kszc) {
                this.kszc = kszc;
            }

            public String getKssj() {
                return kssj;
            }

            public void setKssj(String kssj) {
                this.kssj = kssj;
            }

            public String getKsdd() {
                return ksdd;
            }

            public void setKsdd(String ksdd) {
                this.ksdd = ksdd;
            }

            public String getXbbh() {
                return xbbh;
            }

            public void setXbbh(String xbbh) {
                this.xbbh = xbbh;
            }
        }
    }
}
