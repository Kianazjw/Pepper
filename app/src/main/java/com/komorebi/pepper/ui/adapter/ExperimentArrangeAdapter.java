package com.komorebi.pepper.ui.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.komorebi.pepper.R;

import java.util.List;
import java.util.Map;


/**
 * Created by Hyololi on 2017/4/7.
 */

public class ExperimentArrangeAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, String>> list;

    public ExperimentArrangeAdapter(Context context, List<Map<String, String>> list) {
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

//        int[] background = {R.drawable.bg_exam_blue, R.drawable.bg_exam_orange};

        ViewHolder viewHolder;
        View view;
        //判断是否有缓存
        if (convertView == null) {
            //通过LayoutInflate实例化布局
            viewHolder = new ViewHolder();
            view = View.inflate(context, R.layout.listview_exam_arrange_item, null);
            viewHolder.llExamArrange = view.findViewById(R.id.ll_exam_arrange);
            viewHolder.tvKcmc = view.findViewById(R.id.tv_arrange_subject);
            viewHolder.tvKsdd = view.findViewById(R.id.tv_arrange_address);
            viewHolder.tvKssj = view.findViewById(R.id.tv_arrange_time);
            viewHolder.tvKcxz = view.findViewById(R.id.tv_arrange_character);
            viewHolder.tvBjmc = view.findViewById(R.id.tv_arrange_class_name);
            viewHolder.tvXbbh = view.findViewById(R.id.tv_arrange_class_num);
            view.setTag(viewHolder);
        } else {
            //通过tag找到缓存的布局
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }


        Map<String, String> item = list.get(position);
        if (item.get("rose") == "rose") {
            viewHolder.tvBjmc.setVisibility(View.GONE);
            viewHolder.tvXbbh.setVisibility(View.INVISIBLE);
        }
        switch (position % 4) {
            case 0:
                viewHolder.llExamArrange.setBackgroundResource(R.drawable.bg_exam_blue);
                break;
            case 1:
                viewHolder.llExamArrange.setBackgroundResource(R.drawable.bg_exam_orange);
                break;
            case 2:
                viewHolder.llExamArrange.setBackgroundResource(R.drawable.bg_exam_green);
                break;
            case 3:
                viewHolder.llExamArrange.setBackgroundResource(R.drawable.bg_exam_matcha_green);
                break;
        }


        StyleSpan styleSpan_B = new StyleSpan(Typeface.BOLD);
        SpannableString ssKcmc = new SpannableString("实验课程:  " + item.get("kcmc"));
        ssKcmc.setSpan(styleSpan_B, 0, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        viewHolder.tvKcmc.setText(ssKcmc);

        SpannableString ssKsdd = new SpannableString("实验名称:  " + item.get("symc"));
        ssKsdd.setSpan(styleSpan_B, 0, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        viewHolder.tvKsdd.setText(ssKsdd);


        SpannableString ssKssj = new SpannableString("实验时间:  " + item.get("sj"));
        ssKssj.setSpan(styleSpan_B, 0, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        viewHolder.tvKssj.setText(ssKssj);

        SpannableString ssKcxz = new SpannableString("实验地点:  " + item.get("sydd"));
        ssKcxz.setSpan(styleSpan_B, 0, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        viewHolder.tvKcxz.setText(ssKcxz);

        viewHolder.tvBjmc.setVisibility(View.GONE);

        SpannableString ssXbbh = new SpannableString("教师         :  " + item.get("js"));
        ssXbbh.setSpan(styleSpan_B, 0, 4, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        viewHolder.tvXbbh.setText(ssXbbh);

        return view;
    }

    private static class ViewHolder {
        TextView tvKcmc;
        TextView tvKsdd;
        TextView tvKssj;
        TextView tvKcxz;
        TextView tvBjmc;
        TextView tvXbbh;
        LinearLayout llExamArrange;

    }
}
