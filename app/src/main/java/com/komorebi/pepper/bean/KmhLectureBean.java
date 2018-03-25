package com.komorebi.pepper.bean;

import java.util.List;

public class KmhLectureBean {


    /**
     * code : 1
     * msg : success
     * data : [{"title":"周三南极100天与18年、周四武则天的是非功过，两场讲座供你选择","link":"http://kmh.ecjtu.jx.cn/2017/0508/c671a39282/page.htm"},{"title":"央视《百家讲坛》主讲人丁万明向你解读《资治通鉴》与司马光的修身之道","link":"http://kmh.ecjtu.jx.cn/2017/0502/c671a39116/page.htm"},{"title":"联合国环境规划署特别协调员王之佳带你走进联合国","link":"http://kmh.ecjtu.jx.cn/2017/0421/c671a38841/page.htm"},{"title":"上海大学哲学系朱承教授谈交通礼仪中的权力与秩序","link":"http://kmh.ecjtu.jx.cn/2017/0407/c671a38521/page.htm"},{"title":"江西广播电视协会播音主持专业委员会副秘书长程杉带你进入声音的世界~","link":"http://kmh.ecjtu.jx.cn/2017/0401/c671a38334/page.htm"},{"title":"中国首家民营家装集团创办者余静赣先生分享创业经验","link":"http://kmh.ecjtu.jx.cn/2017/0331/c671a38300/page.htm"}]
     */

    public int code;
    public String msg;
    public List<DataBean> data;


    public static class DataBean {
        /**
         * title : 周三南极100天与18年、周四武则天的是非功过，两场讲座供你选择
         * link : http://kmh.ecjtu.jx.cn/2017/0508/c671a39282/page.htm
         */

        public String title;
        public String link;


    }
}
