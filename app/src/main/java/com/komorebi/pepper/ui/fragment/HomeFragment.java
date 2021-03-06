package com.komorebi.pepper.ui.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.komorebi.pepper.MyApplication;
import com.komorebi.pepper.R;
import com.komorebi.pepper.api.ApiRetrofit;
import com.komorebi.pepper.api.RetrofitService;
import com.komorebi.pepper.bean.LoginTokenBean;
import com.komorebi.pepper.bean.TodayCourseBean;
import com.komorebi.pepper.ui.activity.CourseActivity;
import com.komorebi.pepper.ui.adapter.TodayCourseAdapter;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private RetrofitService retrofitService;

    private LoginTokenBean loginTokenBean;
    private TodayCourseBean todayCourseBean;

    private TextView tvWeekNum;
    private LinearLayout llCourseLording;
    private ListView lvTodayCourse;
    private TextView tvNoCourse;


    private SharedPreferences todayCourseSP;
    private SharedPreferences.Editor editor;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        todayCourseSP = getActivity().getSharedPreferences("todayCourseSP", MODE_PRIVATE);
        editor = todayCourseSP.edit();//获取Editor


        initView(view);

        retrofitService = new ApiRetrofit().getApiService();
        getToken(MyApplication.sno, MyApplication.jwcPwd, MyApplication.ePwd);

        return view;
    }


    private void initView(View view) {
        //第几周
        tvWeekNum = view.findViewById(R.id.tv_week_num);

        TextView tvSeeAll = view.findViewById(R.id.tv_see_all);
        tvSeeAll.setOnClickListener(this);

        LinearLayout llCourse = view.findViewById(R.id.ll_course);
        llCourse.setOnClickListener(this);

        tvNoCourse = view.findViewById(R.id.tv_course_lording_no_course);
        llCourseLording = view.findViewById(R.id.ll_today_course_loarding);

        String name = MyApplication.name;
        TextView tvStuName = view.findViewById(R.id.tv_hello_stu);
        String s = "你好啊\n" + name;
        tvStuName.setText(s);

        //设置星期几
        TextView tv_week = view.findViewById(R.id.tv_week);
        Calendar c = Calendar.getInstance();
        String week = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(week)) {
            week = "Sun.";
        } else if ("2".equals(week)) {
            week = "Mon.";
        } else if ("3".equals(week)) {
            week = "Tues.";
        } else if ("4".equals(week)) {
            week = "Wed.";
        } else if ("5".equals(week)) {
            week = "Thur.";
        } else if ("6".equals(week)) {
            week = "Fri.";
        } else if ("7".equals(week)) {
            week = "Sat.";
        }
        tv_week.setText(week);

        lvTodayCourse = view.findViewById(R.id.lv_todayCourse);
        lvTodayCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tvClassRoom = view.findViewById(R.id.tv_class_room);
                if (tvClassRoom.getText().length() > 2) {
                    Toast.makeText(getActivity(), tvClassRoom.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getToken(String sno, String jwcPwd, String ePwd) {

//        测试时间
//        long startTime = System.currentTimeMillis();
//        long endTime = System.currentTimeMillis();
//        long time = endTime - startTime;
//        Log.i("获取Token时间", String.valueOf(time));

        retrofitService.getCheckLogin(sno, jwcPwd, ePwd).enqueue(new Callback<LoginTokenBean>() {
            @Override
            public void onResponse(Call<LoginTokenBean> call, Response<LoginTokenBean> response) {
                loginTokenBean = response.body();
                if (loginTokenBean != null) {
                    if (loginTokenBean.msg.equals("success")) {
                        MyApplication.setToken(loginTokenBean.token);
                        doRequest();
                    } else {
                        Toast.makeText(getContext(), loginTokenBean.msg, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginTokenBean> call, Throwable t) {
                Toast.makeText(getContext(), "服务器跑路了，告辞 ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void doRequest() {
        retrofitService.getTodayCourseBean(MyApplication.getToken()).enqueue(new Callback<TodayCourseBean>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<TodayCourseBean> call, Response<TodayCourseBean> response) {
                todayCourseBean = response.body();

                if (todayCourseBean != null) {

                    String week = "第" + String.valueOf(todayCourseBean.getData().getWeek()) + "周";
                    tvWeekNum.setText(week);
                    editor.putString("NumOfWeeks", String.valueOf(todayCourseBean.getData().getWeek()));
                    editor.commit();

                    llCourseLording.setVisibility(View.GONE);
                    lvTodayCourse.setVisibility(View.VISIBLE);

                    String[][] arr = new String[6][4];
                    for (int i = 0; i < 6; i++) {
                        for (int j = 1; j < 4; j++) {
                            arr[i][j] = "";
                        }
                    }
                    arr[0][0] = "1-2";
                    arr[1][0] = "3-4";
                    arr[2][0] = "5-6";
                    arr[3][0] = "7-8";
                    arr[4][0] = "9-10";
                    arr[5][0] = "11-12";
                    for (int i = 0; i < todayCourseBean.getData().getDaylist().size(); i++) {
                        TodayCourseBean.DataBean.DaylistBean daylistBean = todayCourseBean.getData().getDaylist().get(i);

                        String classSpan = daylistBean.getClassSpan();

                        if (classSpan.contains("1")) {
                            if (!classSpan.contains("0")) {
                                arr[0][1] = daylistBean.getCourse();
                                arr[0][2] = daylistBean.getClassRoom();
                                arr[0][3] = daylistBean.getTeacherName();
                            }
                        } else if (classSpan.contains("3")) {
                            arr[1][1] = daylistBean.getCourse();
                            arr[1][2] = daylistBean.getClassRoom();
                            arr[1][3] = daylistBean.getTeacherName();
                        } else if (classSpan.contains("5")) {
                            arr[2][1] = daylistBean.getCourse();
                            arr[2][2] = daylistBean.getClassRoom();
                            arr[2][3] = daylistBean.getTeacherName();
                        } else if (classSpan.contains("7")) {
                            arr[3][1] = daylistBean.getCourse();
                            arr[3][2] = daylistBean.getClassRoom();
                            arr[3][3] = daylistBean.getTeacherName();
                        } else if (classSpan.contains("9")) {
                            arr[4][1] = daylistBean.getCourse();
                            arr[4][2] = daylistBean.getClassRoom();
                            arr[4][3] = daylistBean.getTeacherName();
                        } else if (classSpan.contains("11")) {
                            arr[5][1] = daylistBean.getCourse();
                            arr[5][2] = daylistBean.getClassRoom();
                            arr[5][3] = daylistBean.getTeacherName();
                        }
                    }
                    llCourseLording.setVisibility(View.GONE);
                    lvTodayCourse.setVisibility(View.VISIBLE);


                    TodayCourseAdapter todayCourseAdapter = new TodayCourseAdapter(getActivity(), arr);
                    lvTodayCourse.setAdapter(todayCourseAdapter);
                } else {
                    tvNoCourse.setText("Enjoy Yourself!");
                }
            }

            @Override
            public void onFailure(Call<TodayCourseBean> call, Throwable t) {
            }
        });


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_see_all:
                Intent intent = new Intent(getActivity(), CourseActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_course:

                break;
            default:
                break;
        }
    }
}
