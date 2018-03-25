package com.komorebi.pepper.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionInflater;
import android.view.Window;

import com.komorebi.pepper.R;

public class TeamActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //activity动画，在setContentView()之前执行
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        android.transition.Transition explode = TransitionInflater.from(this).inflateTransition(R.transition.explode);
        //退出时使用
        getWindow().setExitTransition(explode);
        //第一次进入时使用
        getWindow().setEnterTransition(explode);
        //再次进入时使用
        getWindow().setReenterTransition(explode);

        setContentView(R.layout.activity_team);
    }
}
