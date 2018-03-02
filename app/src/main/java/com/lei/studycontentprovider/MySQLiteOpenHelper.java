package com.lei.studycontentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by yanle on 2018/3/2.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper{
    public MySQLiteOpenHelper(Context context) {
        super(context, "DATA.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //学生表
        db.execSQL("create table student (" +
                "id integer primary key autoincrement,name text, age integer)");
        //老师表
        db.execSQL("create table teacher (" +
                "id integer primary key autoincrement,name text, kemu text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
