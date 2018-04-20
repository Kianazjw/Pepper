package com.komorebi.pepper.ui.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.komorebi.pepper.MyApplication;
import com.komorebi.pepper.R;
import com.komorebi.pepper.api.ApiRetrofit;
import com.komorebi.pepper.api.RetrofitService;
import com.komorebi.pepper.bean.ScoreBean;
import com.komorebi.pepper.ui.adapter.ScoreAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExamScoreActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout rlScore;
    private LinearLayout llScoreFailed;
    private ListView lvScore;

    private TextView tvPassed, tvNotPassed;


    private ScoreBean mScoreData;

    private RetrofitService retrofitService;
    private String term;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_score);


        Intent intent = getIntent();
        term = intent.getStringExtra("term");

        //标题
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText(intent.getStringExtra("termChinese"));
        ImageView imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(this);
        ImageView imgCheck = findViewById(R.id.img_check);
        imgCheck.setVisibility(View.INVISIBLE);


        tvPassed = findViewById(R.id.tv_already_passed);
        tvNotPassed = findViewById(R.id.tv_not_passed);


        rlScore = findViewById(R.id.rl_exam_score);
        llScoreFailed = findViewById(R.id.ll_score_failed);
        lvScore = findViewById(R.id.lv_scoreListView);


        retrofitService = new ApiRetrofit().getApiService();
        doRequest();
    }

    private void doRequest() {
        retrofitService.getScoreBean(term, MyApplication.getToken()).enqueue(new Callback<ScoreBean>() {
            @Override
            public void onResponse(Call<ScoreBean> call, Response<ScoreBean> response) {
                mScoreData = response.body();
                initData();
            }

            @Override
            public void onFailure(Call<ScoreBean> call, Throwable t) {
            }
        });
    }

    private void initData() {

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<Map<String, String>> list60 = new ArrayList<Map<String, String>>();
        List<Map<String, String>> list6060 = new ArrayList<Map<String, String>>();
        if (mScoreData.data.score.size() != 0) {
            rlScore.setVisibility(View.VISIBLE);
            int count = 0;

            for (int item = 0; item < mScoreData.data.score.size(); item++) {
                Map<String, String> ExamMap = new HashMap<>();
                Map<String, String> ReExamMap = new HashMap<>();
                Map<String, String> RebuildExamMap = new HashMap<>();

                ScoreBean.ChildScoreBean.GrandChildScoreBean ScoreDetails = mScoreData.data.score.get(item);
                ExamMap.put("kcmc", ScoreDetails.kcmc);
                ExamMap.put("kcxf", ScoreDetails.kcxf);
                ExamMap.put("kscj", ScoreDetails.kscj);
                list.add(ExamMap);

                if (ScoreDetails.kscj != "") {
                    ReExamMap.put("kcmc", ScoreDetails.kcmc);
                    ReExamMap.put("kcxf", ScoreDetails.kcxf);
                    ReExamMap.put("kscj", ScoreDetails.kscj);
                    ReExamMap.put("ckcj", ScoreDetails.ckcj);
                    list60.add(ExamMap);
                }
                if (ScoreDetails.cxcj != "") {
                    RebuildExamMap.put("kcmc", ScoreDetails.kcmc);
                    RebuildExamMap.put("kcxf", ScoreDetails.kcxf);
                    RebuildExamMap.put("kscj", ScoreDetails.kscj);
                    RebuildExamMap.put("ckcj", ScoreDetails.ckcj);
                    RebuildExamMap.put("cxcj", ScoreDetails.cxcj);
                    list6060.add(ExamMap);
                }

                try {
                    if (Integer.parseInt(ScoreDetails.kscj) < 60) {
                        ++count;
                    }
                } catch (Exception e) {
                    if (ScoreDetails.kscj.contains("不及格")) {
                        ++count;
                    }
                }
            }

            ScoreAdapter ScoreAdapter = new ScoreAdapter(this, list);
            lvScore.setAdapter(ScoreAdapter);


            String passNum = String.valueOf(list.size() - count);
            SpannableString spannableString = new SpannableString("通过 \n" + passNum + "门");
            RelativeSizeSpan sizeSpan1 = new RelativeSizeSpan(1.6f);
            RelativeSizeSpan sizeSpan2 = new RelativeSizeSpan(1.0f);
            StyleSpan styleSpan_B = new StyleSpan(Typeface.BOLD);
            if (list.size() - count < 10) {
                spannableString.setSpan(styleSpan_B, 0, 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                spannableString.setSpan(sizeSpan1, 4, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                spannableString.setSpan(sizeSpan2, 5, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                tvPassed.setText(spannableString);
            } else {
                spannableString.setSpan(styleSpan_B, 0, 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                spannableString.setSpan(sizeSpan1, 4, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                spannableString.setSpan(sizeSpan2, 6, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                tvPassed.setText(spannableString);
            }

            String notPassNum = String.valueOf(count);
            SpannableString spannableString2 = new SpannableString("未通过\n" + notPassNum + " 门");
            spannableString2.setSpan(styleSpan_B, 0, 4, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            spannableString2.setSpan(sizeSpan1, 4, 5, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            spannableString2.setSpan(sizeSpan2, 5, 6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
            tvNotPassed.setText(spannableString2);
        } else {

            rlScore.setVisibility(View.GONE);
            llScoreFailed.setVisibility(View.VISIBLE);
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
        }
    }
}
