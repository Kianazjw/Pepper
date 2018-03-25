package com.komorebi.pepper.bean;

import java.util.List;

public class TodayCourseBean {


    /**
     * code : 1
     * msg : success
     * data : {"date":"2017-04-24","weekday":"1","week":10,"daylist":[{"className":"汇编语言与计算机组成原理(20162-3)","classRoom":"31-424","classSpan":"1,2","classString":"1-2","course":"汇编语言与计算机组成原理","courseRequire":"必修课","pkType":"上课","teacherName":"王辉","weekDay":1,"weekSpan":"1-16"},{"className":"排球Ⅳ(20162-1)","classRoom":"","classSpan":"3,4","classString":"3-4","course":"体育Ⅳ","courseRequire":"必修课","pkType":"上课","teacherName":"梁日尉","weekDay":1,"weekSpan":"1-16"},{"className":"毛泽东思想和中国特色社会主义理论体系概论(一)(20162-29)","classRoom":"31-305","classSpan":"5,6","classString":"5-6","course":"毛泽东思想和中国特色社会主义理论体系概论(一)","courseRequire":"必修课","pkType":"上课","teacherName":"刘佳","weekDay":1,"weekSpan":"1-14"}]}
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
         * date : 2017-04-24
         * weekday : 1
         * week : 10
         * daylist : [{"className":"汇编语言与计算机组成原理(20162-3)","classRoom":"31-424","classSpan":"1,2","classString":"1-2","course":"汇编语言与计算机组成原理","courseRequire":"必修课","pkType":"上课","teacherName":"王辉","weekDay":1,"weekSpan":"1-16"},{"className":"排球Ⅳ(20162-1)","classRoom":"","classSpan":"3,4","classString":"3-4","course":"体育Ⅳ","courseRequire":"必修课","pkType":"上课","teacherName":"梁日尉","weekDay":1,"weekSpan":"1-16"},{"className":"毛泽东思想和中国特色社会主义理论体系概论(一)(20162-29)","classRoom":"31-305","classSpan":"5,6","classString":"5-6","course":"毛泽东思想和中国特色社会主义理论体系概论(一)","courseRequire":"必修课","pkType":"上课","teacherName":"刘佳","weekDay":1,"weekSpan":"1-14"}]
         */

        private String date;
        private String weekday;
        private int week;
        private List<DaylistBean> daylist;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getWeekday() {
            return weekday;
        }

        public void setWeekday(String weekday) {
            this.weekday = weekday;
        }

        public int getWeek() {
            return week;
        }

        public void setWeek(int week) {
            this.week = week;
        }

        public List<DaylistBean> getDaylist() {
            return daylist;
        }

        public void setDaylist(List<DaylistBean> daylist) {
            this.daylist = daylist;
        }

        public static class DaylistBean {
            /**
             * className : 汇编语言与计算机组成原理(20162-3)
             * classRoom : 31-424
             * classSpan : 1,2
             * classString : 1-2
             * course : 汇编语言与计算机组成原理
             * courseRequire : 必修课
             * pkType : 上课
             * teacherName : 王辉
             * weekDay : 1
             * weekSpan : 1-16
             */

            private String className;
            private String classRoom;
            private String classSpan;
            private String classString;
            private String course;
            private String courseRequire;
            private String pkType;
            private String teacherName;
            private int weekDay;
            private String weekSpan;

            public String getClassName() {
                return className;
            }

            public void setClassName(String className) {
                this.className = className;
            }

            public String getClassRoom() {
                return classRoom;
            }

            public void setClassRoom(String classRoom) {
                this.classRoom = classRoom;
            }

            public String getClassSpan() {
                return classSpan;
            }

            public void setClassSpan(String classSpan) {
                this.classSpan = classSpan;
            }

            public String getClassString() {
                return classString;
            }

            public void setClassString(String classString) {
                this.classString = classString;
            }

            public String getCourse() {
                return course;
            }

            public void setCourse(String course) {
                this.course = course;
            }

            public String getCourseRequire() {
                return courseRequire;
            }

            public void setCourseRequire(String courseRequire) {
                this.courseRequire = courseRequire;
            }

            public String getPkType() {
                return pkType;
            }

            public void setPkType(String pkType) {
                this.pkType = pkType;
            }

            public String getTeacherName() {
                return teacherName;
            }

            public void setTeacherName(String teacherName) {
                this.teacherName = teacherName;
            }

            public int getWeekDay() {
                return weekDay;
            }

            public void setWeekDay(int weekDay) {
                this.weekDay = weekDay;
            }

            public String getWeekSpan() {
                return weekSpan;
            }

            public void setWeekSpan(String weekSpan) {
                this.weekSpan = weekSpan;
            }
        }
    }
}
