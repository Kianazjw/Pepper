package com.komorebi.pepper.bean;


//学分查询
public class CreditBean {

    /**
     * code : 1
     * msg : success
     * data : {"bj":"软件工程2015-6","xm":"钟际旺","xh":"2015211001000615","xjzt":"正常|有学籍","pjxfjd":"2.84","zxfyq":{"total":"187","done":"88","undone":"99"},"ggrxkxf":{"total":"8","done":"8","undone":"0"},"xkrxkxf":{"total":"8","done":"6","undone":"2"},"zyrxkxf":{"total":"8","done":"0","undone":"8"}}
     */

    public int code;
    public String msg;
    public DataBean data;

    public static class DataBean {
        /**
         * bj : 软件工程2015-6
         * xm : 钟际旺
         * xh : 2015211001000615
         * xjzt : 正常|有学籍
         * pjxfjd : 2.84   平均学分点
         * zxfyq : {"total":"187","done":"88","undone":"99"}  总学分要求
         * ggrxkxf : {"total":"8","done":"8","undone":"0"}    公共任选课要求
         * xkrxkxf : {"total":"8","done":"6","undone":"2"}     学科任选课要求
         * zyrxkxf : {"total":"8","done":"0","undone":"8"}     专业任选课学分
         */            //总计       已完成

        public String bj;
        public String xm;
        public String xh;
        public String xjzt;
        public String pjxfjd;
        public ZxfyqBean zxfyq;
        public GgrxkxfBean ggrxkxf;
        public XkrxkxfBean xkrxkxf;
        public ZyrxkxfBean zyrxkxf;


    }

    public static class ZxfyqBean {
        /**
         * total : 187
         * done : 88
         * undone : 99
         */

        public String total;
        public String done;
        public String undone;

    }

    public static class GgrxkxfBean {
        /**
         * total : 8
         * done : 8
         * undone : 0
         */

        public String total;
        public String done;
        public String undone;

    }

    public static class XkrxkxfBean {
        /**
         * total : 8
         * done : 6
         * undone : 2
         */

        public String total;
        public String done;
        public String undone;

    }

    public static class ZyrxkxfBean {
        /**
         * total : 8
         * done : 0
         * undone : 8
         */

        public String total;
        public String done;
        public String undone;

    }
}
