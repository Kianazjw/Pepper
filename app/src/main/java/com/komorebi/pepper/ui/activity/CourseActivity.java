package com.komorebi.pepper.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.komorebi.pepper.MyApplication;
import com.komorebi.pepper.R;
import com.komorebi.pepper.api.ApiRetrofit;
import com.komorebi.pepper.bean.CourseBean;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseActivity extends AppCompatActivity implements View.OnClickListener {

    private int gridHeight, gridWidth;
    private RelativeLayout layout;
    private RelativeLayout tmpLayout;
    private static boolean isFirst = true;

    private SharedPreferences userInfo, todayCourseSP;

    private CourseBean courseBean;

    private ImageView imgExperiment;

    private TextView textView, tvSelectWeek;

    private ImageView imgBack;

    private int temp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        userInfo = getSharedPreferences("userInfo", MODE_PRIVATE);
        todayCourseSP = getSharedPreferences("todayCourseSP", MODE_PRIVATE);

        imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(this);
        imgExperiment = findViewById(R.id.title_right_img);
        imgExperiment.setOnClickListener(this);

        tvSelectWeek = findViewById(R.id.tv_select_week);
        tvSelectWeek.setOnClickListener(this);
        tvSelectWeek.setText(todayCourseSP.getString("NumOfWeeks", " "));

        Random rand = new Random();
        temp = rand.nextInt(7);

        tmpLayout = findViewById(R.id.Monday);
        tmpLayout.setOnClickListener(this);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView_course);
        scrollView.setOnClickListener(this);

        doRequest();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_right_img:
                Intent intent = new Intent(CourseActivity.this, ExperimentActivity.class);
                startActivity(intent);
                break;
            case R.id.img_back:
                finish();
                break;
            case R.id.scrollView_course:
                doRequest();
                break;
            case R.id.tv_select_week:
                //选择周数
                break;
        }

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (isFirst) {
            isFirst = false;
            gridWidth = tmpLayout.getWidth();
            gridHeight = tmpLayout.getHeight() / 12;
        }
    }

    private TextView createTv(int start, int end, String text) {
        TextView tv = new TextView(this);
//         指定高度和宽度
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(gridWidth, gridHeight * (end - start + 1));
//        指定位置
        tv.setY(gridHeight * (start - 1));
        tv.setLayoutParams(params);
        tv.setGravity(Gravity.CENTER);
        tv.setPadding(2, 2, 2, 2);
        tv.setText(text);

        return tv;
    }

    private void addView(int i, int start, int end, String text) {

        int[] background = {R.drawable.course1, R.drawable.course2, R.drawable.course3, R.drawable.course4,
                R.drawable.course5, R.drawable.course6, R.drawable.course7, R.drawable.course8};

        TextView tv;
        switch (i) {
            case 1:
                layout = findViewById(R.id.Monday);
                break;
            case 2:
                layout = findViewById(R.id.Tuesday);
                break;
            case 3:
                layout = findViewById(R.id.Wednesday);
                break;
            case 4:
                layout = findViewById(R.id.Thursday);
                break;
            case 5:
                layout = findViewById(R.id.Friday);
                break;
            case 6:
                layout = findViewById(R.id.Saturday);
                break;
            case 7:
                layout = findViewById(R.id.Sunday);
                break;
        }

        tv = createTv(start, end, text);
        tv.setBackgroundResource(background[(temp++) % 7]);
        layout.addView(tv);
    }

    private void doRequest() {
        new ApiRetrofit().getApiService().getCourse("1", MyApplication.getToken()).enqueue(new Callback<CourseBean>() {
            @Override
            public void onResponse(Call<CourseBean> call, Response<CourseBean> response) {
                courseBean = response.body();

                CourseBean.DataBean.ScheduleBean scheduleBean = courseBean.data.schedule;
                int min, max;
                if (scheduleBean != null) {
                    List<CourseBean.DataBean.ScheduleBean.MonBean> listMon = scheduleBean.Mon;
                    if (listMon != null) {
                        for (int i = 0; i < listMon.size(); i++) {
                            String[] sourceStrArray = listMon.get(i).sksj.split("-");
                            min = Integer.parseInt(sourceStrArray[0]);
                            max = Integer.parseInt(sourceStrArray[sourceStrArray.length - 1]);
                            addView(1, min, max, listMon.get(i).kcmc);
                        }
                    }

                    List<CourseBean.DataBean.ScheduleBean.TuesBean> listTues = scheduleBean.Tues;
                    if (listTues != null) {
                        for (int i = 0; i < listTues.size(); i++) {
                            String[] sourceStrArray = listTues.get(i).sksj.split("-");
                            min = Integer.parseInt(sourceStrArray[0]);
                            max = Integer.parseInt(sourceStrArray[sourceStrArray.length - 1]);
                            addView(2, min, max, listTues.get(i).kcmc);
                        }
                    }

                    List<CourseBean.DataBean.ScheduleBean.WedBean> listWed = scheduleBean.Wed;
                    if (listWed != null) {
                        for (int i = 0; i < listWed.size(); i++) {
                            String[] sourceStrArray = listWed.get(i).sksj.split("-");
                            min = Integer.parseInt(sourceStrArray[0]);
                            max = Integer.parseInt(sourceStrArray[sourceStrArray.length - 1]);
                            addView(3, min, max, listWed.get(i).kcmc);
                        }
                    }

                    List<CourseBean.DataBean.ScheduleBean.ThurBean> listThur = scheduleBean.Thur;
                    if (listThur != null) {
                        for (int i = 0; i < listThur.size(); i++) {
                            String[] sourceStrArray = listThur.get(i).sksj.split("-");
                            min = Integer.parseInt(sourceStrArray[0]);
                            max = Integer.parseInt(sourceStrArray[sourceStrArray.length - 1]);
                            addView(4, min, max, listThur.get(i).kcmc);
                        }
                    }

                    List<CourseBean.DataBean.ScheduleBean.FriBean> listFri = scheduleBean.Fri;
                    if (listFri != null) {
                        for (int i = 0; i < listFri.size(); i++) {
                            String[] sourceStrArray = listFri.get(i).sksj.split("-");
                            min = Integer.parseInt(sourceStrArray[0]);
                            max = Integer.parseInt(sourceStrArray[sourceStrArray.length - 1]);
                            addView(5, min, max, listFri.get(i).kcmc);
                        }
                    }

                    textView = (TextView) findViewById(R.id.tv_sat);
                    layout = (RelativeLayout) findViewById(R.id.Saturday);
                    List<CourseBean.DataBean.ScheduleBean.SatBean> listSat = scheduleBean.Sat;
                    if (listSat != null) {
                        textView.setVisibility(View.VISIBLE);
                        layout.setVisibility(View.VISIBLE);
                        for (int i = 0; i < listSat.size(); i++) {
                            String[] sourceStrArray = listSat.get(i).sksj.split("-");
                            min = Integer.parseInt(sourceStrArray[0]);
                            max = Integer.parseInt(sourceStrArray[sourceStrArray.length - 1]);
                            addView(6, min, max, listSat.get(i).kcmc);
                        }
                    }

                    textView = findViewById(R.id.tv_sun);
                    layout = findViewById(R.id.Sunday);
                    List<CourseBean.DataBean.ScheduleBean.SunBean> listSun = scheduleBean.Sun;
                    if (listSun != null) {
                        textView.setVisibility(View.VISIBLE);
                        layout.setVisibility(View.VISIBLE);
                        for (int i = 0; i < listSun.size(); i++) {
                            String[] sourceStrArray = listSun.get(i).sksj.split("-");
                            min = Integer.parseInt(sourceStrArray[0]);
                            max = Integer.parseInt(sourceStrArray[sourceStrArray.length - 1]);
                            addView(7, min, max, listSun.get(i).kcmc);
                        }
                    }

                }

            }

            @Override
            public void onFailure(Call<CourseBean> call, Throwable t) {

            }
        });
    }
}
