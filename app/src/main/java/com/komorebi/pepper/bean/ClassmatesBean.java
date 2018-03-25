package com.komorebi.pepper.bean;

import java.util.ArrayList;


public class ClassmatesBean {
    public int code;
    public String msg;
    public ArrayList<ChildClassmatesBean> data;

    public class ChildClassmatesBean {
        public String sn;
        public String xm;//name
        public String xb;//sex
        public String zbbh;//在班编号
        public String xh;//学号
        public String xjzt;//学籍状态
    }
}
