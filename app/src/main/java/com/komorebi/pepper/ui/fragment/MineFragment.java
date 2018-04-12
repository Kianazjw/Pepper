package com.komorebi.pepper.ui.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.komorebi.pepper.MyApplication;
import com.komorebi.pepper.R;
import com.komorebi.pepper.api.ApiRetrofit;
import com.komorebi.pepper.api.RetrofitService;
import com.komorebi.pepper.bean.ECardBean;
import com.komorebi.pepper.ui.activity.CETActivity;
import com.komorebi.pepper.ui.activity.ClassMatesActivity;
import com.komorebi.pepper.ui.activity.CreditActivity;
import com.komorebi.pepper.ui.activity.ExamActivity;
import com.komorebi.pepper.ui.activity.MainActivity;
import com.komorebi.pepper.ui.activity.MapActivity;
import com.komorebi.pepper.ui.activity.RepairActivity;


public class MineFragment extends Fragment implements View.OnClickListener {


    private View view;

    private LinearLayout llECard;
    private LinearLayout llExam, llRepair, llCredit, llRowCall, llMap, llCET;

    private TextView tvName, tnSignature;


    private RetrofitService retrofitService;
    private ECardBean mECardBean;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_mine, container, false);


        initView();


        retrofitService = new ApiRetrofit().getApiService();


        return view;
    }

    private void initView() {

        tvName = view.findViewById(R.id.tv_name);
        tvName.setText(MyApplication.name);

        tnSignature = view.findViewById(R.id.tv_signature);
        tnSignature.setOnClickListener(this);

        llExam = view.findViewById(R.id.ll_exam);
        llRepair = view.findViewById(R.id.ll_repair);
        llCredit = view.findViewById(R.id.ll_credit);
        llRowCall = view.findViewById(R.id.ll_name_tool);
        llMap = view.findViewById(R.id.ll_map);
        llCET = view.findViewById(R.id.ll_cet);

        llExam.setOnClickListener(this);
        llRepair.setOnClickListener(this);
        llCredit.setOnClickListener(this);
        llRowCall.setOnClickListener(this);
        llMap.setOnClickListener(this);
        llCET.setOnClickListener(this);

        llECard = view.findViewById(R.id.ll_ecard);
        llECard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.tv_signature:
//                LayoutInflater inflater = getLayoutInflater();
//                View dialog = inflater.inflate(R.layout.dialogsignature, (ViewGroup)view.findViewById(R.id.dialog));
//                EditText editText =  dialog.findViewById(R.id.edittext);
//
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//                builder.setTitle("设置签名");
//                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(getActivity(), editText.getText().toString(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//                builder.setView(dialog);
//                builder.setIcon(R.mipmap.ic_launcher);
//                builder.show();

                break;
            case R.id.ll_ecard:
//                intent = new Intent(getActivity().getApplicationContext(), ECardActivity.class);
//                startActivity(intent);
                Toast.makeText(getActivity().getApplicationContext(), "暂时无法提供一卡通查询服务", Toast.LENGTH_SHORT).show();
                break;

            case R.id.ll_exam:
                intent = new Intent(getActivity().getApplicationContext(), ExamActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_repair:
                intent = new Intent(getActivity().getApplicationContext(), RepairActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_credit:
                intent = new Intent(getActivity().getApplicationContext(), CreditActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_name_tool:
                intent = new Intent(getActivity().getApplicationContext(), ClassMatesActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_map:
                intent = new Intent(getActivity().getApplicationContext(), MapActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_cet:
                intent = new Intent(getActivity().getApplicationContext(), CETActivity.class);
                startActivity(intent);
                break;
        }
    }

//    private void doRequest() {
//        retrofitService.getECard(LoginActivity.token).enqueue(new Callback<ECardBean>() {
//            @Override
//            public void onResponse(Call<ECardBean> call, Response<ECardBean> response) {
//                mECardBean = response.body();
////                if (mECardBean.getCode() == 403) {
////                    new GetToken(getActivity()).getToken();
////                    doRequest();
////                }
//
//                if (mECardBean.getData() != null && mECardBean.getData().size() != 0) {
//                    whetherCheck = 0;
////                    Boolean b = (mECardBean.getData().size() != 0);
//                    float dayConsume = 0;
//                    for (int item = 0; item < mECardBean.getData().size(); item++) {
//                        //判断是不是充钱
//                        if (mECardBean.getData().get(item).getConsume() <= 0) {
//                            dayConsume += mECardBean.getData().get(item).getConsume();
//                        }
//                    }
//                    DecimalFormat fnum = new DecimalFormat("##0.00");
//                    tvConsumer.setText(fnum.format(0 - dayConsume) + "元");
//                    balance = mECardBean.getData().get(0).getBalance();
//                    tvBalance.setText(balance + "元");
//                } else {
//                    Toast.makeText(getActivity(), "唔，服务器暂时无法提供一卡通相关服务", Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ECardBean> call, Throwable t) {
//            }
//        });
//    }
}
