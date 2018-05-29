package com.komorebi.pepper.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



//废弃代码，改用litepal
public class CourseDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "hjxyt.db";
    public static final String TABLE_NAME = "course";
    private static final int DB_VERSION = 1;
    private  Context context;

    public static final String CREAT_COURSE = "create table course(\n" +
            "       id integer not null primary key autoincrement,\n" +
            "       kcmc CHAR(255) NOT NULL,\n" +
            "       js CHAR(255) NOT NULL,\n" +
            "       skdd CHAR(255) NOT NULL,\n" +
            "       skzc CHAR(255) NOT NULL,\n" +
            "       sksj INT NOT NULL,\n" +
            "       sksc INT NOT NULL,\n" +
            "       skxq INT NOT NULL\n" +
            ");";


    public CourseDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public CourseDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAT_COURSE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
