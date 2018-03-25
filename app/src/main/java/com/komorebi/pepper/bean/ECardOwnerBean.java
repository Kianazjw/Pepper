package com.komorebi.pepper.bean;

import java.io.Serializable;


public class ECardOwnerBean implements Serializable {
    public int code;
    public String msg;
    public ChildECardOwnerBean data;

    public class ChildECardOwnerBean implements Serializable {
        public String name;
        public String account;
        public String stuid;
        public String usertype;
        public String balance;//余额
        public String area;//消费地点
        public String unit;
    }
}
