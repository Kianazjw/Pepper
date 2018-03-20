package com.komorebi.pepper.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.komorebi.pepper.R;

public class BugFeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgBack, imgCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug_feedback);

        imgBack = findViewById(R.id.img_back);
        imgCheck = findViewById(R.id.img_check);
        imgCheck.setOnClickListener(this);
        imgBack.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_check:
                //判断邮箱格式是否正确
                Toast.makeText(this, "反馈成功，感谢你的意见 : )", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
