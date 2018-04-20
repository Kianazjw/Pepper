package com.komorebi.pepper.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.komorebi.pepper.R;

import java.util.List;
import java.util.Map;

public class ScoreAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, String>> list;

    public ScoreAdapter(Context context, List<Map<String, String>> list) {
        super();
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = View.inflate(context, R.layout.listview_score_data_item, null);
        Map<String, String> item = list.get(position);

        TextView tv_kcmc = view.findViewById(R.id.tv_kcmc);
        TextView tv_score = view.findViewById(R.id.tv_score);

        tv_kcmc.setText(item.get("kcmc"));
        tv_score.setText(item.get("kscj"));
        try {
            if (Integer.parseInt(item.get("kscj")) < 60) {
                tv_kcmc.setTextColor(Color.parseColor("#FFc360"));
                tv_score.setTextColor(Color.parseColor("#FFc360"));
            }
        } catch (Exception e) {
            if (item.get("kscj").contains("不及格")) {
                tv_kcmc.setTextColor(Color.parseColor("#FFc360"));
                tv_score.setTextColor(Color.parseColor("#FFc360"));
            }
        }

        return view;
    }
}
