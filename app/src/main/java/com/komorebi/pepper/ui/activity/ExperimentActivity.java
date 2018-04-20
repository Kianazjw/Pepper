package com.komorebi.pepper.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LayoutAnimationController;
import android.widget.ListView;
import android.widget.Toast;

import com.komorebi.pepper.MyApplication;
import com.komorebi.pepper.R;
import com.komorebi.pepper.api.ApiRetrofit;
import com.komorebi.pepper.bean.MyExperimentBean;
import com.komorebi.pepper.ui.adapter.ExperimentArrangeAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExperimentActivity extends AppCompatActivity {

    private MyExperimentBean myExperimentBean;

    private ListView lvExperimentArrange;
    private LayoutAnimationController controller;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experiment);

        lvExperimentArrange =  findViewById(R.id.lv_examArrangeListView);

        doRequest();
    }

    private void doRequest() {

        new ApiRetrofit().getApiService().getExperiment(MyApplication.getToken()).enqueue(new Callback<MyExperimentBean>() {
            @Override
            public void onResponse(Call<MyExperimentBean> call, Response<MyExperimentBean> response) {
                myExperimentBean = response.body();
                if (myExperimentBean.getData().getExperiment() == null) {
                    Toast.makeText(ExperimentActivity.this, "暂无实验安排", Toast.LENGTH_LONG).show();
                } else {
                    int size = myExperimentBean.getData().getExperiment().size();
                    if (size != 0) {
                        List<Map<String, String>> list = new ArrayList<>();
                        List<MyExperimentBean.DataBean.ExperimentBean> listExperiment = myExperimentBean.getData().getExperiment();
                        for (int i = 0; i < size; i++) {
                            Map<String, String> map = new HashMap<String, String>();
                            map.put("kcmc", listExperiment.get(i).getKcmc());//课程名字
                            map.put("symc", listExperiment.get(i).getSymc());//实验名称
                            map.put("syfs", listExperiment.get(i).getSyfs());//实验方式
                            map.put("sj", listExperiment.get(i).getSj());//时间
                            map.put("sydd", listExperiment.get(i).getSydd());//实验地点
                            map.put("js", listExperiment.get(i).getJs());//教师
                            list.add(map);
                        }
                        ExperimentArrangeAdapter experimentArrangeAdapter = new ExperimentArrangeAdapter(ExperimentActivity.this, list);
                        animation = new AlphaAnimation(0f, 1f);
                        animation.setDuration(350);
                        controller = new LayoutAnimationController(animation, 1f);
                        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
                        lvExperimentArrange.setLayoutAnimation(controller);
                        experimentArrangeAdapter.notifyDataSetInvalidated();
                        lvExperimentArrange.setAdapter(experimentArrangeAdapter);
                    }

                }
            }

            @Override
            public void onFailure(Call<MyExperimentBean> call, Throwable t) {
            }
        });
    }

}
