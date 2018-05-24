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

        ViewHolder viewHolder;
        View view;

        if (convertView == null) {
            view = View.inflate(context, R.layout.listview_score_data_item, null);

            viewHolder = new ViewHolder();
            viewHolder.tvKcmc = view.findViewById(R.id.tv_kcmc);
            viewHolder.tvScore = view.findViewById(R.id.tv_score);

            //将viewholder存储在view中
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }


        Map<String, String> item = list.get(position);

        viewHolder.tvKcmc.setText(item.get("kcmc"));
        viewHolder.tvScore.setText(item.get("kscj"));
        try {
            if (Integer.parseInt(item.get("kscj")) < 60) {
                viewHolder.tvKcmc.setTextColor(Color.parseColor("#FFc360"));
                viewHolder.tvScore.setTextColor(Color.parseColor("#FFc360"));
            }
        } catch (Exception e) {
            if (item.get("kscj").contains("不及格")) {
                viewHolder.tvKcmc.setTextColor(Color.parseColor("#FFc360"));
                viewHolder.tvScore.setTextColor(Color.parseColor("#FFc360"));
            }
        }

        return view;
    }

    class ViewHolder {
        TextView tvKcmc;
        TextView tvScore;
    }

}
