package com.komorebi.pepper.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.komorebi.pepper.bean.ClassmatesBean;

import java.util.List;

/**
 * Created by Komorebi on 2018/4/11.
 */

public class StudentInClassAdapter extends BaseAdapter {

    private List<ClassmatesBean> list;

    public StudentInClassAdapter(Context context, List<ClassmatesBean> list, boolean isDone){
        this.list = list;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
