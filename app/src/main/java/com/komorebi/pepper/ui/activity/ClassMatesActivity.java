package com.komorebi.pepper.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.komorebi.pepper.MyApplication;
import com.komorebi.pepper.R;
import com.komorebi.pepper.api.ApiRetrofit;
import com.komorebi.pepper.api.RetrofitService;
import com.komorebi.pepper.bean.ClassmatesBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ClassMatesActivity extends AppCompatActivity {

    private RetrofitService retrofitService;

    private ClassmatesBean classmatesBean;
    private List<String> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_mates);

        listView = findViewById(R.id.lv_classmates);
        list = new ArrayList<>();

        retrofitService = new ApiRetrofit().getApiService();

        doRequest();
    }

    private void doRequest() {
        retrofitService.getClassmates(MyApplication.getToken()).enqueue(new Callback<ClassmatesBean>() {
            @Override
            public void onResponse(Call<ClassmatesBean> call, Response<ClassmatesBean> response) {
                classmatesBean = response.body();

                for (int i = 0; i < classmatesBean.data.size(); i++) {
                    ClassmatesBean.ChildClassmatesBean childClassmatesBean = classmatesBean.data.get(i);
                    list.add(childClassmatesBean.xm);
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        ClassMatesActivity.this, android.R.layout.simple_list_item_1, list);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ClassmatesBean> call, Throwable t) {

            }

        });


    }
}
