package com.lei.studycontentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by yanle on 2018/3/2.
 */

public class MyContentProvider extends ContentProvider{
    private SQLiteDatabase database;
    private static final int STUDENT = 1;
    private static final int TEACHER = 2;
    private static UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);//uri匹配器
    static{

        //添加uri匹配规则
        matcher.addURI("com.baidu","student",STUDENT);
        matcher.addURI("com.baidu","teacher",TEACHER);
    }
    //创建时调用
    @Override
    public boolean onCreate() {
        Log.i("tag","onCreate");
        try {
            SQLiteOpenHelper open = new MySQLiteOpenHelper(getContext());
            database = open.getWritableDatabase();
            return true;//返回true为成功，false为失败
        } catch(Exception e) {
            return false;
        }
    }

    @Nullable
    @Override//查数据
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        Log.i("tag","query");
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override//增加
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        Log.i("tag","insert");
        int results = matcher.match(uri);
        long result = -1;
        switch (results) {
            case STUDENT:
                result = database.insert("student",null,values);
                return Uri.parse("result://com.baidu/" + result);
            case TEACHER:
                result = database.insert("teacher",null,values);
                return Uri.parse("result://com.baidu/" + result);
        }

        return null;
    }

    @Override//删除
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.i("tag","delete");
        return 0;
    }

    @Override//修改
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        Log.i("tag","update");
        return 0;
    }
}
