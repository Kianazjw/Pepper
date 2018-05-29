package com.komorebi.pepper.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;



//废弃代码，改用litepal
public class CourseDao {
    private final Context context;
    private final CourseDBHelper courseDBHelper;

    public CourseDao(Context context) {
        this.context = context;
        this.courseDBHelper = new CourseDBHelper(context);
    }

    public void saveCourse(ArrayList<HashMap<String, Object>> list) {
        SQLiteDatabase database = courseDBHelper.getWritableDatabase();
        database.beginTransaction();
        for (HashMap<String, Object> map : list) {
            String select = "select * from " + CourseDBHelper.TABLE_NAME + " where skxq = '" + map.get("skxq") + "' and sksj = '" + map.get("sksj") + "'";
            Cursor cursor = database.rawQuery(select, null);
            if (cursor.getCount() == 0) {
                ContentValues contentValues = new ContentValues();
                for (String key : map.keySet()) contentValues.put(key, String.valueOf(map.get(key)));
                database.insert(CourseDBHelper.TABLE_NAME, null, contentValues);
            }
        }
        database.setTransactionSuccessful();
        database.endTransaction();
    }

    public ArrayList<HashMap<String, String>> findAll() {
        SQLiteDatabase database = courseDBHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from " + CourseDBHelper.TABLE_NAME, null);
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        while (cursor.moveToNext()) {
            HashMap<String, String> map = new HashMap<>();
            map.put("kcmc", cursor.getString(1));
            map.put("js", cursor.getString(2));
            map.put("skdd", cursor.getString(3));
            map.put("skzc", cursor.getString(4));
            map.put("sksj", cursor.getString(5));
            map.put("sksc", cursor.getString(6));
            map.put("skxq", cursor.getString(7));
            arrayList.add(map);
        }
        return arrayList;
    }
    public void deleteAll(){
        SQLiteDatabase database = courseDBHelper.getReadableDatabase();
        database.execSQL("delete from " + CourseDBHelper.TABLE_NAME);
    }

}

