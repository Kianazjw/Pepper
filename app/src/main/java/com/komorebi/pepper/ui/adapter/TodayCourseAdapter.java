package com.komorebi.pepper.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.komorebi.pepper.R;


/**
 * Created by Komorebi on 2017/4/7.
 */

public class TodayCourseAdapter extends BaseAdapter {

    private Context context;
    private String[][] arr = null;

    public TodayCourseAdapter(Context context, String[][] arr) {
        super();
        this.context = context;
        this.arr = arr;
    }

    @Override
    public int getCount() {
        return 6;
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
        //判断是否有缓存
        if (convertView == null) {
            //通过LayoutInflate实例化布局
            viewHolder = new ViewHolder();
            view = View.inflate(context, R.layout.listview_today_course_item, null);

            viewHolder.tvClassSection = view.findViewById(R.id.tv_class_section);
            viewHolder.tvClassName =  view.findViewById(R.id.tv_class_name);
            viewHolder.tvClassRoom =  view.findViewById(R.id.tv_class_room);
            viewHolder.tvTeacherName =  view.findViewById(R.id.tv_teacher_name);
            viewHolder.llTodayCourse =  view.findViewById(R.id.ll_today_course);
            view.setTag(viewHolder);
        } else {
            //通过tag找到缓存的布局
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }


        viewHolder.tvClassSection.setText(arr[position][0]);
        viewHolder.tvClassName.setText(arr[position][1]);
        viewHolder.tvClassRoom.setText(arr[position][2]);
        viewHolder.tvTeacherName.setText(arr[position][3]);

        switch (position) {
            case 0:
                viewHolder.tvClassSection.setBackgroundResource(R.drawable.course_1_2);
                break;
            case 1:
                viewHolder.tvClassSection.setBackgroundResource(R.drawable.course_3_4);
                viewHolder.llTodayCourse.setBackgroundColor(Color.parseColor("#ccffffff"));
                break;
            case 2:
                viewHolder.tvClassSection.setBackgroundResource(R.drawable.course_5_6);
                break;
            case 3:
                viewHolder.tvClassSection.setBackgroundResource(R.drawable.course_7_8);
                viewHolder.llTodayCourse.setBackgroundColor(Color.parseColor("#ccffffff"));
                break;
            case 4:
                viewHolder.tvClassSection.setBackgroundResource(R.drawable.course_9_10);
                break;
            case 5:
                viewHolder.tvClassSection.setBackgroundResource(R.drawable.course_11_12);
                viewHolder.llTodayCourse.setBackgroundColor(Color.parseColor("#ccffffff"));
                break;
        }


        return view;
    }

    private static class ViewHolder {
        TextView tvClassSection;
        TextView tvClassName;
        TextView tvClassRoom;
        TextView tvTeacherName;
        LinearLayout llTodayCourse;
    }
}
