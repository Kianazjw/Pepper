package com.komorebi.pepper.ui.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.komorebi.pepper.MyApplication;
import com.komorebi.pepper.R;
import com.komorebi.pepper.api.ApiRetrofit;
import com.komorebi.pepper.api.RetrofitService;
import com.komorebi.pepper.bean.LoginBean;
import com.komorebi.pepper.bean.ProfileBean;
import com.wayww.edittextfirework.FireworkView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etSno, etEcardPwd, etJwcPwd;

    private LoginBean loginBean;
    private ProfileBean mProfileBean;
    private RetrofitService retrofitService;

    private SharedPreferences userInfo;
    private SharedPreferences.Editor editor;
    private String sno = "", jwcPwd = "", ePwd = "";


    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userInfo = getSharedPreferences("userInfo", MODE_PRIVATE);
        editor = userInfo.edit();

        retrofitService = new ApiRetrofit().getApiService();

        etSno = findViewById(R.id.et_sno);
        etJwcPwd = findViewById(R.id.et_jwc_pwd);
        etEcardPwd = findViewById(R.id.et_ecard_pwd);

        //烟花效果
        FireworkView mFireworkView = findViewById(R.id.fire_work);
        mFireworkView.bindEditText(etSno);

        Button btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sno = etSno.getText().toString();
                jwcPwd = etJwcPwd.getText().toString();
                ePwd = etEcardPwd.getText().toString();
                if (sno.length() != 16) {
                    Toast.makeText(LoginActivity.this, "请正确输入学号", Toast.LENGTH_SHORT).show();
                } else {
                    if (jwcPwd.length() == 0) {
                        Toast.makeText(LoginActivity.this, "请正确输入教务处密码", Toast.LENGTH_SHORT).show();
                    } else {
                        if (ePwd.length() == 0) {
                            Toast.makeText(LoginActivity.this, "温馨提示：一卡通默认密码：888888", Toast.LENGTH_SHORT).show();
                        } else {

                            //隐藏键盘
                            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                            if (imm != null) {
                                imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                            }

                            loginCheck(sno, jwcPwd, ePwd);
                        }
                    }
                }
            }
        });

        if (isUserEixt()) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    //获取token
    public boolean loginCheck(final String sno, final String jwcPwd, final String ePwd) {
        retrofitService.getCheckLogin(sno, jwcPwd, ePwd).enqueue(new Callback<LoginBean>() {
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                loginBean = response.body();
                if (loginBean != null) {
                    if (loginBean.msg.equals("success")) {

                        MyApplication.setToken(loginBean.token);

                        editor.putString("sno", sno);
                        editor.putString("jwcPwd", jwcPwd);
                        editor.putString("ePwd", ePwd);
                        editor.commit();

                        initInfo();

                    } else {
                        Toast.makeText(LoginActivity.this, loginBean.msg, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                Toast.makeText(LoginActivity.this, " ", Toast.LENGTH_SHORT).show();
            }
        });
        return true;
    }

    // 后台获取数据，初始化用户信息
    public void initInfo() {
        retrofitService.getProfile(MyApplication.getToken()).enqueue(new Callback<ProfileBean>() {
            @Override
            public void onResponse(Call<ProfileBean> call, Response<ProfileBean> response) {
                mProfileBean = response.body();
                if (mProfileBean != null) {

                    editor.putString("name", mProfileBean.getData().getXm());
                    editor.commit();

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, "登入成功", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ProfileBean> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "服务器无法运行", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isUserEixt() {
        return userInfo.getString("sno", "").length() != 0;
    }


}
