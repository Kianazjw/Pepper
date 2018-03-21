package com.komorebi.pepper.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.komorebi.pepper.R;
import com.wayww.edittextfirework.FireworkView;

public class LoginActivity extends AppCompatActivity {

    private EditText etSno, etEcardPwd, etJwcPwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEcardPwd = findViewById(R.id.et_ecard_pwd);
        etJwcPwd = findViewById(R.id.et_jwc_pwd);
        etSno = findViewById(R.id.et_sno);

        //烟花效果
        FireworkView mFireworkView = findViewById(R.id.fire_work);
        mFireworkView.bindEditText(etSno);

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
