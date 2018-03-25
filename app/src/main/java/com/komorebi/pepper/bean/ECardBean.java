package com.komorebi.pepper.bean;

import java.util.List;

public class ECardBean {

    /**
     * code : 1
     * msg : success
     * data : [{"name":"钟际旺","type":"持卡人消费","address":"南区二食堂二楼商户","consume":"-9.00","balance":"52.06","time":"2017/04/12 15:58:54","swipetimes":"2585","status":"正常","comment":""},{"name":"钟际旺","type":"持卡人消费","address":"南区二食堂二楼商户","consume":"-3.00","balance":"61.06","time":"2017/04/12 15:57:36","swipetimes":"2584","status":"正常","comment":""},{"name":"钟际旺","type":"持卡人消费","address":"北区新食堂一楼","consume":"-8.50","balance":"64.06","time":"2017/04/12 12:00:35","swipetimes":"2583","status":"正常","comment":""},{"name":"钟际旺","type":"持卡人消费","address":"北区新食堂一楼","consume":"-2.00","balance":"72.56","time":"2017/04/12 07:49:13","swipetimes":"2582","status":"正常","comment":""},{"name":"钟际旺","type":"持卡人消费","address":"北区新食堂一楼","consume":"-2.00","balance":"74.56","time":"2017/04/12 07:48:58","swipetimes":"2581","status":"正常","comment":""}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 钟际旺
         * type : 持卡人消费
         * address : 南区二食堂二楼商户
         * consume : -9.00
         * balance : 52.06
         * time : 2017/04/12 15:58:54
         * swipetimes : 2585
         * status : 正常
         * comment :
         */

        private String name;
        private String type;
        private String address;
        private float consume;
        private String balance;
        private String time;
        private String swipetimes;
        private String status;
        private String comment;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public float getConsume() {
            return consume;
        }

        public void setConsume(float consume) {
            this.consume = consume;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getSwipetimes() {
            return swipetimes;
        }

        public void setSwipetimes(String swipetimes) {
            this.swipetimes = swipetimes;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }
}
