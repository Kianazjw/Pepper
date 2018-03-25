package com.komorebi.pepper.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.komorebi.pepper.R;
import com.wayww.edittextfirework.FireworkView;

public class BugFeedbackActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgBack, imgCheck;
    private EditText etContact;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        android.transition.Transition slide = TransitionInflater.from(this).inflateTransition(R.transition.slide);
        getWindow().setExitTransition(slide);
        getWindow().setEnterTransition(slide);
        getWindow().setReenterTransition(slide);
        setContentView(R.layout.activity_bug_feedback);

        imgBack = findViewById(R.id.img_back);
        imgCheck = findViewById(R.id.img_check);
        imgCheck.setOnClickListener(this);
        imgBack.setOnClickListener(this);

        etContact = findViewById(R.id.et_contact);
        //烟花效果
        FireworkView mFireworkView = findViewById(R.id.fire_work);
        mFireworkView.bindEditText(etContact);

        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText("建议反馈");

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
