package com.komorebi.pepper.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.komorebi.pepper.R;

import java.util.Calendar;

public class ExamActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences userInfo;
    private String myBeginTimeYear;
    private int year, month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        userInfo = getSharedPreferences("userInfo", MODE_PRIVATE);
        myBeginTimeYear = userInfo.getString("sno", null).substring(0, 4);

//        标题
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("考试查询");
        ImageView imgBack = findViewById(R.id.img_back);
        imgBack.setOnClickListener(this);
        ImageView imgCheck = findViewById(R.id.img_check);
        imgCheck.setVisibility(View.INVISIBLE);


        LinearLayout llTerm1 = findViewById(R.id.ll_term1);
        LinearLayout llTerm2 = findViewById(R.id.ll_term2);
        LinearLayout llTerm3 = findViewById(R.id.ll_term3);
        LinearLayout llTerm4 = findViewById(R.id.ll_term4);
        LinearLayout llTerm5 = findViewById(R.id.ll_term5);
        LinearLayout llTerm6 = findViewById(R.id.ll_term6);
        llTerm1.setOnClickListener(this);
        llTerm2.setOnClickListener(this);
        llTerm3.setOnClickListener(this);
        llTerm4.setOnClickListener(this);
        llTerm5.setOnClickListener(this);
        llTerm6.setOnClickListener(this);

        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR); // 获取当前年份
        month = c.get(Calendar.MONTH) + 1;// 获取当前月份
        int beginTimeYear = Integer.parseInt(myBeginTimeYear);
        if (year == beginTimeYear) {
            llTerm1.setVisibility(View.VISIBLE);
        } else {
            if (year > beginTimeYear) {
                llTerm1.setVisibility(View.VISIBLE);
                llTerm2.setVisibility(View.VISIBLE);
                if (month > 8)
                    llTerm3.setVisibility(View.VISIBLE);
                if (year - 1 > beginTimeYear) {
                    llTerm3.setVisibility(View.VISIBLE);
                    llTerm4.setVisibility(View.VISIBLE);
                    if (month > 8)
                        llTerm5.setVisibility(View.VISIBLE);
                    if (year - 2 > beginTimeYear) {
                        llTerm5.setVisibility(View.VISIBLE);
                        llTerm6.setVisibility(View.VISIBLE);
                    }
                }
            }
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.ll_term1:
                intent = new Intent(ExamActivity.this, ExamScoreActivity.class);
                intent.putExtra("termChinese", "大一上学期");
                intent.putExtra("term", userInfo.getString("sno", null).substring(0, 4) + ".1");
                startActivity(intent);
                break;
            case R.id.ll_term2:
                intent = new Intent(ExamActivity.this, ExamScoreActivity.class);
                intent.putExtra("termChinese", "大一下学期");
                intent.putExtra("term", userInfo.getString("sno", null).substring(0, 4) + ".2");
                startActivity(intent);
                break;
            case R.id.ll_term3:
                intent = new Intent(ExamActivity.this, ExamScoreActivity.class);
                intent.putExtra("termChinese", "大二上学期");
                intent.putExtra("term", String.valueOf(myBeginTimeYear + 1) + ".1");
                startActivity(intent);
                break;
            case R.id.ll_term4:
                intent = new Intent(ExamActivity.this, ExamScoreActivity.class);
                intent.putExtra("termChinese", "大二下学期");
                intent.putExtra("term", String.valueOf(myBeginTimeYear + 1) + ".2");
                startActivity(intent);
                break;
            case R.id.ll_term5:
                intent = new Intent(ExamActivity.this, ExamScoreActivity.class);
                intent.putExtra("termChinese", "大三上学期");
                intent.putExtra("term", String.valueOf(myBeginTimeYear + 2) + ".1");
                startActivity(intent);
                break;
            case R.id.ll_term6:
                intent = new Intent(ExamActivity.this, ExamScoreActivity.class);
                intent.putExtra("termChinese", "大三下学期");
                intent.putExtra("term", String.valueOf(myBeginTimeYear + 2) + ".2");
                startActivity(intent);
                break;
            case R.id.img_back:
                finish();
                break;

        }

    }
}
