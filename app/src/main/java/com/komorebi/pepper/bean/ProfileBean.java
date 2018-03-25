package com.komorebi.pepper.bean;

public class ProfileBean {

    /**
     * code : 1
     * msg : success
     * data : {"xh":"2015211001000615","zbbh":"2015211001000615","xm":"钟际旺","bj":"软件工程2015-6","xb":"男","mz":"汉族","csrq":"1997-11-14","zzmm":"共青团员","jg":"江西","pyfabh":"","yyfjjb":"B","xjzt":"正常|有学籍","cfzt":"正常","gkksh":"15360723150772","gkcj":"0.0"}
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
         * xh : 2015211001000615
         * zbbh : 2015211001000615
         * xm : 钟际旺
         * bj : 软件工程2015-6
         * xb : 男
         * mz : 汉族
         * csrq : 1997-11-14
         * zzmm : 共青团员
         * jg : 江西
         * pyfabh :
         * yyfjjb : B
         * xjzt : 正常|有学籍
         * cfzt : 正常
         * gkksh : 15360723150772
         * gkcj : 0.0
         */

        private String xh;
        private String zbbh;
        private String xm;
        private String bj;
        private String xb;
        private String mz;
        private String csrq;
        private String zzmm;
        private String jg;
        private String pyfabh;
        private String yyfjjb;
        private String xjzt;
        private String cfzt;
        private String gkksh;
        private String gkcj;

        public String getXh() {
            return xh;
        }

        public void setXh(String xh) {
            this.xh = xh;
        }

        public String getZbbh() {
            return zbbh;
        }

        public void setZbbh(String zbbh) {
            this.zbbh = zbbh;
        }

        public String getXm() {
            return xm;
        }

        public void setXm(String xm) {
            this.xm = xm;
        }

        public String getBj() {
            return bj;
        }

        public void setBj(String bj) {
            this.bj = bj;
        }

        public String getXb() {
            return xb;
        }

        public void setXb(String xb) {
            this.xb = xb;
        }

        public String getMz() {
            return mz;
        }

        public void setMz(String mz) {
            this.mz = mz;
        }

        public String getCsrq() {
            return csrq;
        }

        public void setCsrq(String csrq) {
            this.csrq = csrq;
        }

        public String getZzmm() {
            return zzmm;
        }

        public void setZzmm(String zzmm) {
            this.zzmm = zzmm;
        }

        public String getJg() {
            return jg;
        }

        public void setJg(String jg) {
            this.jg = jg;
        }

        public String getPyfabh() {
            return pyfabh;
        }

        public void setPyfabh(String pyfabh) {
            this.pyfabh = pyfabh;
        }

        public String getYyfjjb() {
            return yyfjjb;
        }

        public void setYyfjjb(String yyfjjb) {
            this.yyfjjb = yyfjjb;
        }

        public String getXjzt() {
            return xjzt;
        }

        public void setXjzt(String xjzt) {
            this.xjzt = xjzt;
        }

        public String getCfzt() {
            return cfzt;
        }

        public void setCfzt(String cfzt) {
            this.cfzt = cfzt;
        }

        public String getGkksh() {
            return gkksh;
        }

        public void setGkksh(String gkksh) {
            this.gkksh = gkksh;
        }

        public String getGkcj() {
            return gkcj;
        }

        public void setGkcj(String gkcj) {
            this.gkcj = gkcj;
        }
    }
}
