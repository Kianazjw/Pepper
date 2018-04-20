package com.komorebi.pepper.api;

import com.komorebi.pepper.bean.ClassmatesBean;
import com.komorebi.pepper.bean.CourseBean;
import com.komorebi.pepper.bean.CreditBean;
import com.komorebi.pepper.bean.ECardBean;
import com.komorebi.pepper.bean.ECardOwnerBean;
import com.komorebi.pepper.bean.EcjtuNewsBean;
import com.komorebi.pepper.bean.ExamArrangeBean;
import com.komorebi.pepper.bean.KmhLectureBean;
import com.komorebi.pepper.bean.LoginTokenBean;
import com.komorebi.pepper.bean.MyExperimentBean;
import com.komorebi.pepper.bean.NewsContentBean;
import com.komorebi.pepper.bean.ProfileBean;
import com.komorebi.pepper.bean.ReExamBean;
import com.komorebi.pepper.bean.ScoreBean;
import com.komorebi.pepper.bean.SelectedCourseIDBean;
import com.komorebi.pepper.bean.TodayCourseBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Komorebi on 2018/3/22.
 */

public interface RetrofitService {
    @GET("login")
    Call<LoginTokenBean> getCheckLogin(@Query("studentid") String stuid,
                                       @Query("jwxt_password") String jwcPwd,
                                       @Query("ecard_password") String ecardPwd);

    @GET("personal_profile")
    Call<ProfileBean> getProfile(@Query("token") String token);

    @GET("personal_daily_schedule")
    Call<TodayCourseBean> getTodayCourseBean(@Query("token") String token);

    @GET("personal_score")
    Call<ScoreBean> getScoreBean(@Query("term") String term, @Query("token") String token);

    @GET("personal_exam")
    Call<ExamArrangeBean> getExamArrangeBean(@Query("token") String token);


    @GET("personal_ecard_trade")
    Call<ECardBean> getECard(@Query("token") String token);


    @GET("personal_week_schedule")
    Call<CourseBean> getCourse(@Query("week") String week, @Query("token") String token);


    @GET("personal_experiment")
    Call<MyExperimentBean> getExperiment(@Query("token") String token);

    @GET("personal_bexam")
    Call<ReExamBean> getReExam(@Query("token") String token);


    @GET("personal_mates")
    Call<ClassmatesBean> getClassmates(@Query("token") String token);

    //学分
    @GET("personal_credit")
    Call<CreditBean> getCredit(@Query("token") String token);

    //首页日新新闻
    @GET("ecjtu_net_news_list")
    Call<EcjtuNewsBean> getEcjtuNews();

    @GET("ecjtu_net_news_content")
    Call<NewsContentBean> getEcjtuContentNews(@Query("href") String href);


    //孔目湖
    @GET("ecjtu_kmh_lecture_list")
    Call<KmhLectureBean> getKmu();

    @GET("ecjtu_kmh_content")
    Call<NewsContentBean> getKmuLectureContent(@Query("href") String href);


    @GET("ecard_account")
    Call<ECardOwnerBean> getECardOwn(@Query("user") String id, @Query("passwd") String pwd);


    @GET("bexam")
    Call<ReExamBean> getBexamBean(@Query("stuid") String id, @Query("passwd") String pwd);


    @GET("selectnumber")
    Call<SelectedCourseIDBean> getSelectedCourseIDBean(@Query("stuid") String id, @Query("passwd") String pwd);


}